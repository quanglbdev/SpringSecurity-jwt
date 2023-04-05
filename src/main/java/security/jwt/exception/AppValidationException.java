package security.jwt.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppValidationException extends javax.validation.ValidationException {

  private String type;

  public AppValidationException() {
    super();
  }

  public AppValidationException(String message) {
    super(message);
  }

  public AppValidationException(String message, String type) {
    super(message);
    this.type = type;
  }

  public AppValidationException(String message, Throwable cause) {
    super(message, cause);
  }

  public AppValidationException(Throwable cause) {
    super(cause);
  }
}
