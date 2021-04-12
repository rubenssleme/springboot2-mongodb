package br.com.springbootMongodb.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.springbootMongodb.domain.User;
import br.com.springbootMongodb.services.UserService;

@RestController
@RequestMapping(value="/v1/users")
public class UserResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService service;
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
