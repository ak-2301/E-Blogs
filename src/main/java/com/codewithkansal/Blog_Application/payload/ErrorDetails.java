package com.codewithkansal.Blog_Application.payload;

import java.util.Date;

public class ErrorDetails {
    private String message;
    private String details;
    private Date timestamp;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
