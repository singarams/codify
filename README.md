Build Running in [travis-ci](https://travis-ci.com/singarams/codify)

[![Build Status](https://travis-ci.com/singarams/codify.svg?branch=master)](https://travis-ci.com/singarams/codify)

Code Coverage is running in [JaCoCo](https://coveralls.io/github/singarams/codify?branch=master)

[![Coverage Status](https://coveralls.io/repos/github/singarams/codify/badge.svg?branch=master)](https://coveralls.io/github/singarams/codify?branch=master)

# Coding Task

This repository contains the solution to Sort and order the data received as a json in the API. This also handles any errors and malformed data received

## Getting started

Checkout the Git Repository on `master`. This program has been built following the [Trunk-Based Development](https://trunkbaseddevelopment.com). As such the latest production copy will always be on `master`.

### Sample Request
API input
```$xslt
[
  {
    "name": "Melbourne Show",
    "cars": [
      {
        "make": "Nissan",
        "model": "X-trail"
      }
    ]
  },
  {
    "name": "India Show",
    "cars": [
      {
        "make": "BMW",
        "model": "X6"
      }
    ]
  }
]
```

### Sample Output
Sample output printed in console and written to txt file

##### Assumptions:
 if any of `Name` or `make` or `model` is empty or not present then those objects will `NOT` be considered for sorting
  
```$xslt
George Motors
    George 15
        New York Car Show
Hondaka
    Elisa
        New York Car Show
```

### Prerequisites

There needs to be a `JDK 1.8` or higher version install to build and run this program locally. This program is build in Java using `JDK 11`.
_Note: No 11 specific features have been used_

The program uses `Apache Maven 3.6` to build. Please ensure you have a Maven installation of `3.6 +` on your local environment.

What things you need to install the software and how to install them

### Installing

The program is packaged as an executable `JAR` file.

Code needs to be compiled and the `JAR` file created by running the maven install command at the project root.

```
mvn clean install
```

The program produces a JAR file in the `target` directory and the local `maven repo`.

### Running

The JAR file is executable and the program can be run by executing it. Use the command:

```$xslt
java -jar codify-1.0-SNAPSHOT-jar-with-dependencies.jar <API URL>
```

### Running the tests

Tests with coverage reports can be obtained by running the below command on the project root

```
mvn clean test jacoco:report
```

Reports are produced using `JoCoCo` and are available under `/target/site`


### Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JaCoCo](https://www.jacoco.org) - Code Coverage
* [TravisCI](https://travis-ci.org/) - Builds

### Contributing

This project is not open to active contribution as it is part of a coding exercise