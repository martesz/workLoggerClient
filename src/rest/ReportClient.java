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

import entities.Report;
import entities.Report.ReportType;

public class ReportClient {
	public static List<Report> getReports(String googleId) {
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);

		WebResource resource = client.resource("http://localhost:8080/service/rest/report/");

		ClientResponse clientResponse = resource.queryParam("userId", googleId).type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (clientResponse.getStatus() == 200) {
			return clientResponse.getEntity(new GenericType<List<Report>>() {
			});
		} else {
			System.out.println("Rest api call not successfull");
		}
		return null;
	}
	
	
	
	public static List<Report> getReportsTest(String googleId) {
		List<Report> reports = new ArrayList<>();
		Report report1 = new Report();
		report1.setReportType(ReportType.DAILY);
		report1.setStartDate(new Date());
		reports.add(report1);
		Report report2 = new Report();
		report2.setReportType(ReportType.MONTHLY);
		report2.setStartDate(new Date());
		reports.add(report2);
		return reports;
	}
}
