package sasf.net.sri.utils;

public class ErrorNotFoundException extends RuntimeException {

	  public ErrorNotFoundException(int id) {
	    super("Could not find error " + id);
	  }
}