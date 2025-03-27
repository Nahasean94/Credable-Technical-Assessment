package com.credable.external.rest.client;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientRequest {
    private String url;
    private String name;
    private String username;
    private String password;

    // Constructors
    public ClientRequest() {}

    public ClientRequest(String url, String name, String username, String password) {
        this.url = url;
        this.name = name;
        this.username = username;
        this.password = password;
    }

}
