package rest;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import entities.User;

public class LoginClient {
	public static User login(String googleToken) {
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);

		WebResource resource = client.resource("http://localhost:8080/service/rest/auth/");

		ClientResponse clientResponse = resource.header(HttpHeaders.AUTHORIZATION, googleToken)
				.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (clientResponse.getStatus() == 200) {
			return clientResponse.getEntity(User.class);
		} else {
			System.out.println("Rest api call not successfull " + clientResponse.getStatus());
			return null;
		}
	}

	public static String getUserId(String accessToken) {
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);

		WebResource resource = client.resource("https://www.googleapis.com/oauth2/v1/tokeninfo");

		ClientResponse clientResponse = resource.queryParam("access_token", accessToken)
				.header(HttpHeaders.CONTENT_LENGTH, 0).type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (clientResponse.getStatus() == 200) {
			JsonNode entity = clientResponse.getEntity(JsonNode.class);
			JsonNode node = entity.get("user_id");
			return node.getTextValue();
		} else {
			System.out.println("Rest api call not successfull " + clientResponse.getStatus());
			return null;
		}
	}
}
