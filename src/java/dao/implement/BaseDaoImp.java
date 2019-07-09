package dao.implement;

import bean.Page;
import dao.BaseDao;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class BaseDaoImp<T> implements BaseDao<T> {
    private SessionFactory sessionFactory;

    private Page<T> page;

    public BaseDaoImp() {
    }

    protected SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    public T getById(Class<T> entityClass, Object id) {
        List list;
        try {
            list = this.getSessionFactory().getCurrentSession().createQuery("from " + entityClass.getSimpleName() + " en where en.id=?1").setParameter(1, entityClass.getField("id").getType().cast(id)).getResultList();
        } catch (NoSuchFieldException var5) {
            var5.printStackTrace();
            return null;
        }

        return list.size() == 0 ? null : (T) list.get(0);
    }

    public Serializable save(T entity) {
        return this.getSessionFactory().getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        this.getSessionFactory().getCurrentSession().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        this.getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        this.getSessionFactory().getCurrentSession().delete(entity);
    }

    @Override
    public void delete(Class<T> entityClass, Object id) {
        try {
            this.getSessionFactory().getCurrentSession().createQuery("delete from " + entityClass.getSimpleName() + " en where en.id=?1").setParameter(1, entityClass.getField("id").getType().cast(id)).executeUpdate();
        } catch (NoSuchFieldException var4) {
            var4.printStackTrace();
        }

    }

    @Override
    public List<T> getAll(Class<T> entityClass) {
        return this.getSessionFactory().getCurrentSession().createQuery("from " + entityClass.getSimpleName()).getResultList();
    }

    @Override
    public Page getAllByPage(Class<T> entityClass, int pageNumber, int pageSize) {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from " + entityClass.getSimpleName());
        this.page.setCurrentPage((long)pageNumber);
        this.page.setPageSize((long)pageSize);
        this.page.setTotalRecords((long)query.getMaxResults());
        query.setMaxResults(pageSize);
        this.page.setTotalPageNo(Math.round(Math.ceil((double)query.getMaxResults() / (double)pageSize)));
        this.page.setData(query.setFirstResult(pageNumber - 1).setMaxResults(pageSize).getResultList());
        return this.page;
    }

    @Override
    public long count(Class<T> entityClass) {
        return (long)Integer.valueOf(String.valueOf(this.getSessionFactory().getCurrentSession().createQuery("select count(*) from " + entityClass.getSimpleName()).getSingleResult()));
    }

    @Override
    public void batchToSave(List<T> entities) {
        for(int i = 0; i < entities.size(); ++i) {
            this.sessionFactory.getCurrentSession().save(entities.get(i));
            if (i % 20 == 0) {
                this.sessionFactory.getCurrentSession().flush();
                this.sessionFactory.getCurrentSession().clear();
            }
        }

    }

    @Override
    public void batchToUpdate(List<T> entities) {
        for (T entity : entities) {
            sessionFactory.getCurrentSession().update(entity);
        }
    }


    @Override
    public void batchToDelete(Class<T> entityClass, List<String> id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from " + entityClass.getSimpleName() + " en where en.id=?1");
        for (String i : id) {
            query.setParameter(1, i);
        }
        query.executeUpdate();
    }
}
