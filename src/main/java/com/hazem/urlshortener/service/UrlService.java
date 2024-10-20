package com.hazem.urlshortener.service;

import com.hazem.urlshortener.dto.UrlRequest;
import com.hazem.urlshortener.dto.UrlResponse;
import com.hazem.urlshortener.entity.Url;
import com.hazem.urlshortener.exception.custom.UrlNotFoundException;
import com.hazem.urlshortener.repository.UrlRepository;
import com.hazem.urlshortener.utility.ShortCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UrlService {
  private final UrlRepository repo;

  @Autowired
  public UrlService(UrlRepository repo) {
    this.repo = repo;
  }

  public Url getUrlByShortCode(String shortCode) {
    return repo.findByShortCode(shortCode).orElseThrow(() -> new UrlNotFoundException());
  }

  @Transactional
  public UrlResponse getOriginalUrlData(String shortCode) {
    Url url = getUrlByShortCode(shortCode);
    url.setAccessCount(url.getAccessCount() + 1);
    return new UrlResponse(
        url.getId(),
        url.getOriginalUrl(),
        url.getShortCode(),
        url.getCreatedAt(),
        url.getUpdatedAt());
  }

  public Url getUrlStats(String shortCode) {
    return getUrlByShortCode(shortCode);
  }

  public UrlResponse createShortenedUrl(UrlRequest urlRequest) {
    Url url = new Url(
        urlRequest.getUrl(),
        ShortCodeGenerator.getShortCodeFromOriginalUrl(urlRequest.getUrl()));

    url = repo.save(url);
    return new UrlResponse(
        url.getId(),
        url.getOriginalUrl(),
        url.getShortCode(),
        url.getCreatedAt(),
        url.getUpdatedAt());
  }

  public UrlResponse updateOriginalUrl(String shortCode, UrlRequest urlRequest) {
    Url url = getUrlByShortCode(shortCode);
    url.setOriginalUrl(urlRequest.getUrl());
    url = repo.save(url);

    return new UrlResponse(
        url.getId(),
        url.getOriginalUrl(),
        url.getShortCode(),
        url.getCreatedAt(),
        url.getUpdatedAt());
  }

  public void deleteShortenedUrl(String shortCode) {
    repo.delete(getUrlByShortCode(shortCode));
  }


}
