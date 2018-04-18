# Compute

## EC2 : Elastic Compute Cloud

Virtual servers inside the AWS platform

Amazon Elastic Compute Cloud (Amazon EC2) provides scalable computing capacity in the Amazon Web Services (AWS) cloud. Using Amazon EC2 eliminates your need to invest in hardware up front, so you can develop and deploy applications faster. You can use Amazon EC2 to launch as many or as few virtual servers as you need, configure security and networking, and manage storage. Amazon EC2 enables you to scale up or down to handle changes in requirements or spikes in popularity, reducing your need to forecast traffic.

### Features of Amazon EC2

Amazon EC2 provides the following features:

Virtual computing environments, known as instances

* Preconfigured templates for your instances, known as Amazon Machine Images (AMIs), that package the bits you need for your server (including the operating system and additional software)
* Various configurations of CPU, memory, storage, and networking capacity for your instances, known as instance types
* Secure login information for your instances using key pairs (AWS stores the public key, and you store the private key in a secure place)
* Storage volumes for temporary data that's deleted when you stop or terminate your instance, known as instance store volumes
* Persistent storage volumes for your data using Amazon Elastic Block Store, known as Amazon EBS volumes
* Multiple physical locations for your resources, such as instances and Amazon EBS volumes, known as regions and Availability Zones
* A firewall that enables you to specify the protocols, ports, and source IP ranges that can reach your instances using security groups
* Static IPv4 addresses for dynamic cloud computing, known as Elastic IP addresses
* Metadata, known as tags, that you can create and assign to your Amazon EC2 resources
* Virtual networks you can create that are logically isolated from the rest of the AWS cloud, and that you can optionally connect to your own network, known as virtual private clouds (VPCs)

### Amazon EC2 options

#### On Demand

* Allows you to pay a fixed rate by the hour (or by the second) with no commitment
* Users that want the low cost and flexibility of Amazon EC2 without any upfront payment or long-term commitment
* For applications with short term, spiky, or unpredictable workloads that cannot be interrupted and for applications being developed or tested

#### Reserved

* Provides you with a capacity reservation and offers a significant discount on the hourly charge for an instance. 1 year or 3 year terms
* For applications with a steady state or predictable usage
* Users able to make upfront payments to reduce their total Computing costs even further

Types of Reserved instances:

* Standard reserved instances (Upto 75% off on demands)
* Convertible reserved instances (Upto 54% off on demand) capability to change the attributes of the RI's as long as the exchange results in the creation of RI's of equal or greater value
* Scheduled reserved instances available to launch within the time windows you reserve. This option allows you to match your capacity reservation to a predictable recurring schedule that only requires a fraction of a day, a week or a month.

#### Spot

* Enables you to bid whatever price you want for instance capacity, providing for even greater savings if your applications have flixible start and end times
* For applications that are only feasible at very low compute prices

#### Dedicated Hosts

* Physical servers dedicated for your use. Dedicated Hosts can help you reduce costs by allowing you to use your existing server-bound software licenses
* Useful for regulatory requirements that may not support multi-tenant virtualization
* Great for licensing which does not support multi-tenancy or cloud deployments
* Can be purchased On-Demand (hourly)
* Can be purchased as a reservation for upto 70% off on the On-Demand price

### EC2 instance types

D2 Density  
R4 RAM  
M4 Main choice for general purpose apps  
C4 Compute  
G2 Graphics  
I2 IOPS  
F1 FPGA  
T2 Low cost general purpose apps  
P2 Graphics  
X1 Extreme memory  

!!! note

    * one subnet = one availability zone (while creation of EC2 instance)
    * EC2 instances and the EBS volumes should be in the same availability zone
    * To move EC2 instances from one region/availability zone to another create a image of the instance, move the image to the region and spin up a new instance using that image

### Security Groups

* A security group is a virtual firewall which controlls trafic to your EC2 instances
* 1 instance can have multiple security groups
* It is the first line of defense against hackers
* All inbound traffic is blocked by default
* Any changes to the security group is applied immediately
* As soon as you add an inbound rule allowing traffic in, that traffic is automatically allowed back out(Security Groups are STATEFUL)
* You can specify allow rules but not deny rules

!!! info
    You cannot block specific IP addresses using Security Groups, instead you need to use Network Access Control Lists

### EBS : Elastic Block Storage

Amazon EBS allows you to create storage volumes and attach them to your EC2 instances. Once attached you can create a file system on top of these volumes, run a database, or use them in any other way you would use a block device. Amazon EBS volumes are placed in a specific Availability Zone, where they are automatically replicated to protect you from the failure of a single component.

!!! info
    You cannot mount 1 EBS volume to multiple EC2 instances, instead use EFS

    To move an EBS volume from one availability zone to another, create a snapshot or image of the volume and then you will be able to create a volume from the snapshot or image into another availability zone

    You can change EBS volume sizes on the fly, including changing the size and storage type

#### EBS Volume Types

##### General Purpose SSD (GP2)

* General purpose, balances both price and performance
* Used most often
* Ratio of 3 IOPS per GB with up to 10000 IOPS and the ability to burst up to 3000 IOPS for extended periods of time for volumes at 3334 GB and above

##### Provisioned IOPS SSD (IO1)

* Designed for I/O intensive applications such as large relational or NoSQL databases
* Use if you need more than 10000 IOPS
* Can provision upto 20000 IOPS per volume

##### Throughput Optimized HDD (ST1)

* Typically used for Big data, data warehouses or log processing
* Large amounts of sequencial data
* Optimized throughput
* Cannot be boot volumes

##### Cold HDD (SC1)

* Lowest cost storage for infrequently accessed workloads
* File server
* Cannot be boot volumes

##### Magnetic Standard

* Lowest cost per GB of all the EBS volume types that is bootable
* Magnetic volumes are ideal for workloads where data is accessed infrequently and applications where the lowest storage cost is important

!!! info "IOPS"
    Input/output operations per second (IOPS) is an input/output performance measurement used to characterize computer storage devices like hard disk drives (HDD), solid state drives (SSD), and storage area networks (SAN). Like benchmarks, IOPS numbers published by storage device manufacturers do not directly relate to real-world application performance.

!!! info "Throughput"
    The most common value from a disk manufacturer is how much throughput a certain disk can deliver. This number is usually expressed in Megabytes / Second (MB/s) and it is easy to belive that this would be the most important factor to look at. The maximum throughput for a disk could be for example 140 MB/s

### Snapshots

* Volumes exist in EBS and Snapshots are saved on S3 but you will not be able to see the bucket it is saved in
* Snapshots are point in time copies of Volumes
* Snapshots are incremental - this means that only the blocks that have changed since your last snapshot are moved to S3
* It may take some time to create the first snapshot
* To create a snapshot for Amazon EBS volumes that serve as root devices, you should stop the instance before taking the snapshot
* However you can take a snap while the instance is running
* You can create AMI's from both Volumes and Snapshots
* Snapshots of encrypted volumes are encrypted automatically
* Volumes restored from encrypted snapshots are encrypted automatically
* You can share snapshots, but only if they are unencrypted. These shapshots can be shared with other AWS accounts or made public. This is because the encryption keys are tried to your own AWS account

### RAID : Redundant Array of Independant Disks

If you do not create the required I/O from individual disks you can create a RAID

* RAID 0 - Striped, No redundancy, Good performance
* RAID 1 - Mirrored, Redundancy
* RAID 5 - Good for reads, bad for writes, AWS does not recommend ever putting RAID 5's on EBS
* RAID 10 - Striped and Mirrored, Good redundancy and good performance

!!! faq "How can I take a Snapshot of a RAID Array?"

    * Stop the application from writing to the disk
    * Flush all caches to the disk

    * How can we do this?
        * Freeze the file system
        * Unmount the RAID Array
        * Shut down the associated EC2 instance

### Instance Store Volumes

* Instance store volumes are sometimes called Ephemeral Storage

#### EBS vs Instance Store

* All AMIs are categorized as either backed by Amazon EBS or backed by instance store
* For EBS volumes : The root device for an instance launched from the AMI is an Amazon EBS volume created from an Amazon EBS snapshot
* For Instance Store Volumes : The root device for an instance launched from the AMI is an instance store volume created from a template stored in Amazon S3
* Instance store volumes cannot be stopped. If the underlying host fails, you will loose your data
* EBS backed instances can be stopped. You will not loose the data on this instance if it is stopped
* You can reboot both, you will not loose your data
* By default both root volumes will be deleted on termination of the instance, however with EBS volumes, you can tell AWS to keep the root device volume.

### ELB : Elastic LoadBalancer

Elastic Load Balancing automatically distributes incoming application traffic across multiple targets, such as Amazon EC2 instances, containers, and IP addresses. It can handle the varying load of your application traffic in a single Availability Zone or across multiple Availability Zones.

#### Elastic Loadbalacer types

##### Application Load Balancer

Application Load Balancer is best suited for load balancing of HTTP and HTTPS traffic and provides advanced request routing targeted at the delivery of modern application architectures, including microservices and containers. Operating at the individual request level (Layer 7), Application Load Balancer routes traffic to targets within Amazon Virtual Private Cloud (Amazon VPC) based on the content of the request.

##### Network Load Balancer

Network Load Balancer is best suited for load balancing of TCP traffic where extreme performance is required. Operating at the connection level (Layer 4), Network Load Balancer routes traffic to targets within Amazon Virtual Private Cloud (Amazon VPC) and is capable of handling millions of requests per second while maintaining ultra-low latencies. Network Load Balancer is also optimized to handle sudden and volatile traffic patterns.

##### Classic Load Balancer

Classic Load Balancer provides basic load balancing across multiple Amazon EC2 instances and operates at both the request level and connection level. Classic Load Balancer is intended for applications that were built within the EC2-Classic network.

!!! info

    * Instances monitored by ELB are reported as InService or OutOfService
    * Health Checks check the instance health bu talking to it
    * An ELB does not have a IP addres, they only have a DNS name

### Metadata

```bash
curl http://169.254.169.254/latest/meta-data/

Output:

ami-id
ami-launch-index
ami-manifest-path
block-device-mapping/
hostname
instance-action
instance-id
instance-type
local-hostname
local-ipv4
mac
metrics/
network/
placement/
profile
public-hostname
public-ipv4
public-keys/
reservation-id
security-groups
```

!!! example "Metadata examples"

    ```bash
    curl http://169.254.169.254/latest/meta-data/instance-id  
    Output : i-06d52c4eb25a5ea90
    ```

    ```bash
    curl http://169.254.169.254/latest/meta-data/hostname  
    Output : ip-172-31-17-126.eu-west-1.compute.internal
    ```

    ```bash
    curl http://169.254.169.254/latest/meta-data/security-groups  
    Output : ps-basic-http
    ```

## ECS : Elastic Container Services

Run and manage docker containers

Amazon Elastic Container Service (Amazon ECS) is a highly scalable, fast, container management service that makes it easy to run, stop, and manage Docker containers on a cluster.

You can host your cluster on a serverless infrastructure that is managed by Amazon ECS by launching your services or tasks using the Fargate launch type.

## EC2 Auto Scaling

Scale compute capacity to meet demands

AWS Auto Scaling monitors your applications and automatically adjusts capacity to maintain steady, predictable performance at the lowest possible cost.

Using AWS Auto Scaling, you can setup scaling for multiple resources across multiple services in minutes. AWS Auto Scaling provides a simple, powerful user interface that lets you build scaling plans for Amazon EC2 instances

## Elastic Beanstalk

Amazon Web Services (AWS) comprises dozens of services, each of which exposes an area of functionality. While the variety of services offers flexibility for how you want to manage your AWS infrastructure, it can be challenging to figure out which services to use and how to provision them.

With Elastic Beanstalk, you can quickly deploy and manage applications in the AWS Cloud without worrying about the infrastructure that runs those applications. AWS Elastic Beanstalk reduces management complexity without restricting choice or control. You simply upload your application, and Elastic Beanstalk automatically handles the details of capacity provisioning, load balancing, scaling, and application health monitoring.

For people who do not want to understand how AWS works and only care about the functioning of their application.

## Lambda

Run you code in response to events.

## Lightsail

Launch and manage virtual private servers (VPS).

For people who dont want to understand AWS and the underlying infrastructure. They dont want to know about VPC's and security groups.

This service will just provision you with a server, A fixed IP addrres for login and you can start working on it.

Comes with a management console for managing the server.

## Batch

Run batch jobs at any scale.
Batch computing on the cloud.