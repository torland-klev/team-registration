package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.repository.PlayerRepository;
import app.model.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/players")
public class PlayerController {

  private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

  @Autowired
  private PlayerRepository playerRepository;

  @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file, @RequestParam String name, @RequestParam String date) {
    logger.info(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
    logger.info(String.format("Name '%s', date '%s'.", name, date));
    Player player = new Player();
    player.setName(name);
    player.setDate(date);
    player.setProfileImage(file);
    playerRepository.save(player);

    return new ResponseEntity<String>("BODY!", HttpStatus.OK);
  }

  @GetMapping
  public @ResponseBody Iterable<Player> getAllPlayers() {
    return playerRepository.findAll();
  }
}
