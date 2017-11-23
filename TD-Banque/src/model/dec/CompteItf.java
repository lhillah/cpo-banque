package model.dec;


public interface CompteItf {

	 String getOwner();

	 String getNum();

	 double getBalance();

	 void setBalance(double newBalance);

	 double deposit(double amount);
}