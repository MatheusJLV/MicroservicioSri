package sasf.net.sri.utils;

public class TipoBienServicioNotFoundException extends RuntimeException {

	  public TipoBienServicioNotFoundException(int id) {
	    super("Could not find Tipo Bien Servicio " + id);
	  }
}