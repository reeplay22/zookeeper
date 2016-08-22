package com.catalyst.training.zookeeper.business;

import java.util.List;

/**
 * This exception should be thrown when invalid input is found. The message
 * should contain any status codes/messages needed to explain to the user what
 * was invalid and why.
 * 
 * @author treed
 *
 */
public class InvalidInputException extends Exception {

	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> errorList;

	/**
	 * Constructor of the custom Exception class
	 * 
	 * @param message
	 */
	public InvalidInputException(String message) {
		super(message);
	}
	
	public InvalidInputException(List<String> errorList){
		this.errorList = errorList;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

}
