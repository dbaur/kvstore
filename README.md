[![Build Status](https://travis-ci.org/dbaur/kvstore.svg?branch=master)](https://travis-ci.org/dbaur/kvstore)

# kvstore

## Description

A plain simple key value store for test purposes. Once started, the API description will be available at http://localhost:8080/application.wadl.
The key value store is written in Java, and uses a HashMap as in-memory store.

## Installation
A docker container is available at https://hub.docker.com/repository/docker/dbaur/kvstore. The server by exposes port 8080 by default. To run type: docker run -p 8080:8080 dbaur/kvstore.
