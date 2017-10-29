package spittr.service;

import java.util.List;

import spittr.entity.Spittle;

/**
 * Spittle的服务接口
 * @author mingqiu
 * 
 */
public interface SpittleService {

  /**
   * Find recent spittles
   * @return recent spittles
   */
  List<Spittle> findRecentSpittles();

  /**
   * 返回指定数目的Spittle
   * @param max 最大值
   * @param count 数目
   * @return spittles
   */
  List<Spittle> findSpittles(long max, int count);
  
  /**
   * 根据id找spittle
   * @param id spittle的id
   * @return spittle
   */
  Spittle findOne(long id);

  /**
   * 保存spittle 
   * @param spittle 保存的spittle对象
   * @return void
   */
  void save(Spittle spittle);

}
