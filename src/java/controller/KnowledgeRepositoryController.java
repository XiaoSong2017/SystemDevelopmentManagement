package controller;

import bean.Page;
import com.alibaba.fastjson.JSONObject;
import com.sun.istack.NotNull;
import entity.KnowledgeRepositoryEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.KnowledgeRepositoryService;

import java.util.List;

@Controller
public class KnowledgeRepositoryController {

    private final KnowledgeRepositoryService knowledgeRepositoryService;

    public KnowledgeRepositoryController(KnowledgeRepositoryService knowledgeRepositoryService) {
        this.knowledgeRepositoryService = knowledgeRepositoryService;
    }

    @RequestMapping("/knowledgeRepositoryAll")
    @ResponseBody
    public String getAll() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",knowledgeRepositoryService.getAll());
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/knowledgeRepositoryAllByPage", method = RequestMethod.POST)
    @ResponseBody
    public Page<KnowledgeRepositoryEntity> getAllByPage(Integer pageNumber, Integer pageSize) {
        return knowledgeRepositoryService.getAllByPage(pageNumber, pageSize);
    }

    @RequestMapping(value = "/knowledgeRepositoryById", method = RequestMethod.POST)
    @ResponseBody
    public @NotNull
    KnowledgeRepositoryEntity getKnowledgeRepositoryById(@NotNull Integer id){
        return knowledgeRepositoryService.getKnowledgeRepositoryById(id);
    }

    @RequestMapping(value = "/deleteKnowledgeRepositoryById", method = RequestMethod.POST)
    @ResponseBody
    public String deleteKnowledgeRepositoryById(int id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", knowledgeRepositoryService.deleteKnowledgeRepositoryById(id));
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/saveKnowledgeRepository", method = RequestMethod.POST)
    @ResponseBody
    public String saveKnowledgeRepository(@NotNull KnowledgeRepositoryEntity knowledgeRepositoryEntity) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", knowledgeRepositoryService.saveKnowledgeRepository(knowledgeRepositoryEntity));
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/updateKnowledgeRepository", method = RequestMethod.POST)
    @ResponseBody
    public String updateKnowledgeRepository(@NotNull KnowledgeRepositoryEntity knowledgeRepository) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", knowledgeRepositoryService.updateKnowledgeRepository(knowledgeRepository));
        return jsonObject.toJSONString();
    }
}
