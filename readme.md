# API Authentication JWT

## Post `/auth/register`

Request `Application/json`

        {
	        "name":"test",
	        "email":"teste@example.com",
	        "password":"123",
	        "role": "USER"
        }

Response:

Status: `200 OK`

Content Type: `Application/json`



## Post `/auth/login`

Request `Application/json`

        {
	        "email":"teste@example.com",
	        "password":"123"
        }   

Response:

Status: `200 OK`

Content Type: `Application/json`

        {
            "email": "teste@example.com",
            "token": "token"
        }

## Get `/test/userEndpoint`

Request: 

Authentication Bearer: token from `/login`

Response:

Status: `200 OK`

Content Type: `Text`

    Authenticated User