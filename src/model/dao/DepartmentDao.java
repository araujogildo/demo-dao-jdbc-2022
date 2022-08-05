package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	
	void insert(Department obj);
	void update(Department obj);
	int deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
	List<Department> findByDepartment(Department department);

}
