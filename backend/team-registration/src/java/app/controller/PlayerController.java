package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.DateFormat;

@Controller
@RequestMapping(path="/players")
public class PlayerController {
  @Autowired
  private PlayerRepository playerRepository;

  @PostMapping(path="/players")
  public @ResponseBody String addNewPlayer(@RequestParam String name, @RequestParam String date){
    Player p = new Player();
    DateFormat dft = new DateFormat();
    p.setName(name);
    p.setDate(dft.parse(date));
    playerRepository.save(p);
    return "Player stored";
  }
  @GetMapping(path="/players")
  public @ResponseBody Iterable<Player> getAllPlayers() {
    return userRepository.findAll();
  }
}
