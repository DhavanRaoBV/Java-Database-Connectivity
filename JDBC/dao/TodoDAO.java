package dao;

import java.util.List;

import model.Todo;



public interface TodoDAO {
	
	
	int insert(Todo todo);
	int update(Todo todo);
	int delete(int id);
	List<Todo> view();
	Todo view(int id);
	

}
