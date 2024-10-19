package com.hazem.urlshortener.repository;

import com.hazem.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface UrlRepository extends JpaRepository<Url, Long> {
  Optional<Url> findByShortCode(String shortCode);
}
