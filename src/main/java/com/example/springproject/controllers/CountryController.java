package com.example.springproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springproject.beans.Country;
import com.example.springproject.services.CountryService;

@RestController
public class CountryController {
	@Autowired
	CountryService countryService;

	@GetMapping("/countries")
	public List<?> getCountries() {
		return countryService.getAllCountries();
	}

	@GetMapping("/countries/{id}")
	public Country getCountryById(@PathVariable(value="id")int id) {
		return countryService.getCountryById(id);
	}

	@GetMapping("/countries/countryname")
	public Country getCountryById(@RequestParam(value="name") String name){
		return countryService.getCountryByName(name);
	}

	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}

	@PutMapping("/updatecountry")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);
		
	}
	
	@DeleteMapping
	public AddResponse deleteCountry(@PathVariable(value="id")int id) {
		return countryService.deleteCountry(id);
	}
}
