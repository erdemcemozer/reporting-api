# reporting-api

Hello, this is an application written with Java & Spring Boot. Java version is 17.

⚠️ **IMPORTANT**<br>

There was some problems on the Reporting API Document, some fields were not written on the request&response parameters. If there are more, these can cause some problems. For your information!<br>

Also this was a project for API calls, so for the unit tests I have tested some of my util classes.<br>

⚠️ **IMPORTANT**

## Architecture
I created controllers, services and external api classes for my rest api.<br>

Also I have response, model, util, constants folders which stores the classes for these exact works. Also I have a folder for test class.

An example:
```
LoginController -> LoginService -> LoginAPI
```

Controllers receive the requests, then passes the body data of the requests to service class.<br>

Services take this body data's to API classes.<br>

API classes are the key part of project, which does the external API calls to Reporting API.<br>

For holding the token comes with the response of the login call, I created a singleton TokenStorage class. In this way I can use the token whenever I want. So I didn't implemented a database to project, it's all working in-memory.
