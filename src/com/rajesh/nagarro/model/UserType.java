package com.rajesh.nagarro.model;

/**
 * enum for user types.
 * 
 */
public enum UserType {
	ADMIN, STUDENT, STAFF;

	public static UserType getUserStatus(String status) {
		for (UserType ut : UserType.values()) {
			if (ut.name().equals(status))
				return ut;
		}
		return null;
	}
}
