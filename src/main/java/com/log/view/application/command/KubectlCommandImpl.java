package com.log.view.application.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class KubectlCommandImpl implements KubectlCommand {

    @Value("${command.deploymentFileName}")
    private String deploymentFileName;

    @Value("${command.deploymentComponents}")
    private String deploymentComponentsCommand;

    @Value("${command.logComponents}")
    private String logComponentsCommand;

    @Value("${folder.path}")
    private String folderPath;

    @Override
    public void deploymentComponentsExecute() {
        executeCommand(deploymentComponentsCommand + " > " + deploymentFileName);
    }

    @Override
    public void logComponentsExecute(List<String> components) {
        components.forEach(component -> executeCommand(logComponentsCommand + component + " > " + folderPath + "/" + component + ".json"));
    }

    private void executeCommand(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("cmd.exe", "/c", command);
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                log.info("Comando ejecutado. Codigo de salida: {}", exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
