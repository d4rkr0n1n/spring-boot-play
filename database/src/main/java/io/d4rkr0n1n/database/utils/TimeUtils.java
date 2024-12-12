package io.d4rkr0n1n.database.utils;

import java.sql.Timestamp;

public class TimeUtils {

  private TimeUtils() {
  }

  public static Timestamp getCurrentTime() {
    return new Timestamp(System.currentTimeMillis());
  }
}