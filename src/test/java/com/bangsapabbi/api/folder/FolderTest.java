package com.bangsapabbi.api.folder;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class FolderTest {
    @Test
    public void testNoViolations() throws Exception {
        Folder folder = new Folder();
        folder.setTitle("title");
        folder.setFilename("filename");
        folder.setParentUUID("5cc68cd4-8ce6-11e3-a69a-6003088b5c52");

        assertThat(folder.getViolationsAsString(), isEmptyString());
    }

    @Test
    public void testWithViolation() throws Exception {
        Folder folder = new Folder();
        folder.setTitle("title");
        folder.setParentUUID("5cc68cd4-8ce6-11e3-a69a-6003088b5c52");

        assertThat(folder.getViolationsAsString(),
                is("filename may not be null"));
    }

    @Test
    public void testWithViolations() throws Exception {
        Folder folder = new Folder();
        folder.setParentUUID("5cc68cd4-8ce6-11e3-a69a-6003088b5c52");


        assertThat(folder.getViolationsAsString(),
                anyOf( is("filename may not be null\ntitle may not be null"),
                        is("title may not be null\nfilename may not be null")) );
    }

    @Test
    public void testWithParentUUIDErrorInFormat() {
        Folder folder = new Folder();
        folder.setTitle("title");
        folder.setFilename("filename");
        folder.setParentUUID("5cc68cd4-8ce6-11e3-a69a-6003088b5c5");

        assertThat(folder.getViolationsAsString(),
                is("parentUUID Invalid parent ID, must match [a-f0-9]{8}-[a-f0-9]{4}-" +
                        "[a-f0-9]{4}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}"));
    }

}