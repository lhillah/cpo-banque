package model.impl;

import java.util.UUID;
import java.lang.StringBuilder;

import model.dec.CompteItf;

/**
 * Models the concept of bank account.
 */
public abstract class Compte implements CompteItf {

	private final String owner;
	private final String num;
	private double balance;

	public Compte(String owner, double initialBalance) {
		this.owner = owner;
		this.balance = initialBalance;
		this.num = UUID.randomUUID().toString();
	}

	public Compte(String owner) {
		this(owner, 0.0d);
	}

	@Override
	public String getOwner(){return this.owner;}
	
	@Override
	public String getNum(){return this.num;}

	@Override
	public double getBalance() {return this.balance;}

	@Override
	public void setBalance(double newBalance) {this.balance = newBalance;}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Compte ").append(num).append("\n")
		  .append("Owner: ").append(owner).append("\n")
		  .append("Balance: ").append(balance).append("\n");
		return sb.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
		if (!other.getClass().getCanonicalName().equals(this.getClass().getCanonicalName()))
			return false;
		Compte c = (Compte)other;
		return this.num.equals(c.num) && this.owner.equals(c.owner);
	}

	public abstract double deposit(double amount);

}