package spittr.service;

import java.util.List;

import spittr.entity.Spitter;
import spittr.entity.Spittle;

public interface SpitterService {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);
  
  List<Spittle> findRecentSpittles();
  
  Spittle findOne(long id);

}
