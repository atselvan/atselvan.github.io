# AWS Services

## Compute

### EC2 : ELastic Compute Cloud

Virtual servers inside the AWS platform

### ECS : Elastic Container Services

Run and manage docker containers

### EC2 Auto Scaling

Scale compute capacity to meet demands.

### Elastic Beanstalk

Run and manage webapps.
For people who do not want to unstand how AWS works and who only care about their application.

### Lambda

Run you code in response to events.

### Lightsail

Launch and manage virtual private servers (VPS).
For people who dont really want to understand AWS and the underlying infrastructure. They dont want to know about VPC's and security groups.
This service will just provision you with a server, A fixed IP addrres for loging.
Comes with a management console for managing the server.

### Batch

Run batch jobs at any scale
Batch computing on the cloud.

## Storage

### S3 [Simple storage service]

One of the oldest storage service.
Object based storage. There are buckets and data is uploaded to the buckets.

### EFS [Elastic file system]

Basically Network Attached storage. Can mount them to multiple virtual machines.

### Glacier

For data Archieving.

### Snowball

Move GB's of data to the Amazon data center without using broadband line or wifi. Write it phisically to a disk.

### Storage gateway

Are basicall virtual applicances that will replicate data back to S3.
There are 4 diff types.

## Database

### RDS [Relation database service]

This will be things like Mysql, postgres, Oracle etc.

### Dynamo DB

Non relational db (will be covered later)

### Elasticache

For caching commonly executed queries.
Will freeup the db service you a

### Redshift

For data warehousing and business intelligence.
For making very complex queries.

## Migration

### AWS migration hub

Allows you to track you applications as you move your application to AWS and integrated with other services of the migration framework.
For visualizing the progress of your migration

### Application discovery  service

Detects the applications you have along with their depencies. For example if you have a sonarqube server it may have a dependency on a sql server or a domain controller.
Thus its a way of tracking dependencies for your application.

### Database Migration service

Very easy way to migrate on premise databases to AWS

### Server migration service

helps you to migrate your virtual and physical server to the AWS cloud

### Snowball

Helps you to migrate large chunks of data into the cloud.

## Networking and content delivery

### VPC

Amazon Virtual private cloud. Can be considered as a virtual datacenter.
Configure firewall, availability zones, network sider address ranges,  Network ACL's, route tables etc.
It is pretty complicated to understand. (V IMP)
Fundamental and inportant part.

### CloudFront

Amazons content delivery network service.

### Route 53

Amazons DNS service.

### API Gateway

For creating a serverless website using polly.
A way of creating your own API for other services to talk to

Direct connect

Is a way of running a dedicated line from your Corporate head office or data center to AWS.

## Developer tools

### CodeStar

Project managing your code. For colaborating with other developers.

### CodeCommit

A place to store your code

### CodeBuild

Compiles the code and run tests against it to producte software packages.

### CodeDeploy

Automates code deployment to your EC2 and on premise servers.

### CodePipeline

Continuous delivery server to visualize and automate the steps required to release your software.

### X-Ray

To debug and analyse serverless applications.

### Cloud9

This is a IDE environment. A place where you can develop your code withing your web browser in AWS.

## Management tools

### CloudWatch

Is a monitoring service.

### CloudFormation

It is a way of scripting infrastructure.
With a cloudformation template to deploy your applications.
Reusable.

### CloudTrail

Log changes to your AWS environment.
Its turned on by default and it keeps the chages trail for a week.
If turned on it makes it easy to determine if your environment is hacked.

### Config

Monitors the configuration of your AWS environment.
Maintains a snapshot thus making it possible to move back and forward across weeks. 
Visualise your AWS environments.

### OpsWorks

Similar to elastic beanstack.
User chef and puppet to automate the environment.

### Service catalog

A way for managing a catalog of service allowed to use on the AWS environment.
Virtual server images, Operating systems. databases etc
Basically used by big organizations for governance and compliance requirements

### Systems Manager

Interface for maintaining your AWS resources.
Typically used for EC2.
For patch maintenance eg: security patches across thousands of EC2 instances.
Can group all the resources by different departments or applications.

### Trusted Advisor

Would give you advice on multiple deciplines like security, would advice if you have left any ports open that could be a risk. It can tell you how you can save money on AWS.
Can be thought of as an Advisor or an accountant that you trust and that gives you the best advice on your AWS envieonment.

### Managed services

Amazon provides managed services for AWS, i.e., if you do not want to worry about your EC2 instances or the auto scale feature you can opt for the managed services.

## Machine Learnig

### Polly

turns text into speech
Can choose different languages

### Lex

Alexa service

### Rekognition

Can upload a picture and it will let you whats there in the picture.

### Translate

Translate languages
similar to google translate

### Transcribe

Automatic speech recognition
Turns speech into text

## Analytics

### Athena

Looks through the S3 bucket data and returns results.

### EMR [Elastic Map Reduce]

for processing large amounts of data for big data solutions.

### CloudSearch and Elastic Search Service

Search services for AWS

### Kinesis

Way of ingesting large amount of data into AWS. Social media feeds etc.

### QuickSight

Amazons business intelligence tool.

### Data pipeline

Moving data between diff AWS services.

### Glue

Used for ETL [Extract transform and load]

## Security, Identity and Compliance

### IAM [Identity and Access management]

### Cognito

Is a way of doing device authentication.
Authenticate using FB gmail etc.
Use Cognito as a authentication service to get temp access to AWS resources.

### GuardDuty

It monitors for malicious activities on your AWS environment.

### Inspector

Installed on Virtual machines and EC2 instances to run a whole bunch of tests agains it to check for security vulnerabilities.
Can be scheduled to run weekly, monthly..
Generates a report and gives you a severity report of the vulnerabilities.

### MAcie

will scan your s3 bucked to look for things that contain a personally identifiable information PII like names, adresses, passport numbers etc and alert you.

### Certificate Manager

Get ssl certificates for free if your using AWS services and registering the domains through route 53.
Managing SSL certificates.

### CloudHSM

HSM [Hardware Security Modules]
Dedicated bits of hardware used to store your keys eg: private and public keys.
The keys may be used to access your EC2 instances. Can used these keys to encrypy AWS objects.

### Directory Service

A way of integration AD with AWS services.

### WAF : Web Application Firewall

Prevents cross site scripting, SQL injections etc. Prevents malicious users.

### Shield

Shield is basically DDOS mitigation.

### Artifact

For Audit and compliance. Way of downloading and inspecting Amazons documentation.

## Mobile services

### Mobile hub

management console for mobile applications.

### Pinpoint

New service
Use targetted push notification

### AppSync

Updates web and mobile data. Updates data when the phone comes back online.

### Device Farm

Test mobile application on real android and ios devices

### Mobile Analytics

Analytics for your mobile application

## Application Integration

### Step functions

Managing your lamda function and manage the steps to go through it.

### Amazon MQ

For message queues. similar to Rabbit MQ.

### SNS

A notification service. Will be setting a billing alarm.

### SQS

One of the oldest services.
A way of decoupling your infrastructure.

### SWF :Simple Workflow Service

## Customer engagement

### Connect

A contact center as a service. Similar to having a call center on the cloud.

### Simple email service

A great way of sending large amount of emails.

## Business Productivity

### Alexa for Business

Use it to dial into a meeting room

### Chime

Like google hangout. Record meetings.

### Work Docs

Like a dropbox in AWS

### WorkMail

Like office 365

## Desktop and App Streaming

### Workspaces

Is a VDI solution. Accessing a desktop on the cloud on your device.

### AppStream 2.0

Way of live streaming the application. Like Citrix.

## IOT Internet Of Things

### iOT

### iOT Device Management

### FreeRTOS

### Greengrass

## Game Development

### GameLift

Service to help you develop a game.