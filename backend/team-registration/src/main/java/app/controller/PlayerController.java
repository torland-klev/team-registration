package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import app.repository.PlayerRepository;
import app.model.Player;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping(path="/players")
public class PlayerController {

  @Autowired
  private PlayerRepository playerRepository;

  @PostMapping
  public @ResponseBody String addNewPlayer(@RequestBody Player player){

    playerRepository.save(player);

    return (player.getName() + " " + player.getDate());
  }

  @GetMapping
  public @ResponseBody Iterable<Player> getAllPlayers() {
    return playerRepository.findAll();
  }
}
