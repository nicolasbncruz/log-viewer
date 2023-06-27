package com.log.view.application.command;

import java.util.List;

public interface KubectlCommand {
    void deploymentComponentsExecute();

    void logComponentsExecute(List<String> components);
}
