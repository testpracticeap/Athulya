package com.API.Message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.API.Message.SampleResponse;
import com.API.Message.PostRequest;


@RestController
public class MessageController {
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String postValues(@RequestBody PostRequest request) {
//		PostRequest req=new PostRequest();
//		req.setProjectName(request.getProjectName());
//		req.setProjectAuthor(request.get)
		SampleResponse sampleResponse=new SampleResponse();
		sampleResponse.addToList(request);
		return "Data Recorded";
		
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<PostRequest> getValues() {
		SampleResponse sampleResponse=new SampleResponse();
		List<PostRequest> list=sampleResponse.getList();
		return list;
	}
	
	
	

	}
	
	
	
	
		
		
	
	
	


