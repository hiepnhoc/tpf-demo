FROM openjdk:8

ENV GROUP_DOCKER dkit
ENV GROUP_DOCKER_ID 1200
ENV USER_OAUTH2 dk-oauth2
ENV ID_OAUTH2 1202
# Add user
RUN groupadd -g $GROUP_DOCKER_ID $GROUP_DOCKER
RUN useradd -u $ID_OAUTH2 -ms /bin/bash -g $GROUP_DOCKER $USER_OAUTH2

#Change user
USER $USER_OAUTH2

