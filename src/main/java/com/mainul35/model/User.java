package com.mainul35.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	String id;
	@NotBlank(message = "Name must not be blank")
	@NotNull(message = "Name must not be null.")
	String name;
	@NotNull(message = "Name must not be null.")
	String email;
	@NotNull(message = "Name must not be null.")
	String username;
	@NotNull(message = "Name must not be null.")
	String password;
	@NotNull(message = "Role must not be null")
	Role role;
}
