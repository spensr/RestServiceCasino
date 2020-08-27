package com.example.casino.service;
import java.util.List;
import java.util.Optional;
import com.example.casino.entity.Wheel;
import com.example.casino.model.ModelWheel;
public interface InterfaceWheelService {
	public List<Wheel> findAll();
	public List<ModelWheel> listAll();
	public Wheel updateWheel(Wheel wheel);
	public Optional<Wheel> findWheelById(Long wheel_id);
	public Wheel findById(Long id);
	public void save(Wheel wheel);
	public ModelWheel create();
	public boolean openWheel(Long id);
	public Wheel closeWheel(Long id);
}
