package service;

import dao.ApiComponentEntityDao;
import dao.ApiComponentTypeEntityDao;
import entity.ApiComponentEntity;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApiComponentService {
    private ApiComponentEntityDao apiComponentEntityDao;
    private ApiComponentTypeEntityDao apiComponentTypeEntityDao;

    public ApiComponentService() {
    }

    public ApiComponentEntityDao getApiComponentEntityDao() {
        return this.apiComponentEntityDao;
    }

    public void setApiComponentEntityDao(ApiComponentEntityDao apiComponentEntityDao) {
        this.apiComponentEntityDao = apiComponentEntityDao;
    }

    public ApiComponentTypeEntityDao getApiComponentTypeEntityDao() {
        return this.apiComponentTypeEntityDao;
    }

    public void setApiComponentTypeEntityDao(ApiComponentTypeEntityDao apiComponentTypeEntityDao) {
        this.apiComponentTypeEntityDao = apiComponentTypeEntityDao;
    }

    @Transactional(
        readOnly = true
    )
    public List<ApiComponentEntity> getAll() {
        return this.apiComponentEntityDao.getAll(ApiComponentEntity.class);
    }
}
