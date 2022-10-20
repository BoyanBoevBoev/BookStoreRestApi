# BookStoreRestApi
# Introduction
- This repository is for educational purpose.
- This project uses Spring Boot. 
- All requests are based on Http protocol.
# Common Error Code
- 400 Bad Request – Invalid request format

- 401 Unauthorized – Invalid API Key

- 403 Forbidden – You do not have access to the requested resource

- 404 Not Found

- 429 Too Many Requests

- 500 Internal Server Error
# Error response
     {
    "http_status_code": "404",
    "http_method": "GET",
    "message": "Client doesn't exist"
    }
# User
- Get All Users: (GET) /users

- Response: 200 OK

{

    "users":[
    {
    "id":"24", 
    "name":"Ivan",
    "age":"25",
    "email":"ivanivano@abv.bg",
    "orders":{
    "id":"1",
    "books":{
    "title":"Pod igoto",
    "price":"25 "
    }
    }
    },
    {
    "id":"2",
    "name":"Gosho",
    "age":"36",
    "email":"goshogoshev@abv.bg",
    "orders":{
    "id":"2",
    "books":{
    "title":"Harry Potter and the Philosopher's Stone",
    "price":"40"
    }
    }
    }
    ]
    }

- Delete a User: (DELETE)/user/{id}
- 
  Response 

      {
       "Deleted customer id": "1"
      }
- Update a User: (PUT)/user/{id}

- Request Body:

      {
       "name":"Ivan",
       "age":"25",
       "email":"ivanivano@abv.bg"
      }
- Response: 200 OK
- Response Body:

      {
       "id":"24",
       "name":"Ivan",
       "age":"25",
       "email":"ivanivano@abv.bg"
      }

- Create a new User: (POST)/users:
- Request Body:
- 
-     {
      "name":"Ivan",
      "age":"25",
      "email":"ivanivano@abv.bg"
      }
-  Response 201 Created
