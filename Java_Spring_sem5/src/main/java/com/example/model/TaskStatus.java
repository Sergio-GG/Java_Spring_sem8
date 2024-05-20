package com.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TaskStatus {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED;

    @JsonCreator
    public static TaskStatus taskStatusForValue(String value) {
        return TaskStatus.valueOf(value.toUpperCase());
    }

}
