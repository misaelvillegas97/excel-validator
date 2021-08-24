package cl.tbk.excel.validator.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorHandler {
    private int errorLine;
    private String fieldName;
    private String errorMessage;
    private ErrorMessageHandler errorDescription;
}
