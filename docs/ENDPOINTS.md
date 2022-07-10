## BACK-END Endpoints
##### Parent endpoint -- konstanta.tech:8081
## Users: /user
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
## JSON не отправляется просто POST-запрос
```html 
<form method="POST">
	<input name="username">
	<input name="password">
	<button type="submit">
</form>
```
#### username html field: name="username"
#### password html field: name="password"

- GET /logout
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
