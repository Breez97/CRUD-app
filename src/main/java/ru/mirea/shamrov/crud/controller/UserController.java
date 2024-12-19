package ru.mirea.shamrov.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.shamrov.crud.entity.UserRequest;
import ru.mirea.shamrov.crud.exception.EmailAlreadyExistException;
import ru.mirea.shamrov.crud.model.User;
import ru.mirea.shamrov.crud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<?> getUserById(@RequestParam(required = false) Integer id, @RequestBody(required = false) UserRequest userRequest) {
		if (id == null && userRequest == null) {
			return ResponseEntity.badRequest().body("Id is not set");
		}
		int userId = id == null ? userRequest.getId() : id;
		User user = userService.getUser(userId);
		if (user == null) {
			return ResponseEntity.status(404).body("User not found");
		}
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest) {
		try {
			User user = userService.addUser(userRequest);
			return ResponseEntity.status(201).body(user);
		} catch (EmailAlreadyExistException e) {
			return ResponseEntity.status(403).body(e.getMessage());
		}
	}

}
