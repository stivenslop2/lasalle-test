package co.edu.lasalle.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ApiController
{
  @GetMapping("")
  public String api()
  {
    return "La Salle - Service API";
  }
}