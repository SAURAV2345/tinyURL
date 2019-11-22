package com.tinyurl.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinyurl.app.database.UrlDetails;


@Repository
public interface UrlRepository extends JpaRepository<UrlDetails,Long>{
 public UrlDetails findByShortURL(String shortUrl);
}
