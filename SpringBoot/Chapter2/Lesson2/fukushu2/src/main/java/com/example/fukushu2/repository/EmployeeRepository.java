package com.example.fukushu2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fukushu2.model.Employee;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    List<Employee> findByLastName(String lastName);

    // @Query(value = "SELECT * FROM employees WHERE firstName = :firstName",nativeQuery = true)
    //   List<Employee>findByFirstName(@Param("firstName")String name);  
    // List<Employee> findByFirstName(String firstName);
    @Query(value = "SELECT * FROM employees WHERE first_name = :firstName", nativeQuery = true)
List<Employee> findByFirstName(@Param("firstName") String firstName);
}
