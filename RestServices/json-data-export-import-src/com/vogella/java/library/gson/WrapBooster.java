package com.vogella.java.library.gson;

import java.io.IOException;

import com.p.service.commons.ExportImportConstants;
import com.p.service.commons.impl.GroupWrapper;
import com.p.service.commons.impl.TopicWrapper;
import com.p.service.commons.impl.ViewWrapper;
import com.p.service.exception.RestServiceException;

public class WrapBooster {

	public static String jsonDataDirectory = "C:/Users/premendra.kumar1/Desktop/json-data/";

	public static void main(String[] args) {
		try {
			/** Export data */

			/*new TopicWrapper().create(jsonDataDirectory + ExportImportConstants.topicsJsonFileName);*/
			/*new GroupWrapper().create(jsonDataDirectory + ExportImportConstants.groupsJsonFileName);*/
			/*new ViewWrapper().create(jsonDataDirectory + ExportImportConstants.viewsJsonFileName);*/
			/*new TopicGroupWrapper().create(jsonDataDirectory + ExportImportConstants.topicGroupRelationJsonFileName);*/
			/*new GroupViewWrapper().create(jsonDataDirectory + ExportImportConstants.groupViewRelationJsonFileName);*/

			/** Import data */

			new TopicWrapper().consume(jsonDataDirectory + ExportImportConstants.topicsJsonFileName);
			new GroupWrapper().consume(jsonDataDirectory + ExportImportConstants.groupsJsonFileName);
			new ViewWrapper().consume(jsonDataDirectory + ExportImportConstants.viewsJsonFileName);

			/**
			 * TopicGroup and GroupView relations are making problems , hence
			 * this should be mapped manually due to limited time before leaving
			 * this Concentrix organisation
			 */

			// new TopicGroupWrapper().consume(jsonDataDirectory +
			// ExportImportConstants.topicGroupRelationJsonFileName);
			// new GroupViewWrapper().consume(jsonDataDirectory +
			// ExportImportConstants.groupViewRelationJsonFileName);

		} catch (RestServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
