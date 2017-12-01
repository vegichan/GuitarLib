# A library for various guitar apps #

[![Build Status](https://travis-ci.org/vegichan/GuitarLib.svg?branch=master)](https://travis-ci.org/vegichan/GuitarLib)

A command-line interface for learning music concepts on the guitar. 
Perfect for times when you have your PC, but your guitar is not available.

This project serves as a library to be later used for a similar Android app.

Requires knowledge of Maven, to use effectively.

### Dependencies
- Maven
- Java 1.8
- JUnit

### Building from source
    $ git clone https://github.com/vegichan/GuitarLib.git
    $ cd GuitarLib
    $ mvn compile
    $ mvn exec:java -Dexec.mainClass="com.martinkysel.guitarlib.tester.TestRunner"

### Testing
Each commit is verified by Travis

    $ mvn test


### License

[GuitarLib License](https://github.com/vegichan/GuitarLib/blob/master/LICENSE)
