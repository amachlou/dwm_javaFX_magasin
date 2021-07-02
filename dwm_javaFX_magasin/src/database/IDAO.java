package database;

import java.util.List;

public interface IDAO<T> {

	public void add(T obj);
	public void update(T obj);
	public void delete(long id);
	public T getOne(long id);
	public List<T> getAll();
	public List<T> getAll(String text);
}
