package com.example.casino.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.casino.entity.Wheel;
import com.example.casino.model.ModelWheel;
import com.example.casino.repository.InterfaceWheel;
@Service
public class WheelService implements InterfaceWheelService{	
	@Autowired
	private InterfaceWheel wheelDao;
	@Override
	@Transactional(readOnly=true)
	public List<Wheel> findAll() {
		return (List <Wheel>) wheelDao.findAll();
	}
	@Override
	public List<ModelWheel> listAll(){
		List <Wheel> listWheel= findAll();
		List <ModelWheel> returnList=new ArrayList<ModelWheel>();
		for(Wheel wheel:listWheel) {
			ModelWheel mWheel= new ModelWheel(wheel.getId(),wheel.isStatus());
			returnList.add(mWheel);		
			}
		return returnList;
	}
	@Override
	@Transactional
	public Wheel updateWheel(Wheel wheel) {
		return (Wheel) wheelDao.save(wheel);
	}
	@Override
	@Transactional(readOnly=true)
	public Optional<Wheel> findWheelById(Long wheel_id) {
		return (Optional<Wheel>) wheelDao.findById(wheel_id);
	}
	@Override
	@Transactional(readOnly=true)
	public Wheel findById(Long id) {
		return wheelDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public void save(Wheel wheel) {
		wheelDao.save(wheel);	
	}
	@Override
	public ModelWheel create() {
		Wheel wheel= new Wheel();
		save(wheel);
		ModelWheel modelWheel= new ModelWheel(wheel);
		return  modelWheel;
	}
	@Override
	public boolean openWheel(Long id) {
		Wheel wheel= findById(id);
		if( wheel== null) {
			return false;
		}else {
		wheel.setStatus(true);
		updateWheel(wheel);
		return true;
		}
	}

	@Override
	public Wheel closeWheel(Long id) {
		Wheel wheel= findById(id);
		if(wheel!=null) {
			wheel.setStatus(false);
			updateWheel(wheel);	
		}
		return wheel;
	}
}
