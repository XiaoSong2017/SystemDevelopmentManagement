package controller;

import bean.Page;
import entity.KnowledgeRepositoryEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.KnowledgeRepositoryService;

@Controller
public class KnowledgeRepositoryController {
    @Autowired
    private KnowledgeRepositoryService knowledgeRepositoryService;

    public KnowledgeRepositoryController() {
    }

    @RequestMapping("/knowledgeRepositoryAll")
    @ResponseBody
    public List<KnowledgeRepositoryEntity> getAll() {
        return this.knowledgeRepositoryService.getAll();
    }

    @RequestMapping(value = "/knowledgeRepositoryAllByPage",method = RequestMethod.GET)
    @ResponseBody
    public Page<KnowledgeRepositoryEntity> getAllByPage(String pageNumber, String pageSize) {
        return knowledgeRepositoryService.getAllByPage(Integer.valueOf(pageNumber),Integer.valueOf(pageSize));
    }

    public void setKnowledgeRepositoryService(KnowledgeRepositoryService knowledgeRepositoryService) {
        this.knowledgeRepositoryService = knowledgeRepositoryService;
    }
}
