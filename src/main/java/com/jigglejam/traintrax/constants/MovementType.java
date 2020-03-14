package com.jigglejam.traintrax.constants;

public enum MovementType {
    PUSH("push"),
    PULL("pull");

    private String name;

    MovementType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
