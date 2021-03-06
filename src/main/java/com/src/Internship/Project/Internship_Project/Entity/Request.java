package com.src.Internship.Project.Internship_Project.Entity;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.HeaderParam;

@RequestScoped
public class Request {
	
		//性別
		@HeaderParam("sex")
		private String sex;
		
		//年齢
		@HeaderParam("age")
		private String age;
		
		//ユーザー名
		@HeaderParam("username")
		private String username;
		
		//アンケート項目1
		@HeaderParam("Question1")
		private String question1;
		
		//アンケート項目2
		@HeaderParam("Question2")
		private String question2;
		
		//アンケート項目3
		@HeaderParam("Question3")
		private String question3;
		
		//アンケート項目4
		@HeaderParam("Question4")
		private String question4;
		
		//アンケート項目5
		@HeaderParam("Question5")
		private String question5;
		
		//アンケート項目6
		@HeaderParam("Question6")
		private String question6;

	@Override
	public String toString() {
		return "Request{" +
				"sex='" + sex + '\'' +
				", age='" + age + '\'' +
				", username='" + username + '\'' +
				", question1='" + question1 + '\'' +
				", question2='" + question2 + '\'' +
				", question3='" + question3 + '\'' +
				", question4='" + question4 + '\'' +
				", question5='" + question5 + '\'' +
				", question6='" + question6 + '\'' +
				'}';
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}

	public String getQuestion5() {
		return question5;
	}

	public void setQuestion5(String question5) {
		this.question5 = question5;
	}

	public String getQuestion6() {
		return question6;
	}

	public void setQuestion6(String question6) {
		this.question6 = question6;
	}
}
