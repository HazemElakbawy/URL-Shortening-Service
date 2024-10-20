package com.hazem.urlshortener.exception.custom;

public class UrlNotFoundException extends RuntimeException {
  public UrlNotFoundException() {
    super("The URL you tried to access does not exist in the system.");
  }
}
