## Demos for JUnit 5

This is a sample application that demonstrates the core features of JUnit 5, especially the JUnit Jupiter programming model.

In addition, demos are provided for using the _Spring TestContext Framework_ from the Spring Framework as well as testing support in Spring Boot.

The following highlight the technologies used.

* JUnit Platform 1.3.2
* JUnit Jupiter 5.3.2
* JUnit Vintage 5.3.2
  * which includes JUnit 4.12 (for comparison with JUnit Jupiter)
* Spring Framework 5.1.3
* Spring Boot 2.1
* Gradle 5.0
* Java 11

## Note

Two of the tests intentionally fail in order to demonstrate support for `assertAll()` (i.e., _grouped assertions_) in JUnit Jupiter vs. the lacking support for grouped assertions in JUnit 4.
