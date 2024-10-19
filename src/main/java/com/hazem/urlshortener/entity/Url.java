package com.hazem.urlshortener.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "urls")
public class Url {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty("url")
  @Column(name = "url", nullable = false, unique = true, length = 2083)
  private String originalUrl;

  @Column(name = "short_code", nullable = false, unique = true, length = 100)
  private String shortCode;

  @Column(name = "access_count")
  private Long accessCount = 0L;

  @Column(name = "created_at", updatable = false)
  private Timestamp createdAt;
  @Column(name = "updated_at")
  private Timestamp updatedAt;

  public Url() {
  }

  public Url(String originalUrl) {
    this.originalUrl = originalUrl;
  }

  public Url(String originalUrl, String shortCode) {
    this.originalUrl = originalUrl;
    this.shortCode = shortCode;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
  }

  public Long getId() {
    return id;
  }

  public String getOriginalUrl() {
    return originalUrl;
  }

  public void setOriginalUrl(String url) {
    this.originalUrl = url;
  }

  public String getShortCode() {
    return shortCode;
  }

  public void setShortCode(String shortCode) {
    this.shortCode = shortCode;
  }

  public Long getAccessCount() {
    return accessCount;
  }

  public void setAccessCount(Long accessCount) {
    this.accessCount = accessCount;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
}
