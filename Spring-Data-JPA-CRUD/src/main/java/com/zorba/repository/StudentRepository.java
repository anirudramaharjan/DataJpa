package com.zorba.repository;

import org.springframework.data.repository.CrudRepository;

import com.zorba.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
