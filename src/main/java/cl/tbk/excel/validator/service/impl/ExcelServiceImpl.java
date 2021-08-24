package cl.tbk.excel.validator.service.impl;

import cl.tbk.excel.validator.domain.models.ErrorHandler;
import cl.tbk.excel.validator.service.ExcelService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static cl.tbk.excel.validator.utils.ExcelUtils.*;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public List<ErrorHandler> excelReceiver(MultipartFile excelFile) {
        List<ErrorHandler> errorList = new ArrayList<>();

        // Validate File Format (.xlsx)
        if (validateFileFormat(excelFile, errorList)) return errorList;

        // Validate file initial name
        validateFileInitialFormatName(excelFile, errorList);

        // Validate uploaded time
        validateUploadTime(errorList);
        return errorList;
    }
}
