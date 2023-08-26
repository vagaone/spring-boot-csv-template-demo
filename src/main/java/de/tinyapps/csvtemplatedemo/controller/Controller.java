package de.tinyapps.csvtemplatedemo.controller;

import de.tinyapps.csvtemplatedemo.service.CsvService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class Controller {

    private final CsvService csvService;

    @Autowired
    public Controller(CsvService csvService) {
        this.csvService = csvService;
    }

    @GetMapping(value = "/csv", produces = "application/csv")
    public ResponseEntity<String> getCsv() throws TemplateException, IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=export.csv");
        return ResponseEntity.ok().headers(headers).body(csvService.loadExport());
    }

}
