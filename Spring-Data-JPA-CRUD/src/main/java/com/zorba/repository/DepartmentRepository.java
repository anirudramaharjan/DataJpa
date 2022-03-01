package com.zorba.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zorba.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	@Transactional
	@Modifying
	@Query("update Department set deptName = :deptName where id=:id")
	void updateDeptName (@Param ("id") Long id, @Param("deptName") String deptName);
	
	@Query("select d from Department d WHERE d.deptName =:d")
	public Optional<Department> getByDept(@Param ("d") String deptName);

}
