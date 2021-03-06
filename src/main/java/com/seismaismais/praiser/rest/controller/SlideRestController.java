package com.seismaismais.praiser.rest.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.seismaismais.praiser.model.Slide;
import com.seismaismais.praiser.service.DownloadService;
import com.seismaismais.praiser.service.SlideService;

@RestController
public class SlideRestController {

	Logger logger = Logger.getLogger(SlideRestController.class);

	@Autowired
	private SlideService slideService;
	
	@Autowired
	//private DownloadService downloadService;

	@RequestMapping(value = "/rest/slide/list", method = RequestMethod.GET)
	public ResponseEntity<List<Slide>> list() {
		List<Slide> slides = slideService.list();
		if (slides.isEmpty()) {
			return new ResponseEntity<List<Slide>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Slide>>(slides, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/slide/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Slide> get(@PathVariable("id") long id) {
		Slide slideAuth = slideService.findById(id);

		if (slideAuth == null) {
			return new ResponseEntity<Slide>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Slide>(slideAuth, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/slide/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Slide> create(@RequestBody Slide slide) {
		slideService.create(slide);
		
//		String filename = "[]";
//		try {
//			filename = "{\"filename\":\"" + downloadService.generatePptx(slide) + "\"}";
//		} catch (IOException e) {
//			logger.error("Erro",e);
//		}
		
		return new ResponseEntity<Slide>(slide, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rest/slide/update", method = RequestMethod.PUT)
	public ResponseEntity<Slide> update(@RequestBody Slide slide) {
		slideService.update(slide);
		return new ResponseEntity<Slide>(slide, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/auth/slide/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Slide> delete(@PathVariable("id") long id) {
		Slide slide = slideService.findById(id);
		slideService.delete(slide);
		return new ResponseEntity<Slide>(HttpStatus.NO_CONTENT);
	}

}