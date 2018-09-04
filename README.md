## Demos for JUnit 5

This is a sample application that demonstrates the core features of JUnit 5, especially the JUnit Jupiter programming model.

In addition, demos are provided for using the _Spring TestContext Framework_ from the Spring Framework as well as testing support in Spring Boot.

The following highlight the technologies used.

* JUnit Platform 1.3.0 M1
* JUnit Jupiter 5.3.0 M1
* JUnit Vintage 5.3.0 M1
  * which includes JUnit 4.12 (for comparison with JUnit Jupiter)
* Spring Framework 5.0.7
* Spring Boot 2.0.3
* Gradle 4.10

## Note

Some of the tests intentionally fail in order to demonstrate support for `assertAll()` (i.e., _grouped assertions_) in JUnit Jupiter vs. the lacking support for grouped assertions in JUnit 4.
