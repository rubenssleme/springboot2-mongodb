package br.com.springbootMongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springbootMongodb.domain.User;
import br.com.springbootMongodb.dto.UserDTO;
import br.com.springbootMongodb.repository.UserRepository;
import br.com.springbootMongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		Optional<User> newObj = repository.findById(obj.getId());
		updateData(newObj,obj);
		return repository.save(obj);
		
	}
	
	
	private void updateData(Optional<User> newObj, User obj) {
		newObj.get().setName(obj.getName());
		newObj.get().setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}

}
