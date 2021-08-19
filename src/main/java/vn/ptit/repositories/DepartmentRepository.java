package vn.ptit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> { }