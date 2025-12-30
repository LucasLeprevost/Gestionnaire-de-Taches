#!/bin/bash

echo "[1/3] Arret des processus Java et Node..."

# On tue les processus via les fichiers PID créés au start
if [ -f .backend.pid ]; then
    kill -9 $(cat .backend.pid) 2>/dev/null
    rm .backend.pid
fi

if [ -f .frontend.pid ]; then
    kill -9 $(cat .frontend.pid) 2>/dev/null
    rm .frontend.pid
fi

# Nettoyage de sécurité au cas où
pkill -f "spring-boot:run"
pkill -f "vite"

echo "[2/3] Arret de Docker..."
docker-compose stop

echo "[3/3] Nettoyage des logs..."
rm -f backend.log frontend.log

echo "------------------------------------------"
echo "TOUT EST ARRETE ET FERME"
echo "------------------------------------------"