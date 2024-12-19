package ru.mirea.shamrov.crud.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

	private Integer id;
	private String email;
	private String firstName;
	private String lastName;
	private String job;

}
