package dao;

import bean.Page;
import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    T getById(@NotNull Class<T> entityClass, @NotNull Object id);

    Serializable save(@NotNull T entity);

    void update(@NotNull T entity);

    void saveOrUpdate(@NotNull T entity);

    void delete(@NotNull T entity);

    void delete(@NotNull Class<T> entityClass, @NotNull Object id);

    List<T> getAll(@NotNull Class<T> entityClass);

    Page getAllByPage(@NotNull Class<T> entityClass, int pageNumber, int pageSize);

    long count(@NotNull Class<T> entityClass);

    void batchToSave(@NotNull List<T> entities);

    void batchToUpdate(@NotNull List<T> entities);

    void batchToDelete(@NotNull Class<T> entityClass, @NotNull List<String> id);
}
