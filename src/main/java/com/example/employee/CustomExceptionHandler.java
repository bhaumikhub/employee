package com.example.employee;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class.getName());

	@Autowired
	ErrorDtls errorDtls;

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<ErrorDtls> handleCustomException(CustomException ex, WebRequest request) {
		ex.printStackTrace();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Timestamp startTs = new Timestamp(System.currentTimeMillis());
		this.errorDtls.setSvcInvoked(request.getDescription(false));
		this.errorDtls.setErrorCode("C0001");
		this.errorDtls.setTcId("");
		this.errorDtls.setErrorMsg(ex.getMessage());
		if (ex.getCause() != null)
			this.errorDtls.setStacktrace(ex.getCause().toString());
		this.errorDtls.setTimestamp(sdf.format(startTs));
		return new ResponseEntity<>(this.errorDtls, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDtls> handleAllException(Exception ex, WebRequest request) {
		ex.printStackTrace();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Timestamp startTs = new Timestamp(System.currentTimeMillis());
		this.errorDtls.setSvcInvoked(request.getDescription(false));
		this.errorDtls.setErrorCode("G0001");
		this.errorDtls.setTcId("");
		this.errorDtls.setErrorMsg(ex.getMessage());
		if (ex.getCause() != null)
			this.errorDtls.setStacktrace(ex.getCause().toString());
		this.errorDtls.setTimestamp(sdf.format(startTs));
		return new ResponseEntity<>(this.errorDtls, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
