package sasf.net.sri2;

class PuntoEmisionNotFoundException extends RuntimeException {

	  PuntoEmisionNotFoundException(int id) {
	    super("Could not find punto de emision " + id);
	  }
}