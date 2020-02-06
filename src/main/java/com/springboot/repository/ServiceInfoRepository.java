package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.ServiceInfo;

@Repository
public interface ServiceInfoRepository extends JpaRepository<ServiceInfo, Long> {

}
