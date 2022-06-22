package com.employee.employee.exception;


public class EmployeeMgmtException extends Exception{

	/**
	 *  The Generated Serial Version UID
	 */
	private static final long serialVersionUID = -8669082903748063582L;
	
	private String errorCode;

	public EmployeeMgmtException() {
		super();
	}
	
	public EmployeeMgmtException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
	
}
