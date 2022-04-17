package com.example.employee;

import org.springframework.stereotype.Service;

@Service
public class ErrorDtls {

	private String tcId;
	private String svcInvoked;
	private String errorCode;
	private String errorMsg;
	private String stacktrace;
	private String resolution;
	private String timestamp;

	public ErrorDtls() {
		// Do Nothing
	}

	public ErrorDtls(String tcId, String svcInvoked, String errorCode, String errorMsg, String stacktrace,
			String resolution, String timestamp) {
		super();
		this.tcId = tcId;
		this.svcInvoked = svcInvoked;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.stacktrace = stacktrace;
		this.resolution = resolution;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorDtls [tcId=" + tcId + ", svcInvoked=" + svcInvoked + ", errorCode=" + errorCode + ", errorMsg="
				+ errorMsg + ", stacktrace=" + stacktrace + ", resolution=" + resolution + ", timestamp=" + timestamp
				+ "]";
	}

	/**
	 * @return the tcId
	 */
	public String getTcId() {
		return tcId;
	}

	/**
	 * @param tcId the tcId to set
	 */
	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

	/**
	 * @return the svcInvoked
	 */
	public String getSvcInvoked() {
		return svcInvoked;
	}

	/**
	 * @param svcInvoked the svcInvoked to set
	 */
	public void setSvcInvoked(String svcInvoked) {
		this.svcInvoked = svcInvoked;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the stacktrace
	 */
	public String getStacktrace() {
		return stacktrace;
	}

	/**
	 * @param stacktrace the stacktrace to set
	 */
	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	/**
	 * @return the resolution
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * @param resolution the resolution to set
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
