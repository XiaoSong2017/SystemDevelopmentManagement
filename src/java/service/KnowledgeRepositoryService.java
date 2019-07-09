package service;

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

    public KnowledgeTypeEntityDao getKnowledgeTypeEntityDao() {
        return this.knowledgeTypeEntityDao;
    }

    public void setKnowledgeTypeEntityDao(KnowledgeTypeEntityDao knowledgeTypeEntityDao) {
        this.knowledgeTypeEntityDao = knowledgeTypeEntityDao;
    }

    public KnowledgeRepositoryEntityDao getKnowledgeRepositoryEntityDao() {
        return this.knowledgeRepositoryEntityDao;
    }

    public void setKnowledgeRepositoryEntityDao(KnowledgeRepositoryEntityDao knowledgeRepositoryEntityDao) {
        this.knowledgeRepositoryEntityDao = knowledgeRepositoryEntityDao;
    }

    @Transactional(
        readOnly = true
    )
    public List<KnowledgeRepositoryEntity> getAll() {
        return this.knowledgeRepositoryEntityDao.getAll(KnowledgeRepositoryEntity.class);
    }
}
