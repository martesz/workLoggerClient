package rest;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import entities.Person;

public class RestClient {
	public List<Person> getPersons() {
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);
		
		WebResource resource = client.resource("http://localhost:8080/service/rest/person/");
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (clientResponse.getStatus() == 200) {
			return clientResponse.getEntity(new GenericType<List<Person>>() {
			});
		} else {
			System.out.println("Rest api call not successfull");
		}
		return null;
	}
	
	
}
