package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Player{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String name;
  private Date date;

  public Integer getId(){
    return id;
  }
  public void setId(Integer id){
    this.id = id;
  }
  public String getName(String name){
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

  }
}
