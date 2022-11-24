package BusinessLogic.WebAPI;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class IncorrectTrayAdvice {

    @ResponseBody
    @ExceptionHandler(IncorrectTrayException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String incorrectTrayHandler(IncorrectTrayException ex) {
        return ex.getMessage();
    }
}
