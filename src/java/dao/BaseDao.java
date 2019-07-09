package dao;

import bean.Page;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    T getById(@NotNull Class<T> var1, @NotNull Object var2);

    Serializable save(@NotNull T var1);

    void update(@NotNull T var1);

    void saveOrUpdate(@NotNull T var1);

    void delete(@NotNull T var1);

    void delete(@NotNull Class<T> var1, @NotNull Object var2);

    List<T> getAll(@NotNull Class<T> var1);

    Page getAllByPage(@NotNull Class<T> var1, int var2, int var3);

    long count(@NotNull Class<T> var1);

    void batchToSave(@NotNull List<T> var1);

    void batchToUpdate(@NotNull List<T> var1);

    void batchToDelete(@NotNull Class<T> entityClass,@NotNull List<String> id);
}
