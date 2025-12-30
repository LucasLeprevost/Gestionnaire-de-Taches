#!/bin/bash

# 1. Lance la base de données
docker-compose up -d

# 2. Lance le Backend
echo "Lancement du Backend..."
./mvnw spring-boot:run > backend.log 2>&1 &
echo $! > .backend.pid

# 3. Lance le Frontend
echo "Lancement du Frontend..."
cd 1-3-tasks-fe
npm run dev > ../frontend.log 2>&1 &
echo $! > ../.frontend.pid

echo "------------------------------------------"
echo "Tout est lancé !"
echo "Backend PID: $(cat ../.backend.pid)"
echo "Frontend PID: $(cat ../.frontend.pid)"
echo "------------------------------------------"