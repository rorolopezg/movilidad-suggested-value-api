package pa.com.sura.apisuggestedvalue.errors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApiError implements Serializable {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String trace;
    private String requestId;
    private String path;
    private String documentationUrl;
    private String suggestion;
    private List<ApiSubError> errorsDetails;

    private ApiError() {
        super();
        timestamp = LocalDateTime.now();
        errorsDetails = new ArrayList<>();
    }

    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    public ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.trace = "";
        if (ex != null) {
            String t = ex.getCause() != null ? ex.getCause().getLocalizedMessage() : "";
            t = t.isEmpty() ? ex.getLocalizedMessage() : "";
            this.trace = t;
        }
    }

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this(status, ex);
        this.message = message;
    }

    public ApiError(HttpStatus status, String message, String path, String requestId, String documentation_url) {
        this(status, message, null);
        this.path = path;
        this.requestId = requestId;
        this.documentationUrl = documentation_url;
        this.trace = "";
    }

    public ApiError(HttpStatus status, String message, Throwable ex, String path, String requestId,
            String documentation_url) {
        this(status, message, ex);
        this.path = path;
        this.requestId = requestId;
        this.documentationUrl = documentation_url;
    }
}
