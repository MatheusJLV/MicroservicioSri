package sasf.net.sri2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ComprobanteNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ComprobanteNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String comprobanteNotFoundHandler(ComprobanteNotFoundException ex) {
    return ex.getMessage();
  }
}