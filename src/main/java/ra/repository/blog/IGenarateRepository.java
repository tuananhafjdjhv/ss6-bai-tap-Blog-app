package ra.repository.blog;

import java.util.List;

public interface IGenarateRepository<T> {
    List<T> findAll();

    T findById(int id);

    void save(T t);

    void remove(int id);
}
