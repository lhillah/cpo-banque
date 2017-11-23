package model.impl;

import model.dec.CompteManip;
import model.exceptions.InsufficientBalance;

import java.util.logging.Logger;
/**
 * Models a check account.
 */
public final class CompteCourant extends Compte implements CompteManip {

		private static final Logger LOG = Logger.getLogger(CompteCourant.class.getCanonicalName());


		public CompteCourant(String owner, double initialBalance){
			super(owner, initialBalance);
		}

		public CompteCourant(String owner){
			super(owner);
		}

		@Override
		public double withdraw(double amount) throws InsufficientBalance {
			double previous = this.getBalance();
			try {
				if (previous - amount < 0.0d)
				   throw new InsufficientBalance("Overdraft. Current balance = " + previous);

			} catch (InsufficientBalance ex) {
				LOG.severe("Overdraft of " + (previous - amount) + " on account with balance " + previous);
				throw ex;
			}
			this.setBalance(previous - amount);
			return this.getBalance();
		}

		@Override
		public double deposit(double amount) {
			double previous = this.getBalance();
			this.setBalance(previous + amount);
			return this.getBalance();
		}

}