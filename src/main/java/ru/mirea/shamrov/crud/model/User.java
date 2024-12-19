package ru.mirea.shamrov.crud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mirea.shamrov.crud.entity.UserEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Integer id;
	private String email;
	private String firstName;
	private String lastName;
	private String job;

	public static User fromEntity(UserEntity entity) {
		return User.builder()
				.id(entity.getId())
				.email(entity.getEmail())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.job(entity.getJob())
				.build();
	}

}
