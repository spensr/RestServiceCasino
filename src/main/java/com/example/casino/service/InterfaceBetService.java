package com.example.casino.service;
import java.util.List;
import com.example.casino.entity.Bet;
public interface InterfaceBetService {
	public List<Bet> findAll();
	public void saveBet(Bet bet);
	public List <Bet> getBetWheel(Long id);
}
