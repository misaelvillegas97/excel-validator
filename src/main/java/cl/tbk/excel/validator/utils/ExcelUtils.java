package cl.tbk.excel.validator.utils;

import cl.tbk.excel.validator.domain.models.ErrorHandler;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static cl.tbk.excel.validator.enums.ErrorMessagesEnum.*;

public class ExcelUtils {
    public static final String FILE_INITIAL_FORMAT_REQUIRED = "ADN_RM_SiebelM";
    public static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String NOT_VALID_MESSAGE = "El archivo no posee un formato de excel válido";
    public static final String NOT_VALID_NAME_MESSAGE = "El nombre del archivo debe iniciar con " + FILE_INITIAL_FORMAT_REQUIRED;
    public static final String NOT_VALID_UPLOAD_TIME = "Generación de archivo ITM será informada en proceso ADN del día siguiente hábil.";

    public static Boolean validateFileFormat(MultipartFile excelFile, List<ErrorHandler> errorList) {
        if (!hasExcelFormat(excelFile)) {
            ErrorHandler error = ErrorHandler.builder()
                    .errorLine(-1)
                    .errorMessage(ExcelUtils.NOT_VALID_MESSAGE)
                    .fieldName("File format")
                    .errorDescription(BAD_FORMAT_FILE.toObject())
                    .build();
            return errorList.add(error);
        }
        return false;
    }

    public static void validateFileInitialFormatName(MultipartFile excelFile, List<ErrorHandler> errorList) {
        if (!hasInitialFormatName(excelFile)) {
            ErrorHandler error = ErrorHandler.builder()
                    .errorLine(0)
                    .errorMessage(ExcelUtils.NOT_VALID_NAME_MESSAGE)
                    .fieldName("File name")
                    .errorDescription(FILE_BAD_INITIAL_NAME.toObject())
                    .build();
            errorList.add(error);
        }
    }

    public static void validateUploadTime(List<ErrorHandler> errorList) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limit = ExcelUtils.getTimeLimit();

        if (now.isAfter(limit)) {
            ErrorHandler error = ErrorHandler.builder()
                    .errorLine(0)
                    .errorMessage(ExcelUtils.NOT_VALID_UPLOAD_TIME)
                    .fieldName("Upload time")
                    .errorDescription(UPLOAD_OUT_OF_TIME.toObject())
                    .build();
            errorList.add(error);
        }
    }

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static boolean hasInitialFormatName(MultipartFile file) {
        return file.getName().startsWith(FILE_INITIAL_FORMAT_REQUIRED);
    }

    public static LocalDateTime getTimeLimit() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 30));
    }
}
