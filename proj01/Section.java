//Code for Part 1 helper for SI211 Proj 1
//Code developed by Aspen Harres (282604)

import java.io.*;
import java.util.*;

public class Section {
  private String name;
  private String sec;
  private String days;
  private String location;

  public Section(String name, String sec, String days, String location) {
    this.name = name;
    this.sec = sec;
    this.days = days;
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name + " " + sec + " " + days + " " + location;
  }
}
