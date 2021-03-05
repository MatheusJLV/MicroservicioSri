package sasf.net.sri.utils;

class RetencionFuentePorcentajeNotFoundException extends RuntimeException {

	  RetencionFuentePorcentajeNotFoundException(int id) {
	    super("Could not find Retencion fuente porcentaje " + id);
	  }
}