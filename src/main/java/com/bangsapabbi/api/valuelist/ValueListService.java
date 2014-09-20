package com.bangsapabbi.api.valuelist;

import org.apache.commons.lang.WordUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractService;
import com.bangsapabbi.api.common.ContainerImpl;
import com.google.gson.reflect.TypeToken;

public class ValueListService extends AbstractService<ValueList> {

    private static final String TYPE = "valuelists";

    public ValueListService(final CoredataClient coredataClient,
                            final Client client,
                            final String baseUrl) {

        super(coredataClient, client, baseUrl, "valuelists", ValueList.class,
                new TypeToken<ContainerImpl<ValueList>>() {
                }.getType());
    }

    /**
     * Only do this to increase readability.
     *
     * @param title Title of the valuelist.
     * @return The valuelist.
     */
    @Override
    public ValueList get(final String title) {
        String input = URLEncoder.encode(title);
        return super.get(input);
    }


    /**
     * Method to generate Enum for valuelists.
     * Should only be used to generate when working on the source code.
     *
     * @param title Title of the value list.
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public void generateEnumForValuelist(final String title)
            throws FileNotFoundException, UnsupportedEncodingException {
        ValueList valueList = this.get(title);

        String className = WordUtils.capitalizeFully(
                valueList.getName().replace("_", " ")).replace(" ", "");

        EnumGenerator generator =
                new EnumGenerator("com.bangsapabbi.api.valuelist.lists", className);
        Map<String, String> input = new HashMap<>();

        for (ValueListEntry entry : valueList.getEntries()) {
            input.put(entry.getTranslations().get("en"), entry.getName());
        }

        PrintWriter writer = new PrintWriter("src/main/java/com/bangsapabbi/api/valuelist/lists/"
                + className + ".java", "UTF-8");
        writer.println(generator.buildEnum(input));
        writer.close();
    }
}