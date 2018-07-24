package pe.gob.mpfn.cfe.exception;

public class GestorDocumentalException extends Exception {
	private static final long serialVersionUID = 1L;

	public GestorDocumentalException(String message) {
		super(message);
	}
	
	public GestorDocumentalException(String message, Throwable cause) {
		super(message, cause);
	}
}
