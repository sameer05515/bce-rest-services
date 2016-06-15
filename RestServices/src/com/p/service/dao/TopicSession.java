package com.p.service.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.p.service.exception.RestServiceException;
import com.p.service.pojo.Topic;




// TODO: Auto-generated Javadoc
/**
 * The Interface CoachingActionInterface.
 */
public interface TopicSession {
	
	/**
	 * Gets the coaching sessions grid.
	 *
	 * @param accountId the account id
	 * @param publishAccStatus the publish acc status
	 * @param dateFrom the date from
	 * @param dateTo the date to
	 * @return the coaching sessions grid
	 * @throws ZettaCoachingException the zetta coaching exception
	 */ 	
 	public List<Topic> getAll() throws RestServiceException;
 	
 	/**
	 * Gets the coaching sessions grid.
	 *
	 * @param accountId the account id
	 * @param publishAccStatus the publish acc status
	 * @param dateFrom the date from
	 * @param dateTo the date to
	 * @return the coaching sessions grid
	 * @throws ZettaCoachingException the zetta coaching exception
	 */ 
	public int create(Topic lob) throws RestServiceException ;

	/**
	 * Gets the coaching sessions grid.
	 *
	 * @param accountId the account id
	 * @param publishAccStatus the publish acc status
	 * @param dateFrom the date from
	 * @param dateTo the date to
	 * @return the coaching sessions grid
	 * @throws ZettaCoachingException the zetta coaching exception
	 */ 
	public boolean update(Topic lob) throws RestServiceException;

	/**
	 * Gets the coaching sessions grid.
	 *
	 * @param accountId the account id
	 * @param publishAccStatus the publish acc status
	 * @param dateFrom the date from
	 * @param dateTo the date to
	 * @return the coaching sessions grid
	 * @throws ZettaCoachingException the zetta coaching exception
	 */ 
	public Topic get(Integer id) throws RestServiceException; 	
	
}
