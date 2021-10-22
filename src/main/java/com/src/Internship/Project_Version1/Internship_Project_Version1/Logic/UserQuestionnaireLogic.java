package com.src.Internship.Project_Version1.Internship_Project_Version1.Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import com.src.Internship.Project.Internship_Project.Entity.RequestBody;
import com.src.Internship.Project_Version1.InternshipProject_Version1.ResponseCommon.ResponseCommon;
import com.src.Internship.Project_Version1.InternshipProject_Version1.ResponseCommon.ResponseDetails;
import com.src.Internship.Project_Version1.Internship_Project_Version1.Util.StringUtil;

@RequestScoped
public class UserQuestionnaireLogic {

	private final static String URL = "jdbc:postgresql://localhost:5432/UserRegistrationAPI"; //PostgreSQL接続情報（タイプ：URL）
	private final static String USER = "postgres"; //PostgreSQL接続情報（タイプ：PostgreSQLログインユーザー名）
	private final static String PASSWORD = "123456"; //PostgreSQL接続情報（タイプ：PostgreSQLログインパスワード）

	
	public UserQuestionnaireLogic() {
	}

	
	public Response CRUDService(RequestBody requestBody) {
		if(RequestBodyCheck(requestBody)) {
			return GenerateResponse(ResponseCommon.BAD_REQUEST);
		}
		System.out.println("RequestBodyCheck:正常終了");
		try {
			String id = GenerateddbConnectionGetseqId();
			System.out.println("GenerateddbConnectionGetseqId:正常終了");
			return GeneratedbConnectionInsert(requestBody,id);
		} catch (SQLException e) {
			e.printStackTrace();
			return GenerateResponse(ResponseCommon.SQL_ERROR);
		}
	}
	
	private boolean RequestBodyCheck(RequestBody body) {
		boolean badRequest = StringUtil.isEmpty(body.getSex()) ||
				StringUtil.isEmpty(body.getAge()) ||
				StringUtil.isEmpty(body.getUsername()) ||
				StringUtil.isEmpty(body.getQuestion1()) ||
				StringUtil.isEmpty(body.getQuestion2()) ||
				StringUtil.isEmpty(body.getQuestion3()) ||
				StringUtil.isEmpty(body.getQuestion4()) ||
				StringUtil.isEmpty(body.getQuestion5()) ||
				StringUtil.isEmpty(body.getQuestion6());
		try{
			int age = Integer.parseInt(body.getAge());
			return age <= 0 || badRequest;
		}catch (NumberFormatException e){
			return true;
		}
	}


	private Response GenerateResponse(ResponseCommon responsecommon) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		ResponseDetails responsedetails = new ResponseDetails(responsecommon.getCode(), dateFormat.format(new Date()), responsecommon.getMessage());
		return Response.status(responsecommon.getCode()).entity(responsedetails).build();
	}
	
	private String GenerateddbConnectionGetseqId() throws SQLException {
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT NEXTVAL('questionnaireseqno')");
					ResultSet resultset = preparedStatement.executeQuery()){
			resultset.next();
			int nextVal = resultset.getInt("nextval");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			return dateFormat.format(new Date()) + convertInt2Str(nextVal);
		}
	}

	private String convertInt2Str(int nextVal) {
		char[] intChars = new char[7];
		int i = intChars.length - 1;
		while (nextVal > 0){
			intChars[i--] = Character.forDigit(nextVal % 10,10);
			nextVal /= 10;
		}
		while (i >= 0){
			intChars[i--] = '0';
		}
		return String.valueOf(intChars);
	}

	/**
	 * リクエストを受け付けたアンケートをデータベースであるPostgreSQLへ格納するロジックをコーディングするメソッド
	 * ヒント：try-with-resource
	 * @return
	 */
	private Response GeneratedbConnectionInsert(RequestBody requestBody,String id) {
		String sql = "INSERT INTO userregistrationapi VALUES(?,?,?,?,?,?,?,?,?,?)";
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			setStatement(preparedStatement,requestBody,id);
			preparedStatement.executeUpdate();
			System.out.println("GeneratedbConnectionInsert:正常終了");
			return GenerateResponse(ResponseCommon.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return GenerateResponse(ResponseCommon.SQL_ERROR);
		}
	}

	private void setStatement(PreparedStatement preparedStatement,RequestBody requestBody, String id) throws SQLException {
		preparedStatement.setString(1,id);
		preparedStatement.setString(2, requestBody.getSex());
		preparedStatement.setInt(3, Integer.parseInt(requestBody.getAge()));
		preparedStatement.setString(4,requestBody.getUsername());
		preparedStatement.setString(5,requestBody.getQuestion1());
		preparedStatement.setString(6,requestBody.getQuestion2());
		preparedStatement.setString(7, requestBody.getQuestion3());
		preparedStatement.setString(8, requestBody.getQuestion4());
		preparedStatement.setString(9, requestBody.getQuestion5());
		preparedStatement.setString(10, requestBody.getQuestion6());
	}

}
