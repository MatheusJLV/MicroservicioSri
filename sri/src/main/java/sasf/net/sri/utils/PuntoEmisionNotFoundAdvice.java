package sasf.net.sri.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PuntoEmisionNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(PuntoEmisionNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String puntoEmisionNotFoundHandler(PuntoEmisionNotFoundException ex) {
    return ex.getMessage();
  }
}