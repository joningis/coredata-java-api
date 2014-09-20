package com.bangsapabbi.api.common;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

public class DateDeserializerTest {

    @Test
    public void testDeserializeSupportedString1() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer()).create();

        Date date = gson.fromJson("\"2014-09-12T14:52:01\"", Date.class);

        assertThat(date.getYear(), is(2014 - 1900));
        assertThat(date.getMonth(), is(9 - 1));
        assertThat(date.getDate(), is(12));
        assertThat(date.getHours(), is(14));
        assertThat(date.getMinutes(), is(52));
        assertThat(date.getSeconds(), is(1));
    }

    @Test
    public void testDeserializeSupportedString2() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer()).create();

        Date date = gson.fromJson("2014-09-17", Date.class);

        assertThat(date.getYear(), is(2014 - 1900));
        assertThat(date.getMonth(), is(9 - 1));
        assertThat(date.getDate(), is(17));
    }

    @Test(expected = JsonParseException.class)
    public void testDeserializeUnsupportedString() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer()).create();

        Date date = gson.fromJson("sept 09, 2014", Date.class);

        fail();
    }

}