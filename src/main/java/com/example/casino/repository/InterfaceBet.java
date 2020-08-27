package com.example.casino.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.casino.entity.Bet;
public interface InterfaceBet extends CrudRepository<Bet, Long> {
	public List<Bet> findByWheelId(Long id);
}
