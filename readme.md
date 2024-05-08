# API Authentication JWT

## Creating first user admin
Create an `admin role user` and then change the rule in `br/com/auth/infra/configuration/security/SecurityConfigurations.java`. At line 35, replace `.permitAll()` with `.hasRole("ADMIN")`.

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

Authentication Bearer: token from `/auth/login`

Response:

Status: `200 OK`

Content Type: `Text`

    Authenticated User
