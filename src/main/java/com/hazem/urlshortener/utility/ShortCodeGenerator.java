package com.hazem.urlshortener.utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ShortCodeGenerator {
  public static String getShortCodeFromOriginalUrl(String originalUrl) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hashBytes = digest.digest(originalUrl.getBytes(StandardCharsets.UTF_8));
      String shortCode = Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes);

      return shortCode.substring(0, 8);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error generating short code", e);
    }
  }
}
