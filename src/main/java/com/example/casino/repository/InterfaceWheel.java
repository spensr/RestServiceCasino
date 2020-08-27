package com.example.casino.repository;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.example.casino.entity.Wheel;
public interface InterfaceWheel extends CrudRepository<Wheel, Long> {
	public Optional<Wheel> findById(Wheel wheel);
}
