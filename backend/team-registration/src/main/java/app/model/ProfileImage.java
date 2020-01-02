package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.MapsId;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.springframework.web.multipart.MultipartFile;
import java.text.ParseException;
import com.fasterxml.jackson.annotation.JsonBackReference;


import app.model.Player;

@Entity
public class ProfileImage {

  private final LocalDateTime created;
  private LocalDateTime lastUpdated;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long profileImageId;
  private String description;
  @OneToOne(mappedBy = "profileImage")
  @JsonBackReference
  private Player player;
  private byte[] profileImageBlob;

  public ProfileImage(){
    this.created = LocalDateTime.now();
    this.lastUpdated = LocalDateTime.now();
  }

  public ProfileImage(Player player, MultipartFile profileImage){
    this.created = LocalDateTime.now();
    this.lastUpdated = LocalDateTime.now();
    this.player = player;
    setProfileImageBlob(profileImage);
  }

  public Long getProfileImageId(){
    return profileImageId;
  }
  public void setProfileImageId(Long profileImageId){
    this.profileImageId = profileImageId;
  }
  public String getDescription(){
    return description;
  }
  public void setDescription(String description){
    lastUpdated = LocalDateTime.now();
    this.description = description;
  }
  public byte[] getProfileImageBlob(){
    return profileImageBlob;
  }
  public void setProfileImageBlob(MultipartFile profileImage){
    try{
      this.profileImageBlob = profileImage.getBytes();
    } catch (Exception e){
      e.printStackTrace();
      this.profileImageBlob = null;
    }
  }
  public Player getPlayer(){
    return player;
  }
  public LocalDateTime getLastUpdated(){
    return lastUpdated;
  }
  public LocalDateTime getCreated(){
    return created;
  }


}
