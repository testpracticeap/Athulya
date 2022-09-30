package com.API.Message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SampleResponse {

	// message,id, name
	public static List<PostRequest> postReqList=new ArrayList();
	public List<PostRequest> getList() {
		return postReqList;
	}
	public void addToList(PostRequest request) {
		postReqList.add(request);
	}
	

	
}
