package com.example.EmpSystem.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DefaultResponse {
    @JsonProperty("STATUS")
    private String status;
    @JsonProperty("MESSAGE")
    private String message;
    @JsonProperty("DATA")
    private Object data;

    public DefaultResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
