package sasf.net.sri.utils;

public class RetencionFuenteNotFoundException extends RuntimeException {

	  public RetencionFuenteNotFoundException(int id) {
	    super("Could not find Retencion fuente " + id);
	  }
}