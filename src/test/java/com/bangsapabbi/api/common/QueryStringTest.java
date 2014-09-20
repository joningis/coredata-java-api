package com.bangsapabbi.api.common;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Map;

import com.google.common.collect.Maps;

public class QueryStringTest {

    @Test
    public void testNoParameters() {
         QueryString queryString = new QueryString();
        assertThat(queryString.toString(), is(""));
    }



    @Test
    public void testOneParameter() {
        QueryString queryString = new QueryString();
        queryString.add("key", "value");
        assertThat(queryString.toString(), is("?key=value"));
    }

    @Test
    public void testOneStringParameterWithSpace() {
        QueryString queryString = new QueryString();
        queryString.add("key", "value stuff");
        assertThat(queryString.toString(), is("?key=value+stuff"));
    }

    @Test
    public void testMultipleParametersUsingAdd() {
        QueryString queryString = new QueryString();
        queryString.add("key", "value");
        queryString.add("key2", "value2");
        queryString.add("key3", "value3");
        assertThat(queryString.toString(), is("?key3=value3&key2=value2&key=value"));
    }

    @Test
    public void testMultipleParametersUsingAddAll() {
        QueryString queryString = new QueryString();
        Map<String, String> parameters = Maps.newHashMap();
        parameters.put("key", "value");
        parameters.put("key2", "value2");
        parameters.put("key3", "value3");
        queryString.addAll(parameters);
        assertThat(queryString.toString(), is("?key3=value3&key2=value2&key=value"));
    }

}