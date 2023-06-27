package com.log.view.infrastructure;

import com.log.view.infrastructure.model.LogModel;

import java.util.List;

public interface DataReader {
    List<LogModel> jsonLogReader();

    List<String> deploymentTextReader();

    boolean isDeploymentTextPresent();
}
