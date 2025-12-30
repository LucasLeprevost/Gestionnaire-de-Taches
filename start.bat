@echo off
:: 1. Base de données
docker-compose up -d

:: 2. Backend (On ajoute " - " pour aider la recherche)
start "BACK_TASK_LIST" cmd /k "title BACK_TASK_LIST && mvnw spring-boot:run"

:: 3. Frontend
start "FRONT_TASK_LIST" cmd /k "title FRONT_TASK_LIST && cd 1-3-tasks-fe && npm run dev"