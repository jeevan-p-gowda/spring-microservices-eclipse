package com.example.springproject;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
	@GetMapping
	public String getUsers(@RequestParam(value="page") int pageNo,@RequestParam(value="limit")int limitNo) {
		return "HTTPS GET Request was sent for page:"+ pageNo +"and limit is:" + limitNo;
	}
	@GetMapping(path="/{userID}")
	public String getUser(@PathVariable String userID) {
		return "HTTPS GET Request was sent for userID:"+userID;
	}
	@PostMapping
	public String createUser() {
		return "HTTPS POST Request";
	}

	@PutMapping
	public String updateUser() {
		return "HTTPS PUT Request";
	}

	@DeleteMapping
	public String deleteUser() {
		return "HTTPS DELETE Request";
	}
}
