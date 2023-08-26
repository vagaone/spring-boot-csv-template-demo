package de.tinyapps.csvtemplatedemo.service;

import de.tinyapps.csvtemplatedemo.repository.Book;
import de.tinyapps.csvtemplatedemo.repository.BookRepo;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class CsvService {
    private final FreeMarkerConfigurer freeMarkerConfigurer;
    private final BookRepo bookRepo;
    private static final String SEPERATOR = ";"; // we are using ; as seperator, so ms excel can open it

    @Autowired
    public CsvService(FreeMarkerConfigurer freeMarkerConfigurer, BookRepo bookRepo) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
        this.bookRepo = bookRepo;
    }

    public String loadExport() throws TemplateException, IOException {
        return createCsv(bookRepo.listBooks());
    }

    private String createCsv(List<Book> books) throws IOException, TemplateException {

        // create the template model
        var templateModel = new HashMap<String, Object>();
        templateModel.put("sep", SEPERATOR); // define a seperator char for your csv file
        templateModel.put("books", books); // input the books records

        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("booklist.ftl"); // load the template
        var csv = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateModel); // generate the csv string
        return csv;
    }

}
