package com.catalyst.training.zookeeper.presentation.webservices;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.catalyst.training.zookeeper.business.InvalidInputException;
import com.catalyst.training.zookeeper.daos.NoEntryFoundException;
import com.catalyst.training.zookeeper.daos.NonUniqueValueException;

//	import com.catalystdevworks.training.angulardemo.business.InvalidInputException;
//	import com.catalystdevworks.training.angulardemo.daos.NoEntryFoundException;
//	import com.catalystdevworks.training.angulardemo.daos.NonUniqueValueException;

/**
 * Validation handler
 *
 * @author amack, rmcguirk, bneill, ccrosby, egover
 */
@ControllerAdvice
@ResponseBody
public class ExceptionController {
	private static Logger logger = Logger.getLogger(ExceptionController.class);

	@Autowired
	private MessageSource msgSource;

	public void setMsgSource(MessageSource msgSource) {
		this.msgSource = msgSource;
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleException(Exception e) {
		e.printStackTrace();
		logger.error(e);
		return new ErrorMessage("An error has occurred, please contain an administrator if this continues.");
	}

	@ExceptionHandler(value = InvalidInputException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleInvalidInputExceptions(InvalidInputException e) {

		ErrorMessage message = new ErrorMessage();

		List<String> errorCodes = e.getErrorList();
		for (String error : errorCodes) {
			try {
				message.addError(lookupErrorMessage(error));

			} catch (NoSuchMessageException ex) {
				logger.error("Message not found.", ex);
			}
		}

		return message;
	}

	@ExceptionHandler(value = NonUniqueValueException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleNonUniqueValueException(NonUniqueValueException e) {
		try {
			return new ErrorMessage(lookupErrorMessage(e.getMessage()));

		} catch (NoSuchMessageException ex) {
			logger.error(ex);
			return new ErrorMessage(
					"Please check the information supplied. Certain fields can not match information already stored");
		}
	}

	@ExceptionHandler(value = NoEntryFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleNoEntryFoundException(NoEntryFoundException e) {
		try {
			return new ErrorMessage(lookupErrorMessage(e.getMessage()));

		} catch (NoSuchMessageException ex) {
			ex.printStackTrace();
			logger.error(ex);
			return new ErrorMessage(
					"Please check the information supplied. No value could be found with the information provided.");
		}
	}

	private String lookupErrorMessage(String errorCode) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		return msgSource.getMessage(errorCode, null, currentLocale);
	}

}
