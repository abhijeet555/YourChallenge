package com.model;

public class PeopleDetailsBean {

  private String gender;
  private String email;

  private Picture picture;
  private Name name;
  private Address location;

  public static class Picture {
    private String large,medium,thumbnail;


    public String getLarge() {
      return large;
    }

    public void setLarge(String large) {
      this.large = large;
    }

    public String getMedium() {
      return medium;
    }

    public void setMedium(String medium) {
      this.medium = medium;
    }

    public String getThumbnail() {
      return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
      this.thumbnail = thumbnail;
    }
  }


  public static class Name {

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

  public static class Address {

    private Street street;
    private String city, state, country, postcode;
    private Timezone timezone;

    public static class Street {
      private long number;
      private String name;

      public long getNumber() {
        return number;
      }

      public void setNumber(long number) {
        this.number = number;
      }

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }
    }

    public static class Timezone {

      private String offset;
      private String description;

      public String getOffset() {
        return offset;
      }

      public void setOffset(String offset) {
        this.offset = offset;
      }

      public String getDescription() {
        return description;
      }

      public void setDescription(String description) {
        this.description = description;
      }
    }

    public Street getStreet() {
      return street;
    }

    public void setStreet(Street street) {
      this.street = street;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public String getPostcode() {
      return postcode;
    }

    public void setPostcode(String postcode) {
      this.postcode = postcode;
    }

    public Timezone getTimezone() {
      return timezone;
    }

    public void setTimezone(Timezone timezone) {
      this.timezone = timezone;
    }
  }


  public Picture getPicture() {
    return picture;
  }

  public void setPicture(Picture picture) {
    this.picture = picture;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Address getLocation() {
    return location;
  }

  public void setLocation(Address location) {
    this.location = location;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
