package sasf.net.sri2;

class ComprobanteNotFoundException extends RuntimeException {

	  ComprobanteNotFoundException(int id) {
	    super("Could not find comporbante " + id);
	  }
}