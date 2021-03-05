package sasf.net.sri.utils;

public class ImpuestoNotFoundException extends RuntimeException {

	  public ImpuestoNotFoundException(int id) {
	    super("Could not find impuesto " + id);
	  }
}