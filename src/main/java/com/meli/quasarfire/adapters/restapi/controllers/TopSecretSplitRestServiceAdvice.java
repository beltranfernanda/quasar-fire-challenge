/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */

package com.meli.quasarfire.adapters.restapi.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.meli.quasarfire.adapters.restapi.enums.MessagesRestExceptions;
import com.meli.quasarfire.adapters.restapi.exceptions.ExceptionResponseModel;
import com.meli.quasarfire.adapters.restapi.exceptions.IncorrectInformationException;
import com.meli.quasarfire.adapters.restapi.exceptions.NotPossibleInterceptShipInformationException;

/**
 * Class controller of exceptions
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
@RestControllerAdvice(assignableTypes = TopSecretSplitRestService.class)
public class TopSecretSplitRestServiceAdvice {
	/**
	 * Handle unexpected exceptions  
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @param request
	 * @return internal server error message
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public final ResponseEntity<ExceptionResponseModel> handleAllExceptions(WebRequest request) {
		ExceptionResponseModel exceptionResponse = new ExceptionResponseModel
				(new Date(), MessagesRestExceptions.ERROR_GENERAL.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Handle exceptions related with incorrect request
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @param request
	 * @return bad request exception message
	 */
	@ExceptionHandler(IncorrectInformationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<ExceptionResponseModel> handleIncorrectInformationException(WebRequest request) {
		ExceptionResponseModel exceptionResponse = new ExceptionResponseModel(new Date(), MessagesRestExceptions.ERROR_INCORRECT_INFORMATION_EXCEPTION.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Handle exceptions related with business logic 
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @param request
	 * @return not found exception message
	 */
	@ExceptionHandler(NotPossibleInterceptShipInformationException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public final ResponseEntity<ExceptionResponseModel> handleNotPossibleInterceptShipInformationException(WebRequest request) {
		ExceptionResponseModel exceptionResponse = new ExceptionResponseModel(new Date(), MessagesRestExceptions.ERROR_NOT_POSSIBLE_INTERCEPT_ENEMY_SPACESHIP_INFORMATION.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
