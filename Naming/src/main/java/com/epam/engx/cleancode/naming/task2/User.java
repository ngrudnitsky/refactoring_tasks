package com.epam.engx.cleancode.naming.task2;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class User implements Serializable {

    private Date birthdayDate;

    private String name;

    private boolean admin;

    private User[] subordinateUsers;

    private int subordinateRating;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public User[] getSubordinateUsers() {
        return subordinateUsers;
    }

    public User getSubordinateUsers(int index) {
        return subordinateUsers[index];
    }

    public void setSubordinateUsers(User[] subordinateUsers) {
        this.subordinateUsers = subordinateUsers;
    }

	public void setSubordinateUsers(int index, User user) {
		this.subordinateUsers[index] = user;
	}

    public int getSubordinateRating() {
        return subordinateRating;
    }

    public void setSubordinateRating(int subordinateRating) {
        this.subordinateRating = subordinateRating;
    }

    @Override
    public String toString() {
        return "User [dBirth=" + birthdayDate + ", sName=" + name + ", bAdmin=" + admin + ", subordinateArray="
                + Arrays.toString(subordinateUsers) + ", iRating=" + subordinateRating + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isAdmin() != user.isAdmin()) return false;
        if (getSubordinateRating() != user.getSubordinateRating()) return false;
        if (getBirthdayDate() != null ? !getBirthdayDate().equals(user.getBirthdayDate()) : user.getBirthdayDate() != null)
            return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        return Arrays.equals(getSubordinateUsers(), user.getSubordinateUsers());
    }

    @Override
    public int hashCode() {
        int result = getBirthdayDate() != null ? getBirthdayDate().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (isAdmin() ? 1 : 0);
        result = 31 * result + Arrays.hashCode(getSubordinateUsers());
        result = 31 * result + getSubordinateRating();
        return result;
    }
}
