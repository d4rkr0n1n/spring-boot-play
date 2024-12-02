package io.d4rkr0n1n.sample.utils;

import java.sql.Timestamp;

public class TimeUtils {

  private TimeUtils() {
  }

  public static Timestamp getCurrentTime() {
    return new Timestamp(System.currentTimeMillis());
  }
}