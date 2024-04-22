package pa.com.sura.apisuggestedvalue.errors;

import lombok.Data;

@Data
public class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiValidationError(String object, String message) {
        super();
        this.object = object;
        this.message = message;
    }

}
