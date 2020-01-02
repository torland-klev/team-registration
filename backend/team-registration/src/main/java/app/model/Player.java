package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.springframework.web.multipart.MultipartFile;
import java.text.ParseException;

import app.service.Converter;

@Entity
public class Player{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private LocalDate birthday;
  private byte[] profileImage;
  private final LocalDateTime created;
  private LocalDateTime lastUpdated;

  public Player(){
    this.created = LocalDateTime.now();
    this.lastUpdated = LocalDateTime.now();
  }

  public Long getId(){
    return id;
  }
  public void setId(Long id){
    this.id = id;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
    this.lastUpdated = LocalDateTime.now();
  }
  public LocalDate getBirthday(){
    return birthday;
  }
  public void setBirthday(LocalDate date){
    this.birthday = date;
    this.lastUpdated = LocalDateTime.now();
  }
  public void setBirthday(String date){
    System.out.println(date);
    this.lastUpdated = LocalDateTime.now();
    try {
      this.birthday = LocalDate.parse(date);
    } catch (DateTimeParseException e){
      e.printStackTrace();
      this.birthday = null;
    }
    System.out.println(this.birthday.toString());
  }
  public byte[] getProfileImage(){
    return profileImage;
  }
  public void setProfileImage(MultipartFile profileImage){
    try{
      this.profileImage = profileImage.getBytes();
    } catch (Exception e){
      e.printStackTrace();
      this.profileImage = null;
    }
  }
  public LocalDateTime getCreated(){
    return created;
  }
}
