package com.example.springproject.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springproject.beans.Country;
import com.example.springproject.controllers.AddResponse;

@Service
public class CountryService {
	static HashMap<Integer,Country> countryIdMap;

	public CountryService() {
		countryIdMap = new HashMap<>();

		Country india=new Country(1,"India","Delhi");
		Country america=new Country(2,"USA","Washington");
		Country sriLanka=new Country(3,"Sri Lanka","Colombo");

		countryIdMap.put(1, india);
		countryIdMap.put(2, america);
		countryIdMap.put(3, sriLanka);
	}

	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>(countryIdMap.values());
		return countries;
	}

	public Country getCountryById(int id) {
		Country country=countryIdMap.get(id);
		return country;	
	}

	public Country getCountryByName(String name) {
		Country country=null;
		for(int i:countryIdMap.keySet()) {
			if(countryIdMap.get(i).getCountryName().equals(name)) {
				country=countryIdMap.get(i);
			}
		}
		return country;
	}

	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryIdMap.put(country.getId(), country);
		return country;
	}

	public Country updateCountry(Country country) {
		if (country.getId()>0) 
			countryIdMap.put(country.getId(), country);
		return country;
	}

	public AddResponse deleteCountry(int id) {
		countryIdMap.remove(id);
		AddResponse response = new AddResponse();
		response.setId(id);
		response.setMsg("Country deleted");
		return response;
	}

	public static int getMaxId() {
		int max=0;
		for(int id:countryIdMap.keySet()) {
			if(max<id) {
				max = id;
			}
		}
		return max+1;
	}
}
