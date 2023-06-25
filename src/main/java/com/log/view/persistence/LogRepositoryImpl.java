package com.log.view.persistence;

import com.log.view.application.dto.LogResponseDto;
import com.log.view.infrastructure.JsonReader;
import com.log.view.infrastructure.model.LogModel;
import com.log.view.persistence.mapper.LogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LogRepositoryImpl implements LogRepository {

    private final JsonReader jsonReader;

    @Override
    public List<String> allComponents() {
        List<String> components = Arrays.asList("test-user-boot", "test-intranet-boot", "test-authorization-boot");
        return components;
    }

    @Override
    public boolean syncLogs(List<String> components) {
        return false;
    }

    @Override
    public List<LogResponseDto> logsFilter(String traceId, String message) {
        List<LogModel> logModels = jsonReader.jsonLogReader();
        if (!traceId.isEmpty() || !message.isEmpty()) {
            logModels = logModels.stream().filter(log -> log.getTraceId().equals(traceId)).collect(Collectors.toList());
        }
        return logModels.stream().map(LogMapper.INSTANCE::map).collect(Collectors.toList());
    }

}
