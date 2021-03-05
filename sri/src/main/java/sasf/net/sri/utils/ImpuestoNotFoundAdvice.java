package sasf.net.sri.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ImpuestoNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ImpuestoNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String puntoEmisionNotFoundHandler(ImpuestoNotFoundException ex) {
    return ex.getMessage();
  }
}