package Contract.Repository;

import Entities.Common.IEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public interface IGenericRepository<T extends IEntity> {
    Optional<T> getById(UUID id);
    List<T> getAll();
    void add(T item);
    void update(T item);
    void delete(UUID id);
    void deleteWhere(Predicate<T> predicate);
    void deleteAll();
    boolean exists(UUID id);
    Optional<T> where(Predicate<T> predicate);
    List<T> whereList(Predicate<T> predicate);
    int countWhere(Predicate<T> predicate);
    int count();
}
