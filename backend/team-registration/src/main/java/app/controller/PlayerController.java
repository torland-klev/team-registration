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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.repository.PlayerRepository;
import app.repository.ProfileImageRepository;
import app.model.Player;
import app.model.ProfileImage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/players")
public class PlayerController {

  private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

  @Autowired
  private PlayerRepository playerRepository;
  @Autowired
  private ProfileImageRepository profileImageRepository;

  @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<Player> createPlayer(@RequestParam MultipartFile profileImage, @RequestParam String name, @RequestParam String birthday) {
    logger.info(String.format("File name '%s' uploaded successfully.", profileImage.getOriginalFilename()));
    logger.info(String.format("Name '%s', date '%s'.", name, birthday));
    Player player = new Player();
    ProfileImage pfImg = new ProfileImage(player, profileImage);
    playerRepository.save(player);
    profileImageRepository.save(pfImg);
    player.setName(name);
    player.setBirthday(birthday);
    player.setProfileImage(pfImg);
    playerRepository.save(player);

    return ResponseEntity.ok(player);
  }

  @PostMapping(value = "")
  public @ResponseBody Player createPlayer(@RequestBody Player player) {
    logger.info(String.format("Name '%s', date '%s'.", player.getName(), player.getBirthday().toString()));
    ProfileImage pfImg = new ProfileImage(player, null);
    playerRepository.save(player);
    profileImageRepository.save(pfImg);
    return player;
  }


  @GetMapping
  public @ResponseBody Iterable<Player> getAllPlayers() {
    return playerRepository.findAll();
  }

  @RequestMapping(method=RequestMethod.GET, params = "id")
  public @ResponseBody Optional<Player> getPlayer(long id){
    return playerRepository.findById(id);
  }

  @RequestMapping(
    value="/profileImage",
    method=RequestMethod.GET,
    params = "id",
    produces = MediaType.IMAGE_JPEG_VALUE
  )
  public @ResponseBody byte[] getPlayerProfileImage(long id){
    Player player = playerRepository.findById(id).get();
    ProfileImage pf = profileImageRepository.findById(player.getProfileImage().getProfileImageId()).get();
    return pf.getProfileImageBlob();
  }
}
