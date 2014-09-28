package com.bangsapabbi.api.project;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;

import com.bangsapabbi.api.valuelist.lists.ProjectStatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProjectSerializerTest {

    private  Gson gson = new GsonBuilder()
            .registerTypeAdapter(Project.class, new ProjectSerializer()).create();

    /**
     * This will not work if posted to server since we have no title and no parent.
     * This is just for testing purposes.
     */
    @Test
    public void testSerializeEmptyProject() {
        final Project project = new Project();

        assertThat(gson.toJson(project), is("{\"type\":\"Project\"}"));
    }

    @Test
    public void testSerializeProjectWithTitle() {
        final Project project = Project.Builder().title("ProTitle").build();

        assertThat(gson.toJson(project), is("{\"title\":\"ProTitle\",\"type\":\"Project\"}"));
    }

    @Test
    public void testSerializeProjectWithSpaceParent() {
        final Project project = Project.Builder().parentUUID("df-gdf").build();

        assertThat(gson.toJson(project), is("{\"type\":\"Project\",\"space\":\"df-gdf\"}"));
    }

    @Test
    public void testSerializeProjectWithProjectStatus() {
        final Project project = Project.Builder().status(ProjectStatus.ON_HOLD).build();

        assertThat(gson.toJson(project), is("{\"type\":\"Project\"," +
                "\"status\":\"project_status:On_hold:\"}"));
    }

    @Test
    @SuppressWarnings("deprecation")
    public void testSerializeProjectWithDueDate() {
        final Project project = Project.Builder()
                .dueDate(new Date(2014-1900, 2, 15, 11, 10, 10))
                .build();

        assertThat(gson.toJson(project), is("{\"type\":\"Project\"," +
                "\"due_date\":\"2014-03-15\"}"));
    }

    @Test
    public void testSerializeProjectWithDescription() {
        final Project project = Project.Builder().description("desSome").build();

        assertThat(gson.toJson(project), is("{\"type\":\"Project\"," +
                "\"description\":\"desSome\"}"));
    }


    @Test
    public void testSerializeProjectWithTags() {
        final Project project = Project.Builder().tags("Test", "Party").build();

        assertThat(gson.toJson(project), is("{\"type\":\"Project\"," +
                "\"tags\":[\"Test\",\"Party\"]}"));
    }

    @Test
    public void testSerializeProjectWithConnectedUsers() {
        final Project project = Project.Builder()
                .connectedUsers("jon", "jon2")
                .build();

        assertThat(gson.toJson(project), is("{\"type\":\"Project\"," +
                "\"connected_users\":[\"jon\",\"jon2\"]}"));
    }

    @Test
    public void testSerializeProjectWithContacts() {
        final Project project = Project.Builder()
                .contacts("14-14224-1234", "124-sdaf")
                .build();

        assertThat(gson.toJson(project), is("{\"type\":\"Project\"," +
                "\"contacts\":[\"14-14224-1234\",\"124-sdaf\"]}"));
    }
}