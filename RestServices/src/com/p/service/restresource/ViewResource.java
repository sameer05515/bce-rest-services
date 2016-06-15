package com.p.service.restresource;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.p.service.exception.RestServiceException;
import com.p.service.pojo.Person;
import com.p.service.pojo.View;
import com.p.sevice.common.DAOFactory;


/**
 * The Class ViewResource.
 */
@Path("views")
public class ViewResource {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(ViewResource.class.getName());

	// private static List<View> topics=new ArrayList<View>();
	//
	// static{
	//
	// for(int i=1;i<10;i++){
	// topics.add(new View(i, "topic ka title", "topic ka description"));
	// }
	//
	// }

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
			List<View> topics = DAOFactory.getViewSessionInterface().getAll();
			//////////
			System.out.println("Information : " + message);
			return Response.status(HttpURLConnection.HTTP_OK).entity(topics).build();
		} catch (RestServiceException e) {
			// TODO Auto-generated catch block
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
			View topic = DAOFactory.getViewSessionInterface().get(id);
			return Response.status(HttpURLConnection.HTTP_OK).entity(topic).build();
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
	// View tt=null;
	// for(View t:topics){
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
	public Response add(View topic) {

		logger.info("Entered into getCoachingList method");

		System.out
				.println("person.getFirstName()" + topic.getTitle() + "person.getLastName()" + topic.getDescription());
		// topics.add(new View(topics.size(), topic.getTitle(),
		// topic.getDescription()));
		String message = "successfully contacted the restful API server";
		System.out.println("Information : " + message);

		try {
			int c = DAOFactory.getViewSessionInterface().create(topic);
			return Response.status(HttpURLConnection.HTTP_OK).entity("Successfully created new topic : " + c).build();
		} catch (RestServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return Response.status(HttpURLConnection.HTTP_NOT_FOUND).entity(e).build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(View topic) {

		logger.info("Entered into getCoachingList method");

		System.out
				.println("person.getFirstName()" + topic.getTitle() + "person.getLastName()" + topic.getDescription());

		// topics.add(new View(topics.size(), topic.getTitle(),
		// topic.getDescription()));

		String message = "successfully contacted the restful API server";
		System.out.println("Information : " + message);

		try {
			boolean b = DAOFactory.getViewSessionInterface().update(topic);

			return Response.status(HttpURLConnection.HTTP_OK).entity("Successfully updated topic " + topic.getId())
					.build();
		} catch (RestServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(HttpURLConnection.HTTP_NOT_FOUND).entity(e).build();
		}
	}

}
