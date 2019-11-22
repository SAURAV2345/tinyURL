package com.tinyurl.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tinyurl.app.database.tokens;

@Repository
public interface TokenRepository extends JpaRepository<tokens,Long> {
	//List<tokens> findTop5ByTokenOrderById();
	@Transactional
	void deleteByToken(String token);
}
