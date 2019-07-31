package controller;

import bean.Page;
import entity.DataDictionaryEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DataDictionaryService;

import java.util.List;

@Controller
public class DataDictionaryController {

    private final DataDictionaryService dataDictionaryService;

    public DataDictionaryController(DataDictionaryService dataDictionaryService) {
        this.dataDictionaryService = dataDictionaryService;
    }

    @RequestMapping("/dataDictionaryAll")
    @ResponseBody
    public List<DataDictionaryEntity> getAll() {
        return dataDictionaryService.getAll();
    }

    @RequestMapping(value = "/dataDictionaryAllByPage", method = RequestMethod.POST)
    @ResponseBody
    public Page<DataDictionaryEntity> getAllByPage(int pageNumber, int pageSize) {
        return dataDictionaryService.getAllByPage(pageNumber, pageSize);
    }
}
