# Management tools

## CloudWatch

Is a monitoring service.

## CloudFormation

It is a way of scripting infrastructure.

AWS CloudFormation provides a common language for you to describe and provision all the infrastructure resources in your cloud environment. CloudFormation allows you to use a simple text file to model and provision, in an automated and secure manner

With a cloudformation template you can deploy your applications with ease.

The scripts are reusable.

## CloudTrail

Logs changes to your AWS environment.

It is turned on by default and it keeps a trail of the changes for a week.

If turned on it makes it easy to determine if your environment is hacked.

## Config

Monitors the configuration of your AWS environment.

Maintains a snapshot thus making it possible to move back and forward across weeks.

Visualise your AWS environments.

## OpsWorks

Similar to elastic beanstack.

Uses chef and puppet to automate the environment.

## Service catalog

A way for managing a catalog of service allowed to use on the AWS environment.

You can decide on which Virtual server images, Operating systems. databases etc can be used on the AWS environment.

Basically used by big organizations for governance and compliance requirements

## Systems Manager

Interface for maintaining your AWS resources.

Typically used for EC2.

For patch maintenance eg: security patches across thousands of EC2 instances.

Can group all the resources by different departments or applications for planning the patch updates.

## Trusted Advisor

Would give you advice on multiple deciplines like security, would advice if you have left any ports open that could be a security risk. It can tell you how you can save money on AWS. Can be thought of as an Advisor or an accountant that you trust and that gives you the best advice for your AWS environment.

## Managed services

Amazon provides managed services for AWS, i.e., if you do not want to worry about your EC2 instances or the auto scale feature you can opt for the managed services.