# Docker Compose

## Overview

Compose is a tool for defining and running multi-container Docker applications. With Compose, you use a Compose file to configure your application’s services. Then, using a single command, you create and start all the services from your configuration.

Using Compose is basically a three-step process:

* Define your app’s environment with a Dockerfile so it can be reproduced anywhere.
* Define the services that make up your app in docker-compose.yml so they can be run together in an isolated environment.
* Lastly, run docker-compose up and Compose will start and run your entire app.

A docker-compose.yml looks like [this](../compose/ci.ats.in/docker-compose.yaml)