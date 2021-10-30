package com.src.Internship.Project_Version1.Internship_Project_Version1.Logic;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.ws.rs.core.Response;

import com.src.Internship.Project_Version1.InternshipProject_Version1.ResponseCommon.ResponseDetails;
import com.src.Internship.Project_Version1.Internship_Project_Version1.Util.DatabaseHolder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.src.Internship.Project.Internship_Project.Entity.RequestBody;

public class UserQuestionnaireLogicTest {
	private static final int OK_CODE = 201;
	private static final String OK_MESSAGE = "アンケートが登録されました。";
	private static final int BAD_REQUEST_CODE = 400;
	private static final String BAD_REQUEST_MESSAGE = "リクエスト形式に誤りがあります。";
	private static final int DATABASE_ERROR_CODE = 500;
	private static final String DATABASE_ERROR_MESSAGE = "データベースへの接続に問題があります。";

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
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
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
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertEquals(OK_CODE,responseEntity.getCode());
			assertEquals(OK_MESSAGE,responseEntity.getMessage());
		}
	}
	@Test
	public void testService_E400_1() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
			RequestBody body = new RequestBody();
			body.setAge("24");
			body.setUsername("テスト太郎");
			body.setQuestion1("テスト");
			body.setQuestion2("テスト");
			body.setQuestion3("テスト");
			body.setQuestion4("テスト");
			body.setQuestion5("テスト");
			body.setQuestion6("テスト");
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForBadRequest(responseEntity);
		}
	}

	@Test
	public void testService_E400_2() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
			RequestBody body = new RequestBody();
			body.setAge("26");
			body.setSex("男");
			body.setUsername("テスト太郎");
			body.setQuestion2("テスト");
			body.setQuestion3("テスト");
			body.setQuestion4("テスト");
			body.setQuestion5("テスト");
			body.setQuestion6("テスト");
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForBadRequest(responseEntity);
		}
	}

	@Test
	public void testService_E400_3() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
			RequestBody body = new RequestBody();
			body.setAge("fff");
			body.setSex("男");
			body.setUsername("テスト太郎");
			body.setQuestion1("T");
			body.setQuestion2("テスト");
			body.setQuestion3("テスト");
			body.setQuestion4("テスト");
			body.setQuestion5("テスト");
			body.setQuestion6("テスト");
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForBadRequest(responseEntity);
		}
	}

	@Test
	public void testService_E400_4() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
			RequestBody body = new RequestBody();
			body.setAge("-11");
			body.setSex("男");
			body.setUsername("テスト太郎");
			body.setQuestion1("T");
			body.setQuestion2("テスト");
			body.setQuestion3("テスト");
			body.setQuestion4("テスト");
			body.setQuestion5("テスト");
			body.setQuestion6("テスト");
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForBadRequest(responseEntity);
		}
	}

	@Test
	public void testService_E400_5() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
			RequestBody body = new RequestBody();
			body.setAge("27");
			body.setSex("男");
			body.setQuestion1("T");
			body.setQuestion2("テスト");
			body.setQuestion3("テスト");
			body.setQuestion4("テスト");
			body.setQuestion5("テスト");
			body.setQuestion6("テスト");
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForBadRequest(responseEntity);
		}
	}

	@Test
	public void testService_E400_6() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
			RequestBody body = new RequestBody();
			body.setAge("27");
			body.setSex("男");
			body.setQuestion2("テスト");
			body.setQuestion3("テスト");
			body.setQuestion4("テスト");
			body.setQuestion5("テスト");
			body.setQuestion6("テスト");
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForBadRequest(responseEntity);
		}

	}

	@Test
	public void testService_E400_7() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
			RequestBody body = new RequestBody();
			body.setAge("27");
			body.setSex("男");
			body.setQuestion1("T");
			body.setQuestion3("テスト");
			body.setQuestion4("テスト");
			body.setQuestion5("テスト");
			body.setQuestion6("テスト");
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForBadRequest(responseEntity);
		}
	}

	@Test
	public void testService_E400_8() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
			RequestBody body = new RequestBody();
			body.setAge("27");
			body.setSex("男");
			body.setQuestion1("T");
			body.setQuestion2("テスト");
			body.setQuestion4("テスト");
			body.setQuestion5("テスト");
			body.setQuestion6("テスト");
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForBadRequest(responseEntity);
		}

	}

	@Test
	public void testService_E400_9() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			mockData(databaseHolderMocked);
			RequestBody body = new RequestBody();
			body.setAge("27");
			body.setSex("男");
			body.setQuestion1("T");
			body.setQuestion2("テスト");
			body.setQuestion3("テスト");
			body.setQuestion5("テスト");
			body.setQuestion6("テスト");
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForBadRequest(responseEntity);
		}
	}

	private void mockData(MockedStatic<DatabaseHolder> databaseHolderMocked) throws SQLException {
		databaseHolderMocked.when(DatabaseHolder::getConnection).thenReturn(con);
		Mockito.when(con.prepareStatement(anyString())).thenReturn(ps);
		Mockito.when(ps.executeUpdate()).thenReturn(1);
		Mockito.when(ps.executeQuery()).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(true);
	}


	private void assertForBadRequest(ResponseDetails responseDetails){
		assertEquals(BAD_REQUEST_CODE,responseDetails.getCode());
		assertEquals(BAD_REQUEST_MESSAGE,responseDetails.getMessage());
	}

	@Test
	public void testService_E500_1() throws SQLException{
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			databaseHolderMocked.when(DatabaseHolder::getConnection).thenThrow(new SQLException());
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
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForDatabaseError(responseEntity);
		}
	}

	@Test
	public void testService_E500_2() throws SQLException {
		try(MockedStatic<DatabaseHolder> databaseHolderMocked = Mockito.mockStatic(DatabaseHolder.class)){
			databaseHolderMocked.when(DatabaseHolder::getConnection).thenReturn(con);
			Mockito.when(con.prepareStatement(anyString())).thenReturn(ps);
			Mockito.when(ps.executeQuery()).thenReturn(rs);
			Mockito.when(rs.next()).thenReturn(true);
			Mockito.when(ps.executeUpdate()).thenThrow(new SQLException());
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
			Response response = UserQuestionnaire.CRUDService(body);
			ResponseDetails responseEntity = (ResponseDetails)response.getEntity();
			assertForDatabaseError(responseEntity);
		}
	}

	private void assertForDatabaseError(ResponseDetails responseDetails){
		assertEquals(DATABASE_ERROR_CODE,responseDetails.getCode());
		assertEquals(DATABASE_ERROR_MESSAGE,responseDetails.getMessage());
	}
}
