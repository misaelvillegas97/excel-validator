package cl.tbk.excel.validator.service;

import cl.tbk.excel.validator.domain.models.ErrorHandler;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    List<ErrorHandler> excelReceiver(MultipartFile excelFile);
}
