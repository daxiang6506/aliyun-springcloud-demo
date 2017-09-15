#!/bin/bash

function progress() {
    local GREEN CLEAN
    GREEN='\033[0;32m'
    CLEAN='\033[0m'
    printf "\n${GREEN}$@  ${CLEAN}\n" >&2
}

set -e

# Docker image prefix
REGPREFIX=registry.cn-hangzhou.aliyuncs.com/xuc/

progress "Building discovery-server(1/5) jar file ..>"
cd common/discovery-server
./gradlew build
progress "Building discovery-server(1/5) docker image ..."
docker tag $(docker build -t ${REGPREFIX}discovery-server -q .) ${REGPREFIX}discovery-server:$(date -u "+%Y%m%d-%H%M%S")
cd -

progress "Building gateway(2/5) jar file ..."
cd common/gateway
./gradlew build
progress "Building gateway(2/5) docker image ... "
docker tag $(docker build -t ${REGPREFIX}gateway -q .) ${REGPREFIX}gateway:$(date -u "+%Y%m%d-%H%M%S")
cd -

progress "Building foo service(3/5) jar file ..."
cd services/foo
./gradlew build
progress "Building foo service(3/5) docker image ..."
docker tag $(docker build -t ${REGPREFIX}foo -q .) ${REGPREFIX}foo:$(date -u "+%Y%m%d-%H%M%S")
cd -

progress "Building bar service(4/5) jar file ..."
cd services/bar
./gradlew build
progress "Building bar service(4/5) docker image ..."
docker tag $(docker build -t ${REGPREFIX}bar -q .) ${REGPREFIX}bar:$(date -u "+%Y%m%d-%H%M%S")
cd -

progress "Building foobar service(5/5) jar file ..."
cd services/foobar
./gradlew build
progress "Building foobar service(5/5) docker image ..."
docker tag $(docker build -t ${REGPREFIX}foobar -q .) ${REGPREFIX}foobar:$(date -u "+%Y%m%d-%H%M%S")
cd -
