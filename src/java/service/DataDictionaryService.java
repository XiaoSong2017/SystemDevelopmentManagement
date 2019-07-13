package service;

import dao.DataDictionaryEntityDao;
import entity.DataDictionaryEntity;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataDictionaryService {
    private DataDictionaryEntityDao dataDictionaryEntityDao;

    public DataDictionaryService() {
    }

    public DataDictionaryEntityDao getDataDictionaryEntityDao() {
        return this.dataDictionaryEntityDao;
    }

    public void setDataDictionaryEntityDao(DataDictionaryEntityDao dataDictionaryEntityDao) {
        this.dataDictionaryEntityDao = dataDictionaryEntityDao;
    }

    @Transactional(readOnly = true)
    public List<DataDictionaryEntity> getAll() {
        return this.dataDictionaryEntityDao.getAll(DataDictionaryEntity.class);
    }
}
