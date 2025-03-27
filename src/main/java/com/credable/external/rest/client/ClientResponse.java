package com.credable.external.rest.client;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientResponse {
    private int id;
    private String url;
    private String name;
    private String username;
    private String password;
    private String token;


}
