# Cloudbees Jenkins Analytics (CJA)

CloudBees Jenkins Analytics (CJA) provides metrics on the usage of agents and masters in a CJOC- managed Jenkins cluster.

Analytics are presented in 2 pre-built-views:

* `Build Analytics:` reported from client masters. Provides data on how many jobs builds/masters, success/fail rates, and which jobs are running on which agents.
* `Performance Analytics:` reported from client masters. Provides data on how long jobs sit in the queue, how many executors are available/in-use, how big the JVM is, and how much garbage collection is occuring.

## Benefits

CloudBees Jenkins Analytics provides answers to questions about performance problems, how masters/agents are being used, and job failure rates. CJA can quantify whether your installation has sufficient build resources, memory, and is performing proper garbage collection. Dashboards can be saved and exported for analysis.

## Get started

### Configure Analytics and reporting

The CloudBees Jenkins Analytics (CJA) is based upon 2 main tools:

* Elasticsearch, a search Engine that is used to store metrics
* Kibana, a web-based dashboard system, that is used to manage Analytics dashboards and store them inside ElasticSearch.

While Kibana is served by CJOC itself, ElasticSearch need to be configured.

!!! note

    Running a single node ElasticSearch service, which is not recommended for production. As a native distributed system, ElasticSearch should run on your own cluster, with dedicated storage, and at least 3 nodes ("Split-Brain" problem).

Next Starting from CJOC dashboard, navigate to Manage Jenkins -> Configure Analytics to start setting up analytics in Jenkins.

In Analytics configuration section:

* Elasticsearch Configuration: Remote Elasticsearch Instance(s)
* Elasticsearch URLs: http://elasticsearch:9200/
* Set Path to Backup Elasticsearch Snapshots to /cjoc
* In Client Master Analytics Reporting, disable the option Allow per-master overrides to avoid master leaving metric reporting
* Leave all other settings to their defaults value

### Discover the "default" dashboards

Once the Analytics has been configured, 3 new elements will appears on the CJOC dashboard:

* The left-hand menu to access the Dashboard creator
* The Build analytics default view
* The Performance analytics default view