package sasf.net.sri.utils;

public class ImpuestoTarifaNotFoundException extends RuntimeException {

	  public ImpuestoTarifaNotFoundException(int id) {
	    super("Could not find impuesto tarifa " + id);
	  }
}