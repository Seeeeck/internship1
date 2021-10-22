package com.src.Internship.Project_Version1.InternshipProject_Versaion1.Logic;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.src.Internship.Project.Internship_Project.Entity.Request;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.src.Internship.Project.Internship_Project.Entity.RequestBody;
import com.src.Internship.Project_Version1.Internship_Project_Version1.Logic.UserQuestionnaireLogic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserQuestionnaireLogic.class})
public class UserQuestionnaireLogicTest {

	@Mock
	Connection con;

	@Mock
	PreparedStatement ps;

	@Mock
	ResultSet rs;

	@InjectMocks
	UserQuestionnaireLogic UserQuestionnaire;

	@Before
	public void setUp(){
		System.out.println("setUp");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testService_OK() throws SQLException{

		Mockito.when(con.prepareStatement(toString())).thenReturn(ps);
		Mockito.when(ps.executeQuery()).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(true);

		Request request = new Request();
		RequestBody body = new RequestBody();

		body.setSex("男");
		body.setAge("24");
		body.setUsername("テスト太郎");
		body.setQuestion1("テスト");
		body.setQuestion2("テスト");
		body.setQuestion3("テスト");
		body.setQuestion4("テスト");
		body.setQuestion5("テスト");
		body.setQuestion6("テスト");

	}
	@Test
	public void testService_E400_1() {
		MockitoAnnotations.initMocks(this);

		Request request = new Request();
		RequestBody body = new RequestBody();

		body.setAge("24");
		body.setUsername("テスト太郎");
		body.setQuestion1("テスト");
		body.setQuestion2("テスト");
		body.setQuestion3("テスト");
		body.setQuestion4("テスト");
		body.setQuestion5("テスト");
		body.setQuestion6("テスト");

	}

	@Test
	public void testService_E400_2() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testService_E400_3() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testService_E400_4() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testService_E400_5() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testService_E400_6() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testService_E400_7() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testService_E400_8() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testService_E400_9() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testService_E500_1() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testService_E500_2() throws SQLException {

	}
}
