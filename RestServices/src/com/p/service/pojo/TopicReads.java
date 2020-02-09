package com.p.service.pojo;

import java.util.Date;

public class TopicReads {
	
	private int id;
	private int topicId;
	private Date dateLastRead;
	
	public TopicReads(int id, int topicId, Date dateLastReed) {
		super();
		this.id = id;
		this.topicId = topicId;
		this.dateLastRead = dateLastReed;
	}
	
	public TopicReads() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public Date getDateLastRead() {
		return dateLastRead;
	}

	public void setDateLastRead(Date dateLastRead) {
		this.dateLastRead = dateLastRead;
	}
	

}
