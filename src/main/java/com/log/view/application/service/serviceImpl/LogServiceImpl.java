package com.log.view.application.service.serviceImpl;

import com.log.view.application.dto.LogResponseDto;
import com.log.view.application.service.LogService;
import com.log.view.persistence.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Override
    public List<String> allComponents() {
        return logRepository.allComponents();
    }

    @Override
    public boolean syncLogs(List<String> components) {
        return logRepository.syncLogs(components);
    }

    @Override
    public List<LogResponseDto> logsFilter(String traceId, String message) {
        return logRepository.logsFilter(traceId, message);
    }
}
