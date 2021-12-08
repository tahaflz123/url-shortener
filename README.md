# url-shortener

A simple url shortener application...

POST http://www.localhost:8080/user/signup creates a user and returns created user's userId 
request body {username, password}

POST http://www.localhost:8080/user/{userId}/url/create?url={yourUrl} 

returns shortened url like http://www.localhost:8080/s/xxxxxxxxxxxx 


GET http://www.localhost:8080/s/xxxxxxxxxxxx when you give request, this url redirects to shortened url.



Also you can view, delete your urls with this requests;

DELETE http://localhost:8080/user/{userId}/url/detail/{urlId} deletes shortened url with userId and urlId.

GET http://localhost:8080/user/{userId}/url/list returns list your shortened urls with userId and urlId.

GET http://localhost:8080/user/{userId}/url/detail/{urlId} returns shortened url with userId and urlId.
