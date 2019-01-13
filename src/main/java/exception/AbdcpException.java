package exception;

import javax.ws.rs.core.Response.Status;

public class AbdcpException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Status status;

	public AbdcpException(String message) {
		super(message);
		setStatus(Status.INTERNAL_SERVER_ERROR);
	}
	
	public AbdcpException(Status status, String message) {
		super(message);
		setStatus(status);
	}
	
	public AbdcpException(String message, Throwable cause) {
		super(message, cause);
		setStatus(Status.INTERNAL_SERVER_ERROR);
	}
	
	public AbdcpException(Status status, String message, Throwable cause) {
		super(message, cause);
		setStatus(status);
	}

	public Status getStatus() {
		return status;
	}
	
	private void setStatus(Status status) {
		this.status = status;
	}
}