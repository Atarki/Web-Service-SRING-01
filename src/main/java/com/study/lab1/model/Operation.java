package com.study.lab1.model;

public enum Operation {
    WIDTHDRAW("w"), COUNTERBALANCE("cb");

    private String id;

    Operation(String id) {
        this.id = id;
    }

    public static Operation getOperation(String id) {
        for (Operation operation : values()) {
            if (operation.id.equals(id)) {
                return operation;
            }
        }

        throw new IllegalArgumentException("Not valid operation with id " + id);
    }

}
