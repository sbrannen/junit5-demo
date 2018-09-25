## Demos for JUnit 5

This is a sample application that demonstrates the core features of JUnit 5, especially the JUnit Jupiter programming model.

In addition, demos are provided for using the _Spring TestContext Framework_ from the Spring Framework as well as testing support in Spring Boot.

The following highlight the technologies used.

* JUnit Platform 1.3.1
* JUnit Jupiter 5.3.1
* JUnit Vintage 5.3.1
  * which includes JUnit 4.12 (for comparison with JUnit Jupiter)
* Spring Framework 5.1
* Spring Boot 2.1 M4
* Gradle 4.10.2

## Note

Two of the tests intentionally fail in order to demonstrate support for `assertAll()` (i.e., _grouped assertions_) in JUnit Jupiter vs. the lacking support for grouped assertions in JUnit 4.
