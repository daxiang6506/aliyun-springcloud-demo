#!/bin/bash

set -e

# Docker image prefix
REGPREFIX=registry.cn-hangzhou.aliyuncs.com/xuc/

docker push ${REGPREFIX}discovery-server
docker push ${REGPREFIX}gateway
docker push ${REGPREFIX}foo
docker push ${REGPREFIX}bar
docker push ${REGPREFIX}foobar
# docker push $(docker images -q)