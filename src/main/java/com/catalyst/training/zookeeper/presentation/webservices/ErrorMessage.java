package com.catalyst.training.zookeeper.presentation.webservices;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	/**
	 * Used for passing error messages back to the user.
	 *
	 * Created by egover on 12/20/2015.
	 */
	public class ErrorMessage {

	    private List<String> errors;

	    public List<String> getErrors() {
	        return errors;
	    }

	    public void setErrors(List<String> errors) {
	        this.errors = errors;
	    }

	    public ErrorMessage() {
	        errors = new ArrayList<>();
	    }

	    public ErrorMessage(List<String> errors) {
	        this.errors = errors;
	    }

	    public ErrorMessage(String error) {
	        this.errors =Collections.singletonList(error);
	    }

	    public void addError(String error){
	        this.errors.add(error);
	    }

}
