package ru.mirea.shamrov.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mirea.shamrov.crud.entity.UserEntity;
import ru.mirea.shamrov.crud.repository.UserRepository;

@Component
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public UserEntity getUser(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	public UserEntity saveUser(UserEntity entity) {
		return userRepository.save(entity);
	}

	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

}
