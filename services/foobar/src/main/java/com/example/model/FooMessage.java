package com.example.model;

import com.eureka2.shading.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by libin on 3/16/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FooMessage {
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return name + ":" + message;
    }
}
