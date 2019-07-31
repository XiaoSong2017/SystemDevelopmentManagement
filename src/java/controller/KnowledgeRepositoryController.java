package controller;

import bean.Page;
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
    public List<KnowledgeRepositoryEntity> getAll() {
        return this.knowledgeRepositoryService.getAll();
    }

    @RequestMapping(value = "/knowledgeRepositoryAllByPage", method = RequestMethod.POST)
    @ResponseBody
    public Page<KnowledgeRepositoryEntity> getAllByPage(Integer pageNumber, Integer pageSize) {
        return knowledgeRepositoryService.getAllByPage(pageNumber, pageSize);
    }
}
