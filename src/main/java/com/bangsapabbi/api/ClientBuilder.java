package com.bangsapabbi.api;

/**
 * Class that builds coredata client.
 */
public final class ClientBuilder {

    private ClientBuilder() {
    }


    public static CoredataClient newClient(final String baseUrl,
                                           final String username,
                                           final String password) {
        return new CoredataClientImpl(baseUrl, username, password);
    }
}
