package com.p.service.restresource;

import java.net.HttpURLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.p.service.exception.RestServiceException;
import com.p.service.pojo.Group;
import com.p.sevice.common.DAOFactory;

/**
 * The Class TopicResource.
 */
@Path("groups")
public class GroupResource {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(GroupResource.class.getName());

	/**
	 * Gets the all topics list.
	 *
	 * @return the all topics list
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	public Response getAll(@Context HttpServletRequest serveletRequest) {

		logger.info("Entered into getCoachingList method");
		String message = "successfully contacted the restful API server";
		try {
			////////////
			List<Group> groups = DAOFactory.getGroupSessionInterface().getAll();
			//////////
			System.out.println("Information : " + message);
			return Response.status(HttpURLConnection.HTTP_OK).entity(groups).build();
		} catch (RestServiceException e) {

			e.printStackTrace();
			return Response.status(HttpURLConnection.HTTP_NOT_FOUND).entity(e).build();
		}
	}

	/**
	 * Gets the topic for given id from list.
	 *
	 * @param id
	 * 
	 * @return the topic from list for given id
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {

		logger.info("Entered into getCoachingList method");
		String message = "successfully contacted the restful API server";
		System.out.println("Information : " + message);

		try {
			Group group = DAOFactory.getGroupSessionInterface().get(id);
			return Response.status(HttpURLConnection.HTTP_OK).entity(group).build();
		} catch (RestServiceException e) {
			e.printStackTrace();
			return Response.status(HttpURLConnection.HTTP_NOT_FOUND).entity("no topic found for given id : " + id)
					.build();
		}

	}

	/**
	 * Deletes the topic for given id from list.
	 *
	 * @param id
	 * 
	 * @return the topic from list for given id
	 */
	// @DELETE
	// @Path("/{id}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public Response delete(@PathParam("id") int id) {
	//
	// logger.info("Entered into getCoachingList method");
	// String message = "successfully contacted the restful API server";
	// Topic tt=null;
	// for(Topic t:topics){
	// if(t.getId()==id){
	// tt=t;
	// }
	// }
	// System.out.println("Information : "+message);
	// if(tt!=null){
	// return Response.status(HttpURLConnection.HTTP_OK).entity(tt)
	// .build();
	// }else{
	// return Response.status(HttpURLConnection.HTTP_NOT_FOUND).entity("no topic
	// found for given id : "+id)
	// .build();
	// }
	//
	// }

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Group group) {

		logger.info("Entered into getCoachingList method");

		System.out
				.println("person.getFirstName()" + group.getTitle() + "person.getLastName()" + group.getDescription());

		String message = "successfully contacted the restful API server";
		System.out.println("Information : " + message);

		try {
			int c = DAOFactory.getGroupSessionInterface().create(group);
			return Response.status(HttpURLConnection.HTTP_OK).entity("Successfully created new topic : " + c).build();
		} catch (RestServiceException e) {

			e.printStackTrace();

			return Response.status(HttpURLConnection.HTTP_NOT_FOUND).entity(e).build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Group group) {

		logger.info("Entered into getCoachingList method");

		System.out.println("group.getTitle()" + group.getTitle() + "group.getDescription()" + group.getDescription());

		String message = "successfully contacted the restful API server";
		System.out.println("Information : " + message);

		try {
			boolean b = DAOFactory.getGroupSessionInterface().update(group);

			// return Response.status(HttpURLConnection.HTTP_OK)
			// .entity(((b && true) ? "Successfully " : "Unsuccessfully ") +
			// "updated group " + group.getId())
			// .build();

			return Response.status(HttpURLConnection.HTTP_OK)
					.entity("{\"status\":\""
							+ ((b && true) ? HttpURLConnection.HTTP_OK : HttpURLConnection.HTTP_INTERNAL_ERROR)
							+ "\", \"message\": \"" + ((b && true) ? "Successfully " : "Unsuccessfully ")
							+ "updated group " + group.getId() + "\"}")
					.build();
		} catch (RestServiceException e) {
			e.printStackTrace();
			return Response.status(HttpURLConnection.HTTP_NOT_FOUND).entity(e).build();
		}
	}

}
