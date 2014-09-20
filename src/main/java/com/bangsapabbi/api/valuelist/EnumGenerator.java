package com.bangsapabbi.api.valuelist;

import java.util.Iterator;
import java.util.Map;

public class EnumGenerator {

    private final String packageString;
    private final String name;

    public EnumGenerator(final String packageString, final String name) {
        this.packageString = packageString;
        this.name = name;
    }

    public String buildEnum(Map<String, String> values) {
        final StringBuilder builder = new StringBuilder();
        builder.append("package ").append(packageString).append(";\n").append('\n');
        builder.append("import com.google.gson.annotations.SerializedName;").append('\n').append('\n');
        builder.append("/**\n* Enum auto generated\n*/\n");
        builder.append("public enum ").append(name).append(" {").append('\n').append('\n');


        Iterator<Map.Entry<String, String>> it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();

            builder.append("@SerializedName(\"").append(entry.getValue()).append("\")").append('\n');

            builder.append(entry.getKey().toUpperCase()
                            .replaceAll(" ", "_")
                            .replaceAll("\\(", "_")
                            .replaceAll("\\)", "_")
                            .replaceAll("&", "AND")
                            .replaceAll("\\.", "_")
                            .replaceAll("-", "_")
                            .replaceAll("'", "_")
            );
            if (it.hasNext()) {
                builder.append(',').append('\n').append('\n');
            }
        }

        builder.append('\n').append("}").append('\n');

        return builder.toString();

    }
}
