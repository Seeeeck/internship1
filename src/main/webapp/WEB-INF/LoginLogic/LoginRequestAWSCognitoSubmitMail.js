// Amazon Cognito 認証情報プロバイダーを初期化します
AWS.config.region = ''; // リージョン
AWS.config.credentials = new AWS.CognitoIdentityCredentials({
  IdentityPoolId: '',
});

// Amazon Cognito Userpoolの指定＋クライアントアプリの指定
const poolData = {
  UserPoolId: '', //ユーザープールのID
  ClientId: '' //クライアントアプリの設定上のID
};
//ユーザープール＋クライアントアプリの情報を格納
const userPool = new AmazonCognitoIdentity.CognitoUserPool(poolData);
let attributeList = []; //本来であればattributelistに電話番号や住所など入れることも可能（今回はしない）
