package sasf.net.sri.utils;

public class ComprobanteNotFoundException extends RuntimeException {

	  public ComprobanteNotFoundException(int id) {
	    super("Could not find comporbante " + id);
	  }
}