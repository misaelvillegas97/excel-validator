package cl.tbk.excel.validator.enums;

import cl.tbk.excel.validator.domain.models.ErrorMessageHandler;
import lombok.Getter;

import static cl.tbk.excel.validator.constants.StatusContextConstant.*;

@Getter
public enum ErrorMessagesEnum {

    FIELD_REQUIRED(1, REQUIRED, "El campo es obligatorio."),
    FIELD_HAS_DEPENDENCY(2, DEPENDENCY, "El campo contiene una dependencia."),
    FILE_BAD_INITIAL_NAME(3, BAD_FORMAT, "El nombre del archivo no contiene el formato requerido."),
    FILE_BAD_DATE_FORMAT(4, BAD_FORMAT, "La fecha en el nombre del archivo, no contiene el formato requerido."),
    BAD_FORMAT_FILE(5, BAD_FORMAT, "El archivo proporcionado no corresponde al formato .XLSX"),
    UPLOAD_OUT_OF_TIME(6, OUT_OF_TIME, "Generación de archivo ITM será informada en proceso ADN del día siguiente hábil");


    private final int id;
    private final String type;
    private final String detail;

    ErrorMessagesEnum(int id, String type, String detail) {
        this.id = id;
        this.type = type;
        this.detail = detail;
    }


    public ErrorMessageHandler toObject() {
        return ErrorMessageHandler.builder()
                .id(this.id)
                .type(this.type)
                .detail(this.detail)
                .build();
    }
}
