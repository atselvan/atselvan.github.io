# [Docker Networks](https://docs.docker.com/engine/userguide/networking/)

This section provides an overview of Docker’s default networking behavior, including the type of networks created by default and how to create your own user-defined networks. It also describes the resources required to create networks on a single host or across a cluster of hosts.

## [Default Networks](https://docs.docker.com/engine/userguide/networking/#default-networks)

When you install Docker, it creates three networks automatically. You can list these networks using the docker network ls command:

```sh
$ docker network ls

NETWORK ID          NAME                DRIVER
7fca4eb8c647        bridge              bridge
9f904ee27bf5        none                null
cf03ee007fb4        host                host
```

[...more information](https://docs.docker.com/engine/userguide/networking/#default-networks)

## User-defined networks

It is recommended to use user-defined bridge networks to control which containers can communicate with each other, and also to enable automatic DNS resolution of container names to IP addresses.

[...more information](https://docs.docker.com/engine/userguide/networking/#user-defined-networks)

### [Bridge networks](https://docs.docker.com/engine/userguide/networking/#bridge-networks)

A bridge network is the most common type of network used in Docker. Bridge networks are similar to the default bridge network, but add some new features and remove some old abilities. The following examples create some bridge networks and perform some experiments on containers on these networks.

```sh
docker network create --driver bridge isolated_nw
docker network inspect isolated_nw
```

After you create the network, you can launch containers on it using the docker run `--network=<NETWORK>` option.