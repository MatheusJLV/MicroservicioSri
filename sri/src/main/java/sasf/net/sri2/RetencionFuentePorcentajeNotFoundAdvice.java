package sasf.net.sri2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class RetencionFuentePorcentajeNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(RetencionFuentePorcentajeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String puntoEmisionNotFoundHandler(RetencionFuentePorcentajeNotFoundException ex) {
    return ex.getMessage();
  }
}