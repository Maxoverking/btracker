package com.example.btracker.myException;

public class customException extends IllegalArgumentException {

  public customException(String message) {
    super(message);
  }
}