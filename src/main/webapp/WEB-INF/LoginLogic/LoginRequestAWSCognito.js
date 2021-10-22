// 1Amazon Cognito 認証情報プロバイダーを初期化します
// Amazon Cognito 認証情報プロバイダーを初期化します
AWS.config.region = ''; // AWS Cognito構築先リージョン
AWS.config.credentials = new AWS.CognitoIdentityCredentials({
  IdentityPoolId: '', //AWS Cognito IdentityPoolId
});

AWSCognito.config.region = ''; 
AWSCognito.config.credentials = new AWS.CognitoIdentityCredentials({
  IdentityPoolId: '', 
});