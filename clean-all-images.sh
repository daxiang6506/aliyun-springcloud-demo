#!/bin/bash

# Docker image prefix
REGPREFIX=registry.aliyuncs.com/jingshanlb/

docker rmi ${REGPREFIX}discovery-server
docker rmi ${REGPREFIX}gateway
docker rmi ${REGPREFIX}foo
docker rmi ${REGPREFIX}bar
docker rmi ${REGPREFIX}foobar
docker rmi $(docker images -q)
