package pl.codeme.examples.exceptions;

public class MyException extends ParentException {
	private static final long serialVersionUID = 1L;
	
	private String exceptionCreator;
	
	public MyException(String creator) {
		this.exceptionCreator = creator;
	}
	
	public String getExceptionCreator() {
		return exceptionCreator;
	}

}
