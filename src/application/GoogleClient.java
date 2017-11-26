package application;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.MemoryDataStoreFactory;
import com.google.common.collect.Lists;

public class GoogleClient {
	
	private static final String GOOGLE_API_SCOPES = "profile";
	private static final String GOOGLE_CLIENT_SECRET = "/Users/martesz/Downloads/client_secret_390153392979-t2l587am3cdq2qgr2um8ctidp2p3bnu4.apps.googleusercontent.com.json";

	public static Credential authorize() throws Exception {
		JsonFactory jsonFactory = new GsonFactory();
		NetHttpTransport transport = new NetHttpTransport();
		Reader reader = new InputStreamReader(new FileInputStream(GOOGLE_CLIENT_SECRET));
		GoogleClientSecrets secrets = GoogleClientSecrets.load(jsonFactory, reader);
		DataStoreFactory dataStoreFactory = new MemoryDataStoreFactory();
		List<String> scopes = Lists.newArrayList(GOOGLE_API_SCOPES);
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(transport, jsonFactory, secrets,
				scopes).setDataStoreFactory(dataStoreFactory).build();
		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
	}
}
