package com.p.service.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.p.service.exception.RestServiceException;
import com.p.service.pojo.Group;




// TODO: Auto-generated Javadoc
/**
 * The Interface CoachingActionInterface.
 */
public interface GroupSession {
	
	
	
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
 	public List<Group> getAll() throws RestServiceException;
 	
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
	public int create(Group lob) throws RestServiceException ;

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
	public boolean update(Group lob) throws RestServiceException;

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
	public Group get(Integer id) throws RestServiceException; 	
	
}
