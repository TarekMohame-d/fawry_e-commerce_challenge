package Helper;

import java.util.*;

public class InMemoryDatabase {
    private static final InMemoryDatabase instance = new InMemoryDatabase();
    private final Map<TableName, List<?>> tables = new HashMap<>();

    private InMemoryDatabase() {
        for (TableName table : TableName.values()) {
            tables.put(table, new ArrayList<>());
        }
    }

    public static InMemoryDatabase getInstance() {
        return instance;
    }

    public <T> void add(TableName table, T entity) {
        List<T> list = (List<T>) tables.get(table);
        list.add(entity);
    }

    public <T> List<T> getTable(TableName table, Class<T> type) {
        return (List<T>) tables.get(table);
    }

    public void reset() {
        for (TableName table : TableName.values()) {
            tables.get(table).clear();
        }
    }
}
