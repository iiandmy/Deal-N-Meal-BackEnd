## BACK-END Endpoints
##### Parent endpoint -- konstanta.tech:8081
## Users: /user
- POST /registration
- POST /login
- GET /logout
## Restaurants: /restaurants
#### Restaurant search entity:
```JSON
{
	restaurant_id: Int,
	name: String,
	category: String,
	img: String,
	description: String,
	address: {
		wid: Float,
		len: Float	
	}
}
```
#### Restaurant entity:
```JSON
{
	restaurant_id: Int,
	owner: Owner_DTO,
	menus: [Menu],
	category: String,
	reviews: [Review],
	name: String,
	description: String,
	img: String,
	address: {
		wid: double,
		len: double
	},
	phone_number: String,
	email: String
}
```
----
- GET /search/{json}
#### Request:
```json
{
	current_location: {
		wid: double,
		len: double
	},
	parameter: String,
	search_string: String
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
