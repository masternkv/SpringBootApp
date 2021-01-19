package com.springboot.test.utill;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommanUtill {
	
	public static int requestFilter(String Inempid) throws Exception
	{
		//return 0;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode=mapper.readTree(Inempid);
		JsonNode idNode=rootNode.path("empid");
		return idNode.asInt();
	}

}
