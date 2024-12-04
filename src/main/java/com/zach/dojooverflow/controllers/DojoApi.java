package com.zach.dojooverflow.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.zach.dojooverflow.services.OverflowService;

@RestController
public class DojoApi {
	private final OverflowService service;
	public DojoApi(OverflowService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/api/tag/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		service.deleteTag(id);
	}

}
