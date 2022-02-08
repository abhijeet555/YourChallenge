package com.model;

public class PeopleBean {

  private String gender;
  private Name name;
  private String email;

  public static class Name{

    private String title;
    private String first;
    private String last;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getFirst() {
      return first;
    }

    public void setFirst(String first) {
      this.first = first;
    }

    public String getLast() {
      return last;
    }

    public void setLast(String last) {
      this.last = last;
    }
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
