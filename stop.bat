@echo off
title Arret du Gestionnaire de Taches

echo [1/3] Nettoyage des moteurs Java et Node
taskkill /f /im java.exe /t >nul 2>&1
taskkill /f /im node.exe /t >nul 2>&1

echo [2/3] Fermeture des fenetres de developpement...
taskkill /fi "windowtitle eq BACK_TASK_LIST*" /f /t >nul 2>&1
taskkill /fi "windowtitle eq FRONT_TASK_LIST*" /f /t >nul 2>&1


echo [3/3] Arret de la base de donnees Docker...
docker-compose stop

echo.
echo ======================================================
echo TOUT EST FERME
echo ======================================================