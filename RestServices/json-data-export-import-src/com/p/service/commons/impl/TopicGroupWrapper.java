package com.p.service.commons.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.p.service.commons.Doer;
import com.p.service.exception.RestServiceException;
import com.p.service.pojo.Topic;
import com.p.service.pojo.TopicGroupRelation;
import com.p.sevice.common.DAOFactory;

public class TopicGroupWrapper implements Doer {

	@Override
	public void create(String filePath) throws RestServiceException, IOException {
		List<TopicGroupRelation> list = new ArrayList<TopicGroupRelation>();

		list = DAOFactory.getTopicGroupRelationSessionInterface().getAll();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<List<TopicGroupRelation>>() {
		}.getType();
		String json = gson.toJson(list, type);
		System.out.println(json);

		Files.write(Paths.get(filePath), json.getBytes(), StandardOpenOption.CREATE,
				StandardOpenOption.TRUNCATE_EXISTING);

	}

	@Override
	public void consume(String filePath) throws RestServiceException, IOException {
		System.out.println(
				"#######################################################################################################");

		String content = "";
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<List<TopicGroupRelation>>() {
		}.getType();

		content = new String(Files.readAllBytes(Paths.get(filePath)));

		List<TopicGroupRelation> fromJson = gson.fromJson(content, type);
		


		for (TopicGroupRelation task : fromJson) {
			System.out.print(task.getId() + " , ");
			List<Integer> topicList=new LinkedList<Integer>();
			topicList.add(task.getTopics().getId());
			List<Integer> groupList=new LinkedList<Integer>();
			groupList.add(task.getGroups().getId());
			int i=DAOFactory.getTopicGroupRelationSessionInterface().addTopicsToGroups(topicList,groupList);
			System.out.println(i + " , ");
		}

	}

}
