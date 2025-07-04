package Implementation.Repository;

import Contract.Repository.IGenericRepository;
import Entities.Common.IEntity;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class GenericRepository<T extends IEntity> implements IGenericRepository<T> {
    private final List<T> table;
    private final TableName tableName;

    public GenericRepository(TableName tableName) {
        this.tableName = tableName;
        this.table = InMemoryDatabase.getInstance().getTable(tableName);
    }

    @Override
    public Optional<T> getById(UUID id) {
        for (T item : table) {
            if (item.getId().equals(id)) return Optional.of(item);
        }
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(table);
    }

    @Override
    public void add(T item) {
        if (!exists(item.getId())) {
            table.add(item);
        }
    }

    @Override
    public void update(T item) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getId().equals(item.getId())) {
                table.set(i, item);
                return;
            }
        }
    }

    @Override
    public void delete(UUID id) {
        table.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public void deleteWhere(Predicate<T> predicate) {
        table.removeIf(predicate);
    }

    @Override
    public void deleteAll() {
        table.clear();
    }

    @Override
    public boolean exists(UUID id) {
        for (T item : table) {
            if (item.getId().equals(id)) return true;
        }
        return false;
    }

    @Override
    public Optional<T> where(Predicate<T> predicate) {
        for (T item : table) {
            if (predicate.test(item)) return Optional.of(item);
        }
        return Optional.empty();
    }

    @Override
    public List<T> whereList(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : table) {
            if (predicate.test(item)) result.add(item);
        }
        return result;
    }

    @Override
    public int countWhere(Predicate<T> predicate) {
        int count = 0;
        for (T item : table) {
            if (predicate.test(item)) count++;
        }
        return count;
    }

    @Override
    public int count() {
        return table.size();
    }
}
