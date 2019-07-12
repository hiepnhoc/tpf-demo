package com.tpf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tpf.entity.AccountEntity;

@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, String> {
	
	@Query(nativeQuery = true, value = "SELECT a.* FROM accounts a WHERE a.username = ?1 AND a.password = UPPER(?2) fetch first 1 rows only")
	AccountEntity findOneByUserNameAndPassword(String username, String password);

}
