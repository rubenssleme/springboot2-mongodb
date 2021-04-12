package br.com.springbootMongodb.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.springbootMongodb.domain.User;

@RestController
@RequestMapping(value="/v1/users")
public class UserResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "maria brown", "maria@gmail.com");
		User alex = new User("2", "alex green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
	}

}
