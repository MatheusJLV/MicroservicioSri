package sasf.net.sri.utils;

public class ClaseContribuyenteRtfNotFoundException extends RuntimeException {

	  public ClaseContribuyenteRtfNotFoundException(int id) {
	    super("Could not find Clase contribuyente " + id);
	  }
}