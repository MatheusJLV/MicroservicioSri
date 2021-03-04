package sasf.net.sri2;

class ClaseContribuyenteRtfNotFoundException extends RuntimeException {

	  ClaseContribuyenteRtfNotFoundException(int id) {
	    super("Could not find Clase contribuyente " + id);
	  }
}