package com.example.casino.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.casino.entity.Bet;
import com.example.casino.repository.InterfaceBet;
@Service
public class BetService implements InterfaceBetService {
	@Autowired
	private InterfaceBet betDao;
	@Override
	@Transactional(readOnly=true)
	public List<Bet> findAll() {
			return (List<Bet>) betDao.findAll();
	}
	@Override
	@Transactional
	public void saveBet(Bet bet) {	
		betDao.save(bet);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Bet> getBetWheel(Long id) {	
		return (List<Bet>) betDao.findByWheelId(id);
	}	
}
