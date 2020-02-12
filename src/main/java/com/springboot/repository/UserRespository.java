package com.springboot.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springboot.model.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
	
	User findByEmailIdIgnoreCase(String emailId);
	
	@Transactional
	@Modifying
	@Query(value="update users set del_flg=false where id=:userId", nativeQuery=true)
	void deleteByUserId(@Param("userId") Long userId);
	
//	@Modifying
//	@Transactional
//	@Query(value="update users set del_flg=false where id=?1", nativeQuery=true)
//	public void deleteById(User userId);
}
