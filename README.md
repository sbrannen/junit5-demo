## Demos for JUnit 5

This is a sample application that demonstrates the core features of JUnit 5, especially the JUnit Jupiter programming model.

In addition, demos are provided for using the _Spring TestContext Framework_ from the Spring Framework as well as testing support in Spring Boot.

The following highlight the technologies used.

* JUnit Platform 1.0.1
* JUnit Jupiter 5.0.1
* JUnit Vintage 4.12.1
  * Including JUnit 4.12 (for comparison with JUnit Jupiter)
* Spring Framework 5.0 GA
* Spring Boot 2.0 M4
* Gradle

## Note

Some of the tests intentionally fail in order to demonstrate support for `assertAll()` (i.e., _grouped assertions_) in JUnit Jupiter vs. the lacking support for grouped assertions in JUnit 4.
