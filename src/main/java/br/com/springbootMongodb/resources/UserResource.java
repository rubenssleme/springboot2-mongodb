package br.com.springbootMongodb.resources;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.springbootMongodb.domain.User;
import br.com.springbootMongodb.dto.UserDTO;
import br.com.springbootMongodb.services.UserService;

@RestController
@RequestMapping(value="/v1/users")
public class UserResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService service;
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO>listDto = list.stream()
				.map(x -> new UserDTO(x))
				.collect(Collectors
				.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
