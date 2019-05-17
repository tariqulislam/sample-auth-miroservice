package com.mainul35;

import com.mainul35.config.MongoConfig;
import com.mainul35.model.Group;
import com.mainul35.model.Member;
import com.mainul35.model.Role;
import com.mainul35.model.User;
import com.mainul35.repositories.GroupRepository;
import com.mainul35.repositories.MemberRepository;
import com.mainul35.repositories.RoleRepository;
import com.mainul35.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@ComponentScan(basePackages = {"com.mainul35.restControllers", "com.mainul35.repositories"})
@SpringBootApplication
public class ReactiveMongoExample implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	GroupRepository groupRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoExample.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role();
		role.setId(UUID.randomUUID().toString());
		role.setRoleName("ROLE_USER");
		roleRepository.save(role);

		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername("mainul35");
		user.setName("Mainul Hasan");
		user.setEmail("mainuls18@gmail.com");
		user.setPassword(Base64.getEncoder().encodeToString("secret".getBytes()));
		user.setRole(role);
		userRepository.save(user);

		Member member = new Member();
		member.setId(UUID.randomUUID().toString());
		member.setMemberEmail("mainuls18@gmail.com");
		member.setMemberName("Mainul Hasan");
		memberRepository.save(member);

		Group group = new Group();
		group.setId(UUID.randomUUID().toString());
		group.setName("Group 1");
		List<Member> members = new ArrayList<>();
		members.add(member);
		group.setMembers(members);
		groupRepository.save(group);
	}
}
