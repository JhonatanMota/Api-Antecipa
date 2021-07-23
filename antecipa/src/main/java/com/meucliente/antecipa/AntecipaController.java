package com.meucliente.antecipa;

import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;

@Controller
public class AntecipaController {

  @GetMapping("/all-titles")
  @ResponseBody
  public ResponseEntity<JSONArray> sayHello() {
    JSONParser parser = new JSONParser();
    try{
      JSONArray titles = (JSONArray) parser.parse(new FileReader("src/main/resources/static/titles.json"));
      return new ResponseEntity<>(titles, HttpStatus.OK);
    }catch(Exception erroAoLerArquivo){
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
