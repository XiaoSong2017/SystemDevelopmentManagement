package controller;

import entity.ApiComponentEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ApiComponentService;

@Controller
public class ApiComponentController {
    @Autowired
    private ApiComponentService apiComponentService;

    public ApiComponentController() {
    }

    public ApiComponentService getApiComponentService() {
        return this.apiComponentService;
    }

    public void setApiComponentService(ApiComponentService apiComponentService) {
        this.apiComponentService = apiComponentService;
    }

    @RequestMapping({"/apiComponentAll"})
    @ResponseBody
    public List<ApiComponentEntity> getAll() {
        return this.apiComponentService.getAll();
    }
}