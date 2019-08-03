package controller;

import bean.Page;
import com.alibaba.fastjson.JSONObject;
import entity.ApiComponentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ApiComponentService;

import java.util.List;

@Controller
public class ApiComponentController {

    private final ApiComponentService apiComponentService;

    public ApiComponentController(ApiComponentService apiComponentService) {
        this.apiComponentService = apiComponentService;
    }

    @RequestMapping("/apiComponentAll")
    @ResponseBody
    public List<ApiComponentEntity> getAll() {
        return apiComponentService.getAll();
    }

    @RequestMapping(value = "/apiComponentAllByPage", method = RequestMethod.POST)
    @ResponseBody
    public Page<ApiComponentEntity> getAllByPage(int pageNumber, int pageSize) {
        return apiComponentService.getAllByPage(pageNumber, pageSize);
    }

    @RequestMapping(value = "/deleteApiComponentById", method = RequestMethod.POST)
    @ResponseBody
    public String deleteApiComponentById(int id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", apiComponentService.deleteApiComponentById(id));
        return jsonObject.toJSONString();
    }
}
