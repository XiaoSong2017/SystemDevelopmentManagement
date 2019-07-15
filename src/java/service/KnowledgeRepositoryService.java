package service;

import bean.Page;
import dao.KnowledgeRepositoryEntityDao;
import dao.KnowledgeTypeEntityDao;
import entity.KnowledgeRepositoryEntity;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KnowledgeRepositoryService {
    private KnowledgeTypeEntityDao knowledgeTypeEntityDao;
    private KnowledgeRepositoryEntityDao knowledgeRepositoryEntityDao;

    public KnowledgeRepositoryService() {
    }

    public void setKnowledgeTypeEntityDao(KnowledgeTypeEntityDao knowledgeTypeEntityDao) {
        this.knowledgeTypeEntityDao = knowledgeTypeEntityDao;
    }

    public void setKnowledgeRepositoryEntityDao(KnowledgeRepositoryEntityDao knowledgeRepositoryEntityDao) {
        this.knowledgeRepositoryEntityDao = knowledgeRepositoryEntityDao;
    }

    @Transactional(readOnly = true)
    public List<KnowledgeRepositoryEntity> getAll() {
        return knowledgeRepositoryEntityDao.getAll(KnowledgeRepositoryEntity.class);
    }

    @Transactional(readOnly = true)
    public Page<KnowledgeRepositoryEntity> getAllByPage(int pageNumber, int pageSize) {
        return knowledgeRepositoryEntityDao.getAllByPage(KnowledgeRepositoryEntity.class,pageNumber,pageSize);
    }
}
