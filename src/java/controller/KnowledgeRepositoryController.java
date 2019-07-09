package controller;

import entity.KnowledgeRepositoryEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.KnowledgeRepositoryService;

@Controller
public class KnowledgeRepositoryController {
    @Autowired
    private KnowledgeRepositoryService knowledgeRepositoryService;

    public KnowledgeRepositoryController() {
    }

    @RequestMapping({"/knowledgeRepositoryAll"})
    @ResponseBody
    public List<KnowledgeRepositoryEntity> getAll() {
        return this.knowledgeRepositoryService.getAll();
    }

    public KnowledgeRepositoryService getKnowledgeRepositoryService() {
        return this.knowledgeRepositoryService;
    }

    public void setKnowledgeRepositoryService(KnowledgeRepositoryService knowledgeRepositoryService) {
        this.knowledgeRepositoryService = knowledgeRepositoryService;
    }
}
