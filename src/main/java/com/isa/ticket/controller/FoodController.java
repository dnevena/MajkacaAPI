package com.isa.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ticket.controller.dto.CreateFoodDTO;
import com.isa.ticket.controller.dto.GetFoodDTO;
import com.isa.ticket.controller.dto.GetRestaurantsDTO;
import com.isa.ticket.controller.dto.ResponseMessageDTO;
import com.isa.ticket.domain.Food;
import com.isa.ticket.domain.Restaurant;
import com.isa.ticket.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	private FoodService foodService;

	@PostMapping("/createFood")
	public ResponseMessageDTO createFood(@RequestBody CreateFoodDTO createFoodDTO ) {
		Food food = new Food();
		food.setName(createFoodDTO.getName());
		food.setPrice(createFoodDTO.getPrice());
		food.setDescription(createFoodDTO.getDescription());
		
		food=foodService.create(food);
		
		return new ResponseMessageDTO("Uspesno dodato!");
		
	}
	
	@GetMapping("/getfood")
	public GetFoodDTO getFood() {
		List<Food> tempList = foodService.getAll();
		System.out.println(tempList);
		return new GetFoodDTO("Uspesno", tempList);
	}
	
	//@GetMapping("/deleteFood")
	//public ResponseMessageDTO deleteFood(@RequestBody DeleteFoodDTO deleteFoodDTO) {
		
	}
//}


