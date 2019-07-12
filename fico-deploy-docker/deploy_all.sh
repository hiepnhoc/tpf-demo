#!/bin/bash

PATH_SOURCE=/home/it/fico-deploy-docker

PATH_HAPROXY="/home/it/DATA/haproxy"
PATH_RABBITMQ=/home/it/DATA/rabbitmq
PATH_OAUTH2=/home/it/DATA/oauth2
PATH_POSTGRES=/home/it/DATA/postgres
PATH_CONSUMER=/home/it/DATA/consumer

##########START########

echo + Tao thu muc volume cho rabbitmq
mkdir -p $PATH_RABBITMQ/{log,config,data}
echo [rabbitmq_federation_management,rabbitmq_mqtt,rabbitmq_web_mqtt,rabbitmq_auth_backend_http]. > $PATH_RABBITMQ/config/enabled_plugins

echo + Tao thu muc volume cho haproxy
mkdir -p $PATH_HAPROXY/config/
mkdir -p $PATH_HAPROXY/run

echo + Tao thu muc volume cho oauth2
mkdir -p $PATH_OAUTH2

echo + Tao thu muc volume cho postgres
mkdir -p $PATH_POSTGRES/{data,docker-entrypoint-initdb.d}

echo + Tao thu muc volume cho consumer
mkdir -p $PATH_CONSUMER

echo + Copy config cho rabbitmq, haproxy, oauth2
/bin/cp -rf $PATH_SOURCE/rabbitmq/rabbitmq.conf $PATH_RABBITMQ/config/
/bin/cp -rf $PATH_SOURCE/haproxy/haproxy.cfg $PATH_HAPROXY/config/
/bin/cp -rf $PATH_SOURCE/oauth2/oauth2-server.jar $PATH_OAUTH2/
/bin/cp -rf $PATH_SOURCE/consumer/* $PATH_CONSUMER
/bin/cp -rf $PATH_SOURCE/postgres/*.sql $PATH_POSTGRES/docker-entrypoint-initdb.d

echo + Chown quyen
chmod -R 777 $PATH_HAPROXY $PATH_RABBITMQ $PATH_OAUTH2 $PATH_POSTGRES $PATH_CONSUMER
chmod 400 $PATH_RABBITMQ/data/.erlang.cookie

echo + Thuc thi docker composer
cd $PATH_SOURCE
docker-compose up &

echo "=> DONE"

