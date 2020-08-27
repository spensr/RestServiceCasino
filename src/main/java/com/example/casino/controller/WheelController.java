package com.example.casino.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.casino.entity.*;
import com.example.casino.model.ModelWheel;
import com.example.casino.service.InterfaceWheelService;
@RestController
@RequestMapping("/api")
public class WheelController {
	@Autowired
	private InterfaceWheelService wheelService;
	@GetMapping("/wheels")
	@ResponseStatus(HttpStatus.OK)
	public List<ModelWheel> getWheel(){
		return wheelService.listAll();		
	}
	@PostMapping("/create-wheel")
	public ResponseEntity<ModelWheel> addWheel( ){	
		return new ResponseEntity<ModelWheel>(wheelService.create(), HttpStatus.CREATED);
	}
	@PostMapping("/open")
	public ResponseEntity <GenericResponse>openWheel(@RequestBody Wheel wheel) {
		boolean status=wheelService.openWheel(wheel.getId());
		if(status) {
		return new ResponseEntity<GenericResponse>(new GenericResponse("Rueleta abierta exitosamente"), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<GenericResponse>(new GenericResponse("No existe una ruleta con este id"), HttpStatus.CONFLICT);
		}
	}
	@PostMapping("/close")
	public ResponseEntity<?>closeWheel(@RequestBody Wheel wheel){
		Wheel wheels=wheelService.closeWheel(wheel.getId());
		if(wheels!=null) {
			return new ResponseEntity<Wheel>(wheels,HttpStatus.ACCEPTED) ;
		}else {
			return new ResponseEntity<GenericResponse>(new GenericResponse("No existe una ruleta con este id"),HttpStatus.CONFLICT);
		}
	}
}