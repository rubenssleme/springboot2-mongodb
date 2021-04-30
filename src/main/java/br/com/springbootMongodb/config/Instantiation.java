package br.com.springbootMongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.springbootMongodb.domain.Post;
import br.com.springbootMongodb.domain.User;
import br.com.springbootMongodb.repository.PostRepository;
import br.com.springbootMongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	 
		userRepository.deleteAll();
		postRepository.deleteAll();
	 
	 User maria = new User(null, "Maria Brown", "maria@gmail.com");
	 User alex = new User(null, "Alex Green", "alex@gmail.com");
	 User bob = new User(null, "Bob Grey", "bob@gmail.com");
	 
	 Post post1 = new Post(null, sdf.parse("30/04/2021"), "Partiu viajem", "Vou viajar para são paulo. Abraços!", maria);
	 Post post2 = new Post(null, sdf.parse("23/03/2021"), "Bom dia", "Acordei feliz hoje!", maria);
	 
	 userRepository.saveAll(Arrays.asList(maria,alex,bob));
	 postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
