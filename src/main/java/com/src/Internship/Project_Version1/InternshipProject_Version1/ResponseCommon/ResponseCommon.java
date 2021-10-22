package com.src.Internship.Project_Version1.InternshipProject_Version1.ResponseCommon;

public enum ResponseCommon {
    BAD_REQUEST(400,"リクエスト形式に誤りがあります。"),
    SQL_ERROR(500,"データベースへの接続に問題があります。"),
    OK(201,"アンケートが登録されました。");

    private final int code;
    private final String message;

    ResponseCommon(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
