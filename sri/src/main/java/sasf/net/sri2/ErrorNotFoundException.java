package sasf.net.sri2;

class ErrorNotFoundException extends RuntimeException {

	  ErrorNotFoundException(Long id) {
	    super("Could not find error " + id);
	  }
}