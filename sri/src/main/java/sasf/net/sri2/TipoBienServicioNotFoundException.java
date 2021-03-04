package sasf.net.sri2;

class TipoBienServicioNotFoundException extends RuntimeException {

	  TipoBienServicioNotFoundException(int id) {
	    super("Could not find Tipo Bien Servicio " + id);
	  }
}