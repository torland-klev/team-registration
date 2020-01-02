package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.springframework.web.multipart.MultipartFile;
import java.text.ParseException;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import app.model.ProfileImage;

@Entity
public class Player{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long playerId;
  private String name;
  private LocalDate birthday;
  @OneToOne
  @JoinColumn(name = "profile_image_id")
  @JsonManagedReference
  private ProfileImage profileImage;
  private final LocalDateTime created;
  private LocalDateTime lastUpdated;

  public Player(){
    this.created = LocalDateTime.now();
    this.lastUpdated = LocalDateTime.now();
  }

  public Long getPlayerId(){
    return playerId;
  }
  public void setPlayerId(Long playerId){
    this.playerId = playerId;
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
    this.lastUpdated = LocalDateTime.now();
    try {
      this.birthday = LocalDate.parse(date);
    } catch (DateTimeParseException e){
      e.printStackTrace();
      this.birthday = null;
    }
  }
  public ProfileImage getProfileImage(){
    return profileImage;
  }
  public void setProfileImage(ProfileImage profileImage){
    lastUpdated = LocalDateTime.now();
    this.profileImage = profileImage;
  }
  public LocalDateTime getLastUpdated(){
    return lastUpdated;
  }
  public LocalDateTime getCreated(){
    return created;
  }
}
