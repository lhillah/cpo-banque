package model.exceptions;


public final class NotAuthorized extends Exception {

	public NotAuthorized(){super();}

	public NotAuthorized(String message){
		super(message);
	}
}