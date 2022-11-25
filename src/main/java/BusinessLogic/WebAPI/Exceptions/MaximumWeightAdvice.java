package BusinessLogic.WebAPI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MaximumWeightAdvice {

    @ResponseBody
    @ExceptionHandler(MaximumWeightException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String maximumWeightHandler(MaximumWeightException ex) {
        return ex.getMessage();
    }
}
