package com.rajesh.nagarro.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import com.rajesh.nagarro.model.common.AppConstants;
import com.rajesh.nagarro.model.common.Message;

@Path("/")
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class DefaultResource {
	private Logger logger = Logger.getLogger(DefaultResource.class);
	/**
	 * @return Response default API Resource application details
	 * returns application name and version
	 */	
	@GET
	public Response get() {
		logger.info(AppConstants.appName + " " + AppConstants.appVersion);
		return Response
				.status(Status.OK)
				.entity(new Message(true, AppConstants.appName + " "
						+ AppConstants.appVersion, null)).build();
	}
}