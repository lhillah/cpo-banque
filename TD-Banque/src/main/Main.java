package main;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.io.IOException;

import model.dec.CompteManip;
import model.fact.CompteFactory;
import model.exceptions.InsufficientBalance;

public final class Main {

	private static final Logger LOG = Logger.getLogger(Main.class.getCanonicalName());

	public static void main(String[] args) {
		try {
			Handler handler = new FileHandler("bank.log", true);
			handler.setLevel(Level.FINE);
			LOG.addHandler(handler);
		} catch (IOException ioe) {
			LOG.warning("Fichier introuvable !");
		}
		
		CompteFactory cf = new CompteFactory();

		CompteManip c1 = cf.createCompteCourant("John Doe");
		CompteManip c2 = cf.createCompteCourant("Jack Bauer");

		c1.deposit(1500.0d);
		double amount = 1900.0d;
		try {
			double retrait = c1.withdraw(amount);
		} catch (InsufficientBalance ex) {
			LOG.severe(ex.getMessage());
		} finally {
			//System.out.println("bloc finally");
			LOG.fine("Withdraw operation of " + amount);
		}
		double nouveauSolde = c2.deposit(100000.0d);

		LOG.info(c1.toString());
		System.out.println(c2.toString());
	}

}