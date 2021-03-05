package sasf.net.sri.utils;

public class PuntoEmisionNotFoundException extends RuntimeException {

	  public PuntoEmisionNotFoundException(int id) {
	    super("Could not find punto de emision " + id);
	  }
}