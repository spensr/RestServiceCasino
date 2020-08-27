package com.example.casino.mapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.example.casino.entity.Wheel;
import com.example.casino.model.ModelWheel;
@Component("mapper")
public class Mapper {
	public static List <ModelWheel> converList(List<Wheel> wheels){
		List <ModelWheel> mWheels= new ArrayList<>();
		for(Wheel wheel: wheels) {
			mWheels.add(new ModelWheel(wheel));
		}
		return mWheels;
	}

}
