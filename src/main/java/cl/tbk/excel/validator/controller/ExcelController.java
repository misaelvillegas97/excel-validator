package cl.tbk.excel.validator.controller;

import cl.tbk.excel.validator.constants.LocalConstants;
import cl.tbk.excel.validator.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping(LocalConstants.ENDPOINT_EXCEL_FEATURES)
public class ExcelController {

    private ExcelService excelService;

    @Autowired
    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping
    public ResponseEntity excelReceiver(@RequestParam MultipartFile excelFile) {
        excelService.excelReceiver(excelFile);
        System.out.println("excelReceiver");
        return ResponseEntity.ok().body("");
    }
}
