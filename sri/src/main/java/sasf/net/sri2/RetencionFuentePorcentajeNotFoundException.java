package sasf.net.sri2;

class RetencionFuentePorcentajeNotFoundException extends RuntimeException {

	  RetencionFuentePorcentajeNotFoundException(int id) {
	    super("Could not find Retencion fuente porcentaje " + id);
	  }
}