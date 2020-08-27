package com.example.casino.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.casino.entity.Bet;
import com.example.casino.entity.GenericResponse;
import com.example.casino.entity.Wheel;
import com.example.casino.service.InterfaceBetService;
import com.example.casino.service.InterfaceWheelService;
@RestController
@RequestMapping("/api")
public class BetController {
	@Autowired
	private InterfaceBetService betService;
	@Autowired
	private InterfaceWheelService wheelService;
	@GetMapping("/bets")
	public ResponseEntity<?> listBet(){
		List<Bet> listBet=betService.findAll();
		if(listBet!=null) {
			if(listBet.size()!=0) 
				{
					return new ResponseEntity<>(listBet, HttpStatus.OK);
				}else {
					return new ResponseEntity< GenericResponse>(new GenericResponse("No hay apuestas creadas"),HttpStatus.NOT_FOUND);
				}
			}
		else {
			return new ResponseEntity< GenericResponse>(new GenericResponse("No hay apuestas creadas."),HttpStatus.NOT_FOUND);
		}		
	}
	@PostMapping("/create-bet")
	public ResponseEntity<GenericResponse> agregarCurso(@RequestBody Bet bet,@RequestHeader Map<String,String> headers){
		Long userId=Long.parseLong(headers.get("user"));
		bet.setUser(userId);
		Wheel wheel=wheelService.findById(bet.getWheelIdl());
		if(wheel==null) {
			return new ResponseEntity<GenericResponse>(new GenericResponse("No existe una ruleta con el id especificado."),HttpStatus.CONFLICT);
		}else {
			if(!wheel.isStatus()) {
				return new ResponseEntity<GenericResponse>(new GenericResponse("La ruleta se encuentra cerrada."),HttpStatus.CONFLICT);
			}
		}
		if(bet.getNumber()==null && bet.getColour()==null) {
			return new ResponseEntity<GenericResponse>(new GenericResponse("Debe ingresar un numero o un color."),HttpStatus.CONFLICT);
		}
		if(bet.getNumber()!=null && bet.getColour()!=null) {
			return new ResponseEntity<GenericResponse>(new GenericResponse("Debe apostar a un numero o a un color, no a ambos."),HttpStatus.CONFLICT);
		}
		if(bet.getNumber()!=null && (bet.getNumber()<0 ||bet.getNumber()>36) ) {
			return new ResponseEntity<GenericResponse>(new GenericResponse("Debe apostar a un numero entre 0 y 36."),HttpStatus.CONFLICT);
		}
		if(bet.getColour()!=null && (!bet.getColour().equalsIgnoreCase("rojo") && !bet.getColour().equalsIgnoreCase("negro") ) ){
			return new ResponseEntity<GenericResponse>(new GenericResponse("Debe apostar a un color valido, Rojo o Negro."),HttpStatus.CONFLICT);
		}
		if(bet.getAmount()<=0|| bet.getAmount()>10000) {
			return new ResponseEntity<GenericResponse>(new GenericResponse("Monto maximo de apuesta 10.000 dólares."),HttpStatus.CONFLICT);
		}
		betService.saveBet(bet);
		System.out.println(bet.getAmount());
		return new ResponseEntity<GenericResponse>(new GenericResponse("Apuesta realziada exitosamente"),HttpStatus.CREATED);
	}
	@PostMapping("/bet-wheel")
	public ResponseEntity<?> verCursosProfesor(@RequestBody Wheel wheel){
		List<Bet> listBet = betService.getBetWheel(wheel.getId());
		if(listBet!=null) {
			if(listBet.size()!=0) {
				return new ResponseEntity<>(listBet, HttpStatus.OK);
			}else {
				return new ResponseEntity<GenericResponse>(new GenericResponse("No apuesta asifanada a la ruleta"),HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<GenericResponse>(new GenericResponse("No apuesta asifanada a la ruleta"),HttpStatus.NOT_FOUND);
		}
	}
}
