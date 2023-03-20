package model;

import java.io.Serializable;

public class Author implements Serializable {
  private int authorId;
  private String name, nationality, birthYear;
  private boolean active;


  public Author(int authorId, String name, String nationality, String birthYear,
                boolean active) {
    super();
    this.birthYear = birthYear;
    this.name = name;
    this.nationality = nationality;
    this.active = active;
    this.authorId = authorId;
  }

  public Author() {

  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "Author{" +
        "authorId=" + authorId +
        ", name='" + name + '\'' +
        ", nationality='" + nationality + '\'' +
        ", birthYear='" + birthYear + '\'' +
        ", active=" + active +
        '}';
  }
}