package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.text.SimpleDateFormat;


import org.springframework.web.multipart.MultipartFile;
import java.text.ParseException;

import app.service.Converter;

@Entity
public class Player{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String name;
  private Date date;
  private byte[] profileImage;

  public Integer getId(){
    return id;
  }
  public void setId(Integer id){
    this.id = id;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public Date getDate(){
    return date;
  }
  public void setDate(Date date){
    this.date = date;
  }
  public void setDate(String date){
    try {
      this.date = (new SimpleDateFormat("yyMMdd")).parse(date);
    } catch (ParseException e){
      e.printStackTrace();
      this.date = null;
    }
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
}
