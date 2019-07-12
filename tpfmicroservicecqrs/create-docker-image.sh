#!/usr/bin/env bash
eval "$(docker-machine env default)"

cd tpf-microservice-config
./mvnw clean package docker:build -Dmaven.test.skip=true

cd ../tpf-microservice-discovery
./mvnw clean package docker:build -Dmaven.test.skip=true

cd ../tpf-microservice-gateway
./mvnw clean package docker:build -Dmaven.test.skip=true

cd ../tpf-microservice-common
./mvnw clean package docker:build -Dmaven.test.skip=true

cd ../tpf-microservice-myservice
./mvnw clean package docker:build -Dmaven.test.skip=true

docker rmi $(docker images -f "dangling=true" -q)