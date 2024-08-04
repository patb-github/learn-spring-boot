# Learn Spring Boot

After finishing my bootcamp where I learned the MERN stack, I wanted to try my hands on a different framework. Since I already knew some Java, I landed on the Spring framework, one of the most widely-used Java web-development frameworks. I completed the *Learn Spring* course on Codecademy, but I wanted a more hands-on experience, as well as running it locally on my computer. For this respoitory, I followed along [Spring Boot Complete Tutorial for Beginners [Latest] [2024]](https://www.youtube.com/watch?v=fm4RtXFiP7Y) tutorial by Genuine Coder on YouTube.

## Things I Learned

### 1. Inversion of Control (IoC)
The Spring framework employs the IoC design principle. In a traditional system, components are *tightly-coupled*, 

### 2. Convention Over Configuration
The Spring Boot framework makes it easy to start a project by configuring reasonable defaults, reducing the number of decisions the developer needs to make.

### 3. Embedded Server
The Spring Boot framework comes with an embedded server.


### 5. Installing MySQL and Using Environment Variables
For this tutorial, we used MySQL to start a local database server. I followed [this](https://www.youtube.com/watch?v=u96rVINbAUI) tutorial for installing MySQL Server and Workbench. Next, to connect Spring to the database, we need to provide the url, username and password. The tutorial did not show how to use a `.env` file, so I did some searching. To keep credentials private, we can add a `.env` file in the root directory; then, to access the values of a variable `VAR`, use `${VAR}`. It took a bit of time to set up, but I think it was worthwhile, as I could use what I learned for a future project. 

### 6. Profiles
In /src/main/resources/ we can add more *profiles*. These are configurations that are applied on top of the the base `application.properties`. To create new profile, simply create a file `application-name.properties`, where `name` is the name of the profile. To use a profile, add the line `spring.profiles.active=name` in the `application.properties` file, where `name` is the name of the profile.

We can also create controllers for specific profiles by adding an `@Profile("name")` annotation to the controller class, where `name` is the name of the profile. If two endpoints from two differet controllers are the same, we have to make sure that both of the controllers have a profile; i.e., we cannot add `@Profile("name")` to one and leave the other as a default.

## Problems & Solutions

The main problem I faced wฟห with the setup in VS Code. I had already created a Maven project before, but this tutorial used Gradle. I had a problem where the project would not build because it could not find the Java 21 JVM, and it did not show up in the "Java Projects" section, so clicking "Configure Java Runtime" did not allow me to edit the path to the Java JDK. 

In the end, what worked was going into settings (`Ctrl+,`) and configuring `java.import.gradle.java.home` to the path to the Java 21 JDK. Then, I cleared the Gradle build cache and ran the build again. This is more of a workaround though, as `./gradlew --version` still showed the JVM version as 11. 