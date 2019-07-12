FROM haproxy:latest

ENV GROUP_DOCKER dkit
ENV GROUP_DOCKER_ID 1200
ENV USER_HAPROXY dk-haproxy
ENV ID_HAPROXY 1200
# Add user
RUN groupadd -g $GROUP_DOCKER_ID $GROUP_DOCKER 
RUN useradd -u $ID_HAPROXY -ms /bin/bash -g $GROUP_DOCKER $USER_HAPROXY
RUN chmod -R 777 /var/run

#Change user
USER $USER_HAPROXY
