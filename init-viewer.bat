@echo off

start cmd /k "java -jar view-0.0.1-SNAPSHOT.jar"
timeout /T 3 /nobreak > NUL
start http://localhost:9000
