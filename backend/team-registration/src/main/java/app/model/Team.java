package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Entity
public class Team {

  private final LocalDateTime created;
  private LocalDateTime lastUpdated;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;

  public Team(){
    this.created = LocalDateTime.now();
    this.lastUpdated = LocalDateTime.now();
  }

  public Long getId(){
    return id;
  }
  public void setId(Long id){
    this.id = id;
  }


}
