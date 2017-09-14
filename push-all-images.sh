#!/bin/bash

set -e

# Docker image prefix
REGPREFIX=registry.cn-hangzhou.aliyuncs.com/xuc/
docker login --username=daxiang6506@sina.com -p 2017XCxc registry.cn-hangzhou.aliyuncs.com
docker push ${REGPREFIX}discovery-server
docker push ${REGPREFIX}gateway
docker push ${REGPREFIX}foo
docker push ${REGPREFIX}bar
docker push ${REGPREFIX}foobar
# docker push $(docker images -q)