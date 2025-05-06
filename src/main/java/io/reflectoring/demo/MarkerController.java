package io.reflectoring.demo;

 
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.demo.Marker;

@RestController
@RequestMapping("/api/markers")
@CrossOrigin(origins = "*")   // allow requests from your React app
public class MarkerController {

  private final MarkerRepository repo;
  public MarkerController(MarkerRepository repo) { this.repo = repo; }

  @GetMapping
  public List<Marker> all() {
    return repo.findAll();
  }

  @PostMapping
  public Marker create(@RequestBody Marker m) {
    return repo.save(m);
  }
}
