package com.example.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import com.example.assign.Job;
import com.example.assign.JobWrap;

public class TestJSON {

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		// mapper.readValues(, Job.class);
			// read from file, convert it to user class
		
		 File file = new File(TestJSON.class.getClassLoader().getResource("test.json").getFile());
		 
		 //List<Job> objs = mapper.readValue(file, new TypeReference<List<Job>>(){});
		 List<Job> objs = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(
                 List.class, Job.class));
		 
			System.out.println(objs.get(0).toString());
				
	}

}
