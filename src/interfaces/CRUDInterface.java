package interfaces;

import java.util.List;

public interface CRUDInterface<T> {

    public boolean create(T c);

    public T read(Object key);

    public boolean update(T c);

    public boolean delete(Object key);

    public List<T> readAll();

}
