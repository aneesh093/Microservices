package com.talkyteck.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = "Response", description = "Response DTO"
)
@Data
@AllArgsConstructor
public class ResponseDTO {
    @Schema(
            name = "statusCode", description = "Status code of the response",example = "200"
    )
    private String statusCode;

    @Schema(
            name = "statusMsg", description = "Status message of the response",example = "Success"
    )
    private String statusMsg;
}
