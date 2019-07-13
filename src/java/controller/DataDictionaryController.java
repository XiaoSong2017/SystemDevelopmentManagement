package controller;

import entity.DataDictionaryEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DataDictionaryService;

@Controller
public class DataDictionaryController {
    @Autowired
    private DataDictionaryService dataDictionaryService;

    public DataDictionaryController() {
    }

    @RequestMapping("/dataDictionaryAll")
    @ResponseBody
    public List<DataDictionaryEntity> getAll() {
        return this.dataDictionaryService.getAll();
    }

    public void setDataDictionaryService(DataDictionaryService dataDictionaryService) {
        this.dataDictionaryService = dataDictionaryService;
    }
}
