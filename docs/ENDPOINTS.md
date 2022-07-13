## BACK-END Endpoints
##### Parent endpoint -- konstanta.tech:8081
## Registration, authentication and authorization 
- PUT /registration
```json
{
	"name": "konstantin",
	"surname": "volkov",
	"email": "volkovkonstantinn@gmail.com",
	"contactNumber": "+375445618573",
	"birthDate" : "2002/11/01",
	"username": "konstantin",
	"password": "3ed815"
}
```
- POST /login
## Request
#### Working with Http-body
#### key: username, value: USERNAME_ПОЛЬЗОВАТЕЛЯ
#### key: password, value: PASSWORD_ПОЛЬЗОВАТЕЛЯ

## Response
```json
{
    "Access-Token": "ACCESS_TOKEN_VALUE",
    "Refresh-Token": "REFRESH_TOKEN_VALUE"
}
```

## All other requests to server has to contain HTTP-Header:
#### key: Authorization value: Bearer access-token-value
#### if there's an error like: "Token has expired" you have to refresh access-token sending GET-request to /refreshToken with HTTP-Header: 
#### Authorization value: Bearer Refresh-token-value
#### The server will give you response like:
```json
{
    "Access-Token": "ACCESS_TOKEN_VALUE",   -new access token
    "Refresh-Token": "REFRESH_TOKEN_VALUE"
}

````
## Post /giveRole
#### Only for users, who has ROLE_ADMIN

```json
{ 
    "username" : "USERNAME",
    "roles":
    [
        "ROLE_NAME"
    ]
}
```

## Post /addNewRole
#### Only for users, who has ROLE_ADMIN

```json
{ 
    "role_names":
    [
        "ROLE_NAME",
	"ROLE_NAME",
	"ROLE_NAME"
    ]
}


## Restaurants: /restaurants
#### Restaurant search entity:
```json
{
	"restaurant_id": 101,
	"name": "KFC",
	"category": "healthy-food",
	"img": "www.mcdonaldssucks.com/burgerkingtop.jpg",
	"description": "Healthy food for all family. Feels Good.",
	"address": {
		"wid": 102.32162745426,
		"len": 58.35167723421
	}
}
```
#### Restaurant entity:
```json
{
	"restaurant_id": 100,
	"owner": Owner_DTO,
	"menus": [Menu],
	"category": "fast-food",
	"reviews": [Review],
	"name": "McDonald's",
	"description": "Tasty and that's the point.",
	"img": "www.supercoolimghost.com/burgerking",
	"address": {
		"wid": 102.32162745426,
		"len": 58.35167723421
	},
	"phone_number": "+375291488228",
	"email": "kfc@mail.ru"
}
```
----
- GET /search/{json}
#### Request:
```json
{
	"current_location": {
		"wid": 102.32162745426,
		"len": 58.35167723421
	},
	"parameter": "name",
	"search_string": "McDonald's"
}
```
#### Response
```json
[Restaurant]
```
---
- GET /categories
```JSON
[String]
```
