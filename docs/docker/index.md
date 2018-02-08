# Docker

## Overview

Docker is the world’s leading software container platform. Developers use Docker to eliminate “works on my machine” problems when collaborating on code with co-workers. Operators use Docker to run and manage apps side-by-side in isolated containers to get better compute density. Enterprises use Docker to build agile software delivery pipelines to ship new features faster, more securely and with confidence for both Linux and Windows Server apps.

[...more information][docker]

## What is a Container?

Using containers, everything required to make a piece of software run is packaged into isolated containers. Unlike VMs, containers do not bundle a full operating system - only libraries and settings required to make the software work are needed. This makes for efficient, lightweight, self-contained systems and guarantees that software will always run the same, regardless of where it’s deployed.

[...more information][container]

## Virtual Machine v/s Containers

![vm-vs-container](./images/vm-vs-container.png)

* [What makes docker different that VMs?](http://stackoverflow.com/questions/16047306/how-is-docker-different-from-a-normal-virtual-machine)

## Get Started with Docker

Please follow the [getting started guide][getstarted].

## Mandatory Reading

* [Dockerfile reference](https://docs.docker.com/engine/reference/builder/)
* [Dockerfile best practices](https://docs.docker.com/engine/userguide/eng-image/dockerfile_best-practices/)
* [Dockerfile linting](https://github.com/lukasmartinelli/hadolint)

## Further Reading

* [Twelve Factor Container](https://www.infoq.com/presentations/container-12-factor)
* [Docker metrics Prometheus](https://medium.com/lucjuggery/docker-daemon-metrics-in-prometheus-7c359c7ff550)
* [Docker Datacenter (Docker EE)](https://medium.com/lucjuggery/discovering-docker-datacenter-cf0daccddc41)
* [Docker Swarm Tutorials](http://blog.alexellis.io/top-5-docker-swarm/?mkt_tok=eyJpIjoiTXpoalpEZG1OVEEzWVRRdyIsInQiOiJcLzJXckplZHNiVTRiK04yODNcL1wvN1lrN1M0VHNjNlB2VzJDT0xxa04wVURFSkREdWNGTkxybWNNSU5nYlk0SGFcL3VYNzVQVFhMTDVZRU9RVTBEY0t6V2NrcXBtK1wvNzZqUU9MSVpjWWJ5bXhWZjZKM3ptMENPQ0UxVXMybkVKcVhzIn0%3D)
* [Viktor Farcic's Presentations and Workshops](http://vfarcic.github.io/#/presentations-1)

[docker]: https://www.docker.com/what-docker
[container]: https://www.docker.com/what-container
[getstarted]: https://docs.docker.com/get-started