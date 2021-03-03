package sasf.net.sri2;

class ImpuestoTarifaNotFoundException extends RuntimeException {

	  ImpuestoTarifaNotFoundException(int id) {
	    super("Could not find impuesto tarifa " + id);
	  }
}