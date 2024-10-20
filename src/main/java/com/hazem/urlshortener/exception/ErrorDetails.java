package com.hazem.urlshortener.exception;


import java.sql.Timestamp;

public class ErrorDetails {
  private Timestamp timestamp;
  private String message;
  private String details;
  private int status;

  public ErrorDetails(Timestamp timestamp, String message, String details, int status) {
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
    this.status = status;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}