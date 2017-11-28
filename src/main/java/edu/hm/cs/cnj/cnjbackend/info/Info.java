package edu.hm.cs.cnj.cnjbackend.info;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Server-Info")
public class Info {
    @ApiModelProperty(example = "Allet super!", readOnly = true)
    private String message;

    public Info() {
        // Default constructor.
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
