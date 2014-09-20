coredata-java-api
=================

![Build status](https://travis-ci.org/joningis/coredata-java-api.svg?branch=master)


CoreData is a web-based solution that manages all information and projects for companies and public bodies.Contact us
CoreData ECM is a SaaS (software as a service) subscription software package that is based on a modern approach to the management of all information and projects for companies and public bodies. The software also includes a comprehensive quality system. The focus is on a flexible, user-friendly interface that users can connect to online. CoreData is easy to access via all major browsers or with smart phones and tablets. 
CoreData is the first solution in Iceland to use Mobile ID authentication for signing documents. Mobile ID ensures authentication of users both when logging into CoreData and signing documents.

[http://www.azazo.com/coredata/](http://www.azazo.com/coredata/)

Java api client for Coredata

Supported Operations and examples

All examples depend on coredata client object

```java
 final CoredataClient client = ClientBuilder.newClient(
                "http://localhost:8100",
                username, password);
```
