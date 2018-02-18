# Storage

## S3 [Simple storage service]

Amazon S3 provides access to reliable, fast, and inexpensive data storage infrastructure.

One of the oldest storage service on AWS.

S3 Basics

S3 is a safe place to store your files.
It is a object based storage i.e. it allows you to upload files. Example: text files, videos, images, word files etc.
The data is spread across multiple devices and facilities.
Files can be from 0 Bytes to 5 TB.
There is unlimited storage.
Files are stores in buckets.
S3 is a universal namespace, that is, names must be globally unique.
When you upload a file to S3 you will receive a HTTP 200 code if the upload was successful.
Built for 99.99% availability.
Supports versioning.
Supports encryption.
Data can be secured using Access Control Lists and Bucket Policies.

Data consistency Model

Read after Write consistency for PUTS of new Objects. You will be able to read the data as soon as you upload it.

Eventual Consistency for overwrite PUTS and DELETES (can take some time to propagate). Thus if you try to read updated data you either get the new data or the old data but the data is never currupted or incosistent.

S3 is a simple key, value store

S3 is Object based and Objects consists of the following:
    Key : The name of the object
    Value : The data which is made up of a sequence of bytes.
    Version ID : for versioning
    Metadata : Data about the data you are storing
    Subresources
        Access Control list : Who can access this object. Allows you to do fine grain permission.
        Torrent : Support for bit torrect protocol

Storage Tiers/Classes

S3

99.99% availability, 99.(11 x 9's)% durability, stored redundantly across multiple devices in multiple facilities and is designed to sustain the loss of 2 facilities concurrently.

S3 - IA (Infrequently Accessed)

For data that is accessed less frequently, but requires rapid access when needed. Lower fee than the S3, but you are charged a retrieval fee (Per GB retrieved).

Reduced Redency Storage

Designed to provide 99.99% availability and 99.99% durability of objects over a given year. Thus durability less that the S3 but cost much lower than the S3.
Images and thumbnail example. 
To keep files that can be regenerated.

Glacier

Glacier is an extremely low-cost storage service and only costs $0.01 per gigabyte per month, abd is optimised for data that is infrequently accessed and for which retrieval times of 3 - 5 hours are suitable.

## EFS [Elastic file system]

Amazon EFS provides scalable file storage for use with Amazon EC2. You can create an EFS file system and configure your instances to mount the file system. You can use an EFS file system as a common data source for workloads and applications running on multiple instances.

Basically Network Attached storage. Can mount them to multiple virtual machines.

## Glacier

For data archieving.

## Snowball

Move GB's of data to the Amazon data center without using broadband line or wifi. Write it phisically to a disk which is then moved to the data center of AWS.

## Storage gateway

AWS Storage Gateway is a hybrid storage service that enables your on-premises applications to seamlessly use AWS cloud storage. You can use the service for backup and archiving, disaster recovery, cloud bursting, storage tiering, and migration. Your applications connect to the service through a gateway appliance using standard storage protocols, such as NFS and iSCSI.