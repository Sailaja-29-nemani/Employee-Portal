package com.employee.Dao;

public class Main {
	public static void main(String[] args) {
		RegisterDao dao = new RegisterDao();
		System.out.println(dao.isUser("705035", "Sailaja"));
	}
}
