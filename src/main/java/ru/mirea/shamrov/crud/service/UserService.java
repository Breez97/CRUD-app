package ru.mirea.shamrov.crud.service;

import ru.mirea.shamrov.crud.entity.UserRequest;
import ru.mirea.shamrov.crud.model.User;

public interface UserService {

	User getUser(Integer id);
	User addUser(UserRequest userRequest);

}
