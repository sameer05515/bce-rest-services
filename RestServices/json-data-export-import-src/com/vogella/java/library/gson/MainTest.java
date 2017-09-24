package com.vogella.java.library.gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.p.service.exception.RestServiceException;
import com.p.service.pojo.Group;
import com.p.service.pojo.GroupViewRelation;
//import com.p.eximport.main.pojo.Topic;
import com.p.service.pojo.Topic;
import com.p.service.pojo.TopicGroupRelation;
import com.p.service.pojo.View;
import com.p.service.pojo.ViewTopicRelation;
import com.p.sevice.common.DAOFactory;

public class MainTest {
	
	public static String jsonDataDirectory = "G:/mum 507/Prem/json-data-office/json-data/";

	public static void main(String[] args) {
		//method1();
		
		createAndConsumeTopicJSON(jsonDataDirectory + "topics-data.json");
		createAndConsumeGroupJSON(jsonDataDirectory + "group-data.json");
		createAndConsumeViewJSON(jsonDataDirectory + "view-data.json");
//		createAndConsumeTopicGroupRelationJSON(jsonDataDirectory+ "topic-group-data.json");
//		createAndConsumeGroupViewRelationJSON(jsonDataDirectory+ "group-view-data.json");
//		createAndConsumeViewTopicRelationJSON(jsonDataDirectory+ "view-topics-data.json");
	}

	private static void method1() {
		List<Task> list = new ArrayList<Task>();
		for (int i = 0; i < 20; i++) {
			list.add(new Task(i, "Test1", "Test2", Task.Status.ASSIGNED, 10));
		}
		Gson gson = new Gson();
		Type type = new TypeToken<List<Task>>() {
		}.getType();
		String json = gson.toJson(list, type);
		System.out.println(json);
		List<Task> fromJson = gson.fromJson(json, type);

		for (Task task : fromJson) {
			System.out.println(task);
		}
	}

	private static void createAndConsumeTopicJSON(String filePath) {

//		List<Topic> list = new ArrayList<Topic>();
//		try {
//			list = DAOFactory.getTopicSessionInterface().getAll();
//		} catch (RestServiceException e) {
//			e.printStackTrace();
//		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<List<Topic>>() {
		}.getType();
//		String json = gson.toJson(list, type);
//		System.out.println(json);
//		try {
//			Files.write(Paths.get(filePath), json.getBytes(), StandardOpenOption.CREATE,
//					StandardOpenOption.TRUNCATE_EXISTING);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		System.out.println(
				"#######################################################################################################");

		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Topic> fromJson = gson.fromJson(content, type);

		for (Topic task : fromJson) {
			System.out.println(task.getId() + " , ");
			try {
				DAOFactory.getTopicSessionInterface().create(task);
			} catch (RestServiceException e) {
				e.printStackTrace();
			}
		}
	}

	private static void createAndConsumeGroupJSON(String filePath) {

//		List<Group> list = new ArrayList<Group>();
//		try {
//			list = DAOFactory.getGroupSessionInterface().getAll();
//		} catch (RestServiceException e) {
//			e.printStackTrace();
//		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<List<Group>>() {
		}.getType();
//		String json = gson.toJson(list, type);
//		System.out.println(json);
//		try {
//			Files.write(Paths.get(filePath), json.getBytes(), StandardOpenOption.CREATE,
//					StandardOpenOption.TRUNCATE_EXISTING);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		System.out.println(
				"#######################################################################################################");

		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Group> fromJson = gson.fromJson(content, type);

		for (Group task : fromJson) {
			System.out.println(task.getId() + " , ");
			try {
				DAOFactory.getGroupSessionInterface().create(task);
			} catch (RestServiceException e) {
				e.printStackTrace();
			}
		}
	}

	private static void createAndConsumeViewJSON(String filePath) {

//		List<View> list = new ArrayList<View>();
//		try {
//			list = DAOFactory.getViewSessionInterface().getAll();
//		} catch (RestServiceException e) {
//			e.printStackTrace();
//		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<List<View>>() {
		}.getType();
//		String json = gson.toJson(list, type);
//		System.out.println(json);
//		try {
//			Files.write(Paths.get(filePath), json.getBytes(), StandardOpenOption.CREATE,
//					StandardOpenOption.TRUNCATE_EXISTING);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		System.out.println(
				"#######################################################################################################");

		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<View> fromJson = gson.fromJson(content, type);

		for (View task : fromJson) {
			System.out.println(task.getId() + " , ");
			try {
				DAOFactory.getViewSessionInterface().create(task);
			} catch (RestServiceException e) {
				e.printStackTrace();
			}
		}
	}

	private static void createAndConsumeTopicGroupRelationJSON(String filePath) {

		List<TopicGroupRelation> list = new ArrayList<TopicGroupRelation>();
		try {
			list = DAOFactory.getTopicGroupRelationSessionInterface().getAll();
		} catch (RestServiceException e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<List<TopicGroupRelation>>() {
		}.getType();
		String json = gson.toJson(list, type);
		System.out.println(json);
		try {
			Files.write(Paths.get(filePath), json.getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(
				"#######################################################################################################");

		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<TopicGroupRelation> fromJson = gson.fromJson(content, type);

		for (TopicGroupRelation task : fromJson) {
			System.out.println(task.getId() + " , ");
		}
	}

	private static void createAndConsumeGroupViewRelationJSON(String filePath) {

		List<GroupViewRelation> list = new ArrayList<GroupViewRelation>();
		try {
			list = DAOFactory.getGroupViewRelationSessionInterface().getAll();
		} catch (RestServiceException e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<List<GroupViewRelation>>() {
		}.getType();
		String json = gson.toJson(list, type);
		System.out.println(json);
		try {
			Files.write(Paths.get(filePath), json.getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(
				"#######################################################################################################");

		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<GroupViewRelation> fromJson = gson.fromJson(content, type);

		for (GroupViewRelation task : fromJson) {
			System.out.println(task.getId() + " , ");
		}
	}

	private static void createAndConsumeViewTopicRelationJSON(String filePath) {

		List<ViewTopicRelation> list = new ArrayList<ViewTopicRelation>();
		try {
			list = DAOFactory.getViewTopicRelationSessionInterface().getAll();
		} catch (RestServiceException e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken<List<ViewTopicRelation>>() {
		}.getType();
		String json = gson.toJson(list, type);
		System.out.println(json);
		try {
			Files.write(Paths.get(filePath), json.getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(
				"#######################################################################################################");

		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<ViewTopicRelation> fromJson = gson.fromJson(content, type);

		for (ViewTopicRelation task : fromJson) {
			System.out.println(task.getId() + " , ");
		}
	}
}