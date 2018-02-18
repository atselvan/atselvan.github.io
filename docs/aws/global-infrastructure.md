# AWS Global Infrastructure

## Understanding the difference between a region, an Availabity Zone (AZ) and an Edge Location

### Region

* A region is a physical location in the world which consists of two or more Availability Zones.
* A AWS region consists of an independent collection of AWS computing resources in a defined geography.

### Availability Zones

* An Availability Zone is one or more discrete data centers, each with redundant power, networking and connectivity, housed in separate facilities.
* Avalability zones are distinct locations from within a AWS region that are engineered to be isolated from failures.

### Edge Locations

* Edge locations are endpoints for AWS which are used for cacheing content. Typically it consists of CloudFront which is Amazon's Content Delivery Network (CDN)