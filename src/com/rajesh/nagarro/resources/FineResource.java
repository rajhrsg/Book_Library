package com.rajesh.nagarro.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import com.rajesh.nagarro.constants.GlobalConstants;
import com.rajesh.nagarro.dao.UserDao;
import com.rajesh.nagarro.model.Fine;
import com.rajesh.nagarro.model.common.Message;
import org.springframework.beans.factory.annotation.Autowired;


@Path("fine")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FineResource {
	@Autowired
	UserDao userDao;

	private Logger logger = Logger.getLogger(FineResource.class);

	/**
	 * @param fine
	 * @return
	 */
	@POST
	public Response registerFine(Fine fine) {
		logger.info(" registerFile " + fine);
		Message message = null;
		if (userDao.registerFine(fine.getBookIssueId(), fine.getFineAmount(), fine.getComment())) {
			message = new Message(true, GlobalConstants.ADD_SUCCESS, null);
		} else {
			message = new Message(false, GlobalConstants.ADD_FAULURE, null);
		}
		return Response.status(Status.OK).entity(message).build();
	}
}