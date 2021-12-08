package com.url.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.url.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{

	List<Url> findAllByUserId(Long userId);

	boolean existsByShortedUrl(String shortedUrl);

	Url findByIdAndUserId(Long urlId, Long userId);

	void deleteByIdAndUserId(Long urlId, Long userId);

	Url findByUserIdAndId(Long userId, Long urlId);

	void deleteByUserIdAndId(Long userId, Long urlId);

	Url findByShortedUrl(String string);


}
