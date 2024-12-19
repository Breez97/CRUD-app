package ru.mirea.shamrov.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.shamrov.crud.dao.UserDao;
import ru.mirea.shamrov.crud.entity.UserEntity;
import ru.mirea.shamrov.crud.entity.UserRequest;
import ru.mirea.shamrov.crud.exception.EmailAlreadyExistException;
import ru.mirea.shamrov.crud.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(Integer id) {
		UserEntity entity = userDao.getUser(id);
		if (entity == null) {
			return null;
		}
		return User.fromEntity(entity);
	}

	@Override
	public User addUser(UserRequest userRequest) {
		if (userDao.existsByEmail(userRequest.getEmail())) {
			throw new EmailAlreadyExistException("User with email " + userRequest.getEmail() + " already exists");
		}
		UserEntity entity = UserEntity.builder()
				.email(userRequest.getEmail())
				.firstName(userRequest.getFirstName())
				.lastName(userRequest.getLastName())
				.job(userRequest.getJob())
				.build();
		UserEntity savedEntity = userDao.saveUser(entity);
		return User.fromEntity(savedEntity);
	}

}
