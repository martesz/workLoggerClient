package rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import entities.Issue;
import entities.WorkingHour;

public class WorkingHoursClient {
	public static List<WorkingHour> getWorkingHours(String googleId) {
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);

		WebResource resource = client.resource("http://localhost:8080/service/rest/hour/byId");

		ClientResponse clientResponse = resource.queryParam("userId", googleId).type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (clientResponse.getStatus() == 200) {
			return clientResponse.getEntity(new GenericType<List<WorkingHour>>() {
			});
		} else {
			System.out.println("Rest api call not successfull");
		}
		return null;
	}
	
	public static List<WorkingHour> getWorkingHoursTest(String googleId) {
		List<WorkingHour> workingHours = new ArrayList<>();
		
		Issue issue = new Issue();
		issue.setName("Test issue");
		
		WorkingHour wHour1 = new WorkingHour();
		wHour1.setStarting(new Date());
		wHour1.setDuration(1000l);
		wHour1.setIssue(issue);
		
		WorkingHour wHour2 = new WorkingHour();
		wHour2.setStarting(new Date());
		wHour2.setDuration(500l);
		wHour2.setIssue(issue);
		
		workingHours.add(wHour1);
		workingHours.add(wHour2);

		return workingHours;
	}

}
