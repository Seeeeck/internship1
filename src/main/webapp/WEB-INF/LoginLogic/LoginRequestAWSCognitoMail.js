const poolData = {
  UserPoolId: '',
  ClientId: '' //AWS Cognito ClientID
};

const userPool = new AmazonCognitoIdentity.CognitoUserPool(poolData);

// Amazon Cognito 認証情報プロバイダーを初期化します
AWS.config.region = ''; // リージョン
AWS.config.credentials = new AWS.CognitoIdentityCredentials({
  IdentityPoolId: '',
});