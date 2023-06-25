package com.log.view.persistence.mapper;

import com.log.view.application.dto.LogResponseDto;
import com.log.view.infrastructure.model.LogModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;

@Mapper
public interface LogMapper {

    LogMapper INSTANCE = Mappers.getMapper(LogMapper.class);

    default LogResponseDto map(LogModel model) {
        Timestamp timestampObj = new Timestamp(model.getTimestamp());

        return LogResponseDto
                .builder()
                .message(model.getMessage())
                .timestamp(timestampObj.toLocalDateTime())
                .logLevel(model.getLogLevel())
                .loggerName(model.getLoggerName())
                .traceId(model.getTraceId())
                .spanId(model.getSpanId())
                .entityName(model.getEntityName().replace("-dev", ""))
                .errorClass(model.getErrorClass())
                .errorMessage(model.getErrorMessage())
                .errorStack(model.getErrorStack())
                .build();
    }

}
