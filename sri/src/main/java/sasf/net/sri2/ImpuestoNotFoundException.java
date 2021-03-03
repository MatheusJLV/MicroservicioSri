package sasf.net.sri2;

class ImpuestoNotFoundException extends RuntimeException {

	  ImpuestoNotFoundException(int id) {
	    super("Could not find impuesto " + id);
	  }
}