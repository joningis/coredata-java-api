coredata-java-api
=================

![Build status](https://travis-ci.org/joningis/coredata-java-api.svg?branch=master)

## Overview

This project is a Java api client for Coredata.

CoreData is a web-based solution that manages all information and projects for companies and public bodies.Contact us
CoreData ECM is a SaaS (software as a service) subscription software package that is based on a modern approach to the management of all information and projects for companies and public bodies. The software also includes a comprehensive quality system. The focus is on a flexible, user-friendly interface that users can connect to online. CoreData is easy to access via all major browsers or with smart phones and tablets. 
CoreData is the first solution in Iceland to use Mobile ID authentication for signing documents. Mobile ID ensures authentication of users both when logging into CoreData and signing documents.

[http://www.azazo.com/coredata/](http://www.azazo.com/coredata/)


## Usage

### Init

Everyting depend on coredata client object

* address: The address of the server (example "http://localhost:8100")
* username: Coredata username
* password: Coredata password for the user

```java
final CoredataClient client = ClientBuilder.newClient(address, username, password);
```

### Projects

To work with projects get a instance of a project service.

```java
 final ProjectService projectService = client.getProjectService();
 ```

 To get a single project

```java
 Project project = projectService.get("c0734736-3f79-11e4-8ab3-6003088b5c52");
 ```

 To delete a project

```java
 projectService.delete("c0734736-3f79-11e4-8ab3-6003088b5c52");
 ```

 To add a project. 
 Here we use spaceservice to get all spaces in the system and insert the project in the first space found.
 Also shown here is the validation framework in action. Project need to have title and parent uuid to be added. The validation does not check if the parent uuid is id of a space, only if the format is valid.

```java
 List<Space> spaces = Lists.newArrayList(spaceService.iterator());
        
	if(!spaces.isEmpty()) {
		Project project = new Project();
		project.setTitle("Test project");
		project.setParentUUID(spaces.get(0).getUUID());
            
		if (project.isValidForPost()) {
			projectService.add(project);
		} else {
			System.out.println(project.getViolationsAsString());
		}
	}
 ```

 Projects can also be created using project builder. Note that tags can be called multiple times.

```java
Project projectWithBuilder = Project.Builder()
	.title("Test builder")
	.parentUUID(spaces.get(0).getUUID())
	.status(ProjectStatus.CLOSED)
	.tag("Party")
	.tag("Time")
	.build();
 ```

 To iterate list of all projects

```java
for (Project project : projectService) {
    System.out.println(project);
}
 ```

To iterate over all files in a project

```java
for (File file : projectService.getFilesForProject(project)) {
    System.out.println(file);
}
 ```

To search for projects

```java
 Search search = SearchBuilder.newSearch()
                .titleStartsWith("Test")
                .createdGreaterThan(new Date(114, 1, 1))
                .limit(10)
                .create();

       List<Project> projects = projectService.search(search);
 ```


