package com.log.view.application.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LogResponseDto {
    private String message;
    private LocalDateTime timestamp;
    private String logLevel;
    private String loggerName;
    private String traceId;
    private String spanId;
    private String entityName;
    private String errorClass;
    private String errorMessage;
    private String errorStack;
}
