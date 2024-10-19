package com.hazem.urlshortener.controller;

import com.hazem.urlshortener.dto.UrlRequest;
import com.hazem.urlshortener.dto.UrlResponse;
import com.hazem.urlshortener.entity.Url;
import com.hazem.urlshortener.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UrlController {
  private final UrlService urlService;

  @Autowired
  public UrlController(UrlService urlService) {
    this.urlService = urlService;
  }

  @GetMapping("/shorten/{shortCode}")
  public void getOriginalUrl(@PathVariable String shortCode, HttpServletResponse response) {
    UrlResponse urlData = urlService.getOriginalUrlData(shortCode);
    try {
      response.sendRedirect(urlData.getUrl());
    } catch (IOException e) {
      throw new RuntimeException("Redirection failed", e);
    }
  }

  @GetMapping("/shorten/{shortCode}/stats")
  public ResponseEntity<Url> getUrlStats(@PathVariable String shortCode) {
    return ResponseEntity.ok(urlService.getUrlStats(shortCode));
  }

  @PostMapping("/shorten")
  public ResponseEntity<UrlResponse> createShortenedUrl(@RequestBody UrlRequest urlRequest) {
    return new ResponseEntity<>(urlService.createShortenedUrl(urlRequest), HttpStatus.CREATED);
  }

  @PutMapping("/shorten/{shortCode}")
  public ResponseEntity<UrlResponse> updateShortenedUrl(@PathVariable String shortCode, @RequestBody UrlRequest urlRequest) {
    return ResponseEntity.ok(urlService.updateOriginalUrl(shortCode, urlRequest));
  }

  @DeleteMapping("/shorten/{shortCode}")
  public ResponseEntity<Void> deleteShortenedUrl(@PathVariable String shortCode) {
    urlService.deleteShortenedUrl(shortCode);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
