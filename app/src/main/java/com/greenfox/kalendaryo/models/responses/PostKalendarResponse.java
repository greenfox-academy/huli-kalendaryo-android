package com.greenfox.kalendaryo.models.responses;


public class PostKalendarResponse {
    String kalendarId;
    String status;

    public PostKalendarResponse(String kalendarId, String status) {
        this.kalendarId = kalendarId;
        this.status = status;
    }

    public PostKalendarResponse() {
    }

    public String getKalendarId() {
        return kalendarId;
    }

    public void setKalendarId(String kalendarId) {
        this.kalendarId = kalendarId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
