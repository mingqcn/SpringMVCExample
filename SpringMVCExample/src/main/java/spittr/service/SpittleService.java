package spittr.service;

import java.util.List;

import spittr.entity.Spittle;

public interface SpittleService {

  List<Spittle> findRecentSpittles();

  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
