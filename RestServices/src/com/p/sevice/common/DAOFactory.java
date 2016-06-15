package com.p.sevice.common;

import org.apache.log4j.Logger;

import com.p.service.dao.GroupSession;
import com.p.service.dao.TopicSession;
import com.p.service.dao.ViewSession;
import com.p.service.daoimpl.GroupSessionImpl;
import com.p.service.daoimpl.TopicSessionImpl;
import com.p.service.daoimpl.ViewSessionImpl;

public class DAOFactory {
	
	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(DAOFactory.class.getName());
	
	public static TopicSession getTopicSessionInterface(){
		logger.debug("Created new instance of "+TopicSession.class.getName());
		return new TopicSessionImpl();
	}
	
	public static GroupSession getGroupSessionInterface(){
		logger.debug("Created new instance of "+GroupSession.class.getName());
		return new GroupSessionImpl();
	}
	
	public static ViewSession getViewSessionInterface(){
		logger.debug("Created new instance of "+ViewSession.class.getName());
		return new ViewSessionImpl();
	}

}
