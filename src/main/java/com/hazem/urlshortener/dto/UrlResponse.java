package com.hazem.urlshortener.dto;

import java.sql.Timestamp;

public class UrlResponse {
  private Long id;
  private String url;
  private String shortCode;
  private Timestamp createdAt;
  private Timestamp updatedAt;

  public UrlResponse() {
  }

  public UrlResponse(Long id, String url, String shortCode, Timestamp createdAt, Timestamp updatedAt) {
    this.id = id;
    this.url = url;
    this.shortCode = shortCode;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getShortCode() {
    return shortCode;
  }

  public void setShortCode(String shortCode) {
    this.shortCode = shortCode;
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
