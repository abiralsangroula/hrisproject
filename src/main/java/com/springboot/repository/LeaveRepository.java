package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.LeaveRequest;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {

}
