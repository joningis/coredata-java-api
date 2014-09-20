package com.bangsapabbi.api.file;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.bangsapabbi.api.CoredataClient;

public class FileServiceTest {

    private FileService service;
    private Response response;

    @Before
    public void setUp() throws Exception {
        CoredataClient coredataClient = mock(CoredataClient.class);
        Client client = mock(Client.class);

        WebTarget webTarget = mock(WebTarget.class);
        Invocation.Builder builder = mock(Invocation.Builder.class);
       this.response = mock(Response.class);

        when(client.target(anyString())).thenReturn(webTarget);
        when(webTarget.request(anyString())).thenReturn(builder);
        when(builder.get()).thenReturn(response);

        this.service = new FileService(coredataClient, client, "folders");


    }

    @Test(expected = IllegalArgumentException.class)
    public void testDownloadWithOutputFileAsDirectory() throws Exception {


        File file = new File();
        java.io.File outputFile = new java.io.File("gradle");

        service.download(file, outputFile, false);
    }

    @Test
    public void testDownloadOk() throws Exception {
        File file = new File();

        URL resource = getClass().getResource("/simple.txt");
        java.io.File inputFile = new java.io.File(resource.toURI());
        when(this.response.getEntity()).thenReturn(new FileInputStream(inputFile));

        java.io.File outputFile = java.io.File.createTempFile("temp_unit", ".txt");

      assertThat(service.download(file, outputFile, true), is(true));


        List<String> lines = Files.readAllLines(outputFile.toPath(), Charset.defaultCharset());
        assertThat(lines.get(0), is("Simple test txt file."));
        assertThat(lines.get(1), is("party file"));

        deleteTmpFile(outputFile);
    }

    @Test
    public void testDownloadWhenFileExistAndOverwriteFalse() throws Exception {
        File file = new File();
        java.io.File outputFile = java.io.File.createTempFile("temp_unit", ".txt");

        assertThat(service.download(file, outputFile, false), is(false));

        deleteTmpFile(outputFile);
    }

    private void deleteTmpFile(final java.io.File outputFile) {
        // Cleanup
        boolean deleted = false;
        try {
            deleted = outputFile.delete();
        } catch (SecurityException e) {
            // ignore
        }

        if (deleted) {
            System.err.println("Temp file deleted.");
        } else {
            outputFile.deleteOnExit();
            System.err.println("Temp file scheduled for deletion.");
        }
    }
}