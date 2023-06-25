package com.log.view.persistence;

import com.log.view.application.dto.LogResponseDto;

import java.util.List;

public interface LogRepository {
    List<String> allComponents();

    boolean syncLogs(List<String> components);

    List<LogResponseDto> logsFilter(String traceId, String message);
}
