package com.p.service.util;

import com.p.service.main.Action;

public class RequiredActionMissingException extends Exception {

	private Action missingAction;

	public RequiredActionMissingException() {
		// TODO Auto-generated constructor stub
	}

	public RequiredActionMissingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RequiredActionMissingException(String message, Action missingAction) {
		super(message);
		this.missingAction = missingAction;
	}

	public Action getMissingAction() {
		return missingAction;
	}

	public void setMissingAction(Action missingAction) {
		this.missingAction = missingAction;
	}

}
