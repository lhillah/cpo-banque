package model.exceptions;

public final class InsufficientBalance extends Exception {

	public InsufficientBalance(){
		super();
	}

	public InsufficientBalance(String message){
		super(message);
	}

}