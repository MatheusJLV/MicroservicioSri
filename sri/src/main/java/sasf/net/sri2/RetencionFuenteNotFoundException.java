package sasf.net.sri2;

class RetencionFuenteNotFoundException extends RuntimeException {

	  RetencionFuenteNotFoundException(int id) {
	    super("Could not find Retencion fuente " + id);
	  }
}