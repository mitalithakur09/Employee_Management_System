package com.pro.reposritary;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.pro.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {
	
}
