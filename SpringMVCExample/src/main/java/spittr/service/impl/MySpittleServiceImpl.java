package spittr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import spittr.entity.Spittle;
import spittr.service.SpittleService;

/**
 * 我的Spittle服务接口实现
 * @author mingqiu
 *
 */
@Service
public class MySpittleServiceImpl implements SpittleService {

	@Override
	public List<Spittle> findRecentSpittles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spittle findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Spittle spittle) {
		// TODO Auto-generated method stub

	}

}
