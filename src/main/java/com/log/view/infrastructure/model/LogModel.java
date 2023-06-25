package com.log.view.infrastructure.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogModel {
    private String message;
    private Long timestamp;
    private String logLevel;
    private String loggerName;
    private String traceId;
    private String spanId;
    private String entityName;
    private String errorClass;
    private String errorMessage;
    private String errorStack;
}
