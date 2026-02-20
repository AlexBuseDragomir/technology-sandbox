CORE JAVA

1. What is the difference between String, StringBuilder, and StringBuffer?

Answer: String is immutable; once created, its value cannot be changed, and any modification creates a new object in the String Pool. StringBuilder and StringBuffer are mutable. StringBuffer is synchronized and thread-safe, making it slower. StringBuilder is not synchronized, making it faster and the preferred choice for single-threaded string manipulation.

2. Explain the difference between == and the equals() method.

Answer: The == operator compares object references (memory addresses) to check if two variables point to the exact same object in memory. The equals() method is intended to compare the actual content or state of the objects for logical equality. If a class does not override equals(), it defaults to the == behavior from the Object class.

3. What is the difference between Checked and Unchecked Exceptions?

Answer: Checked exceptions (e.g., IOException, SQLException) are checked at compile-time; the compiler forces you to either handle them with a try-catch block or declare them in the method signature using throws. Unchecked exceptions (e.g., NullPointerException, IllegalArgumentException) extend RuntimeException, represent programming logic errors, and are not checked by the compiler.

4. How do ArrayList and LinkedList differ in Java?

Answer: ArrayList is backed by a dynamic array. It offers fast $O(1)$ read access but slower insertions and deletions in the middle of the list because elements must be shifted. LinkedList is backed by a doubly-linked list. It offers faster insertions and deletions (once the node is found) but slower $O(n)$ read access because it must traverse the list from the beginning or end to find an element.

5. What is the difference between an Interface and an Abstract Class?

Answer: A class can implement multiple interfaces but can only extend one abstract class. Abstract classes can hold instance state (non-final variables) and constructors, whereas interfaces cannot. Prior to Java 8, interfaces could only have abstract methods, but they can now include default and static methods with implementations.

6. Explain method overloading versus method overriding.

Answer: Method overloading (compile-time polymorphism) occurs when a class has multiple methods with the same name but different parameter lists. Method overriding (runtime polymorphism) occurs when a subclass provides a specific implementation for a method that is already defined with the exact same signature in its parent class.

7. How does a HashSet ensure that elements are unique?

Answer: HashSet uses a HashMap internally. When you add an element to a HashSet, the element is inserted as the key into the backing HashMap, and a dummy, constant object is used as the value. Because HashMap keys must be unique (determined by their hashCode() and equals() methods), the HashSet automatically guarantees uniqueness.

8. Define the final, finally, and finalize keywords.

Answer: 
final: An access modifier used to declare constants (variables), prevent method overriding, and prevent class inheritance.
finally: A block used with try-catch to execute crucial cleanup code (like closing files), regardless of whether an exception was thrown.
finalize: A deprecated method in the Object class called by the Garbage Collector before an object is destroyed (rarely used in modern Java).

9. Why should you use a logging framework (like SLF4J with Logback or Log4j2) instead of System.out.println(), and what are the standard logging levels?

Answer: System.out.println() writes strictly to the console, is synchronous (which can block application threads and degrade performance), and cannot be easily toggled off in a production environment. A logging framework separates the logging facade from the implementation, allowing you to route logs to different destinations (files, consoles, external servers), format the output automatically, and use logging levels to filter verbosity based on your deployment environment. The standard levels, from most to least detailed, are: TRACE, DEBUG, INFO, WARN, and ERROR.

10. What is try-with-resources and what requirement must a resource meet to be used with it?

Answer: Introduced in Java 7, try-with-resources is an exception-handling mechanism that automatically closes resources (like database connections or file streams) at the end of the statement, eliminating the need for a finally block. To be used in this construct, the resource class must implement the AutoCloseable or Closeable interface.


TESTING

1. Does 100% code coverage mean your application is bug-free?

Answer: No. Code coverage only measures the percentage of lines, branches, or instructions that were executed during the automated tests. It does not verify that the business logic is correct, nor does it guarantee that all possible edge cases, null inputs, or complex integration failures have been accounted for.

2. What are the limitations of standard mocking frameworks in Java (like Mockito), and how do you test around them?

Answer: Historically, standard mocking frameworks could not mock static methods, private methods, or final classes/methods. While newer versions of Mockito (using mockito-inline) and frameworks like PowerMock can bypass these restrictions, the best practice is usually to refactor the code. Heavy reliance on static or private method mocking often indicates tight coupling and a poor design that lacks proper dependency injection.

3. How do you mock or test a method that returns void using Mockito?

Answer: Standard when().thenReturn() doesn't work on void methods because they don't return a value. Instead, you use the do... family of methods. For example, to simulate an exception being thrown by a void method, you use doThrow(Exception.class).when(mockObject).voidMethod(). To verify it was called, you just use verify(mockObject).voidMethod().

4. What is an ArgumentCaptor in Mockito and when is it useful?

Answer: An ArgumentCaptor allows you to intercept and capture the exact arguments passed to a mocked method during the test's execution. This is highly useful when the method you are testing creates a complex object internally and passes it to a mocked dependency. The captor lets you grab that object and run assertions on its specific properties.

5. What is the fundamental difference between a @Mock and a @Spy in Mockito?

Answer: 
@Mock (Complete Fake): Creates a completely hollow object from a class or interface. By default, calling any method on a mock does nothing and returns default values (null, 0, false). You must explicitly stub methods to give them behavior.

@Spy (Partial Mock): Wraps an actual, real instance of an object. By default, calling a method on a spy executes the real underlying code and returns real results. You only stub the specific methods you want to intercept and override, leaving the rest of the object's real behavior intact.


OOP

1. How do you achieve encapsulation in Java?

Answer: By declaring class variables as private and providing public getter and setter methods. This hides the internal state of the object and protects it from unauthorized modification.

2. When should you choose composition over inheritance?

Answer: Use composition ("has-a") rather than inheritance ("is-a") for greater flexibility and looser coupling. It allows you to reuse code and change behaviors at runtime without being forced into a rigid class hierarchy.

3. How can you prevent a method from being overridden by a subclass?

Answer: By using the final keyword in the method's declaration. Additionally, making an entire class final prevents it from being inherited at all.

4. What is the difference between the package-private (default) and protected access modifiers in Java?

Answer: package-private (when no modifier is specified) restricts access strictly to classes within the same package. protected allows access to classes within the same package, plus any subclasses that reside in different packages.

5. Can you override a static method in Java?

Answer: No. If a subclass defines a static method with the exact same signature as a static method in the superclass, it is called "Method Hiding," not overriding. The method that gets executed is resolved at compile-time based on the reference type of the variable, not at runtime based on the actual object instance.


REST

1. What is idempotency in REST, and which HTTP methods are idempotent?

Answer: Idempotency means that making multiple identical requests has the exact same effect on the server's state as making a single request. GET, PUT, DELETE, HEAD, and OPTIONS are idempotent. POST and PATCH are not idempotent, as executing it multiple times typically creates multiple distinct resources.

2. What is the precise difference between the PUT and PATCH methods?

Answer: PUT is used for complete substitution; it replaces the entire target resource with the provided payload. If fields are omitted in a PUT request, they should be set to null or removed. PATCH is used for partial modifications; it updates only the specific fields included in the payload, leaving the rest of the resource untouched.

3. What is the difference between the 200, 201, and 204 HTTP status codes?

Answer: 200 OK means the request succeeded and the response contains the requested data. 201 Created indicates a request (typically POST) successfully resulted in the creation of a new resource. 204 No Content means the request succeeded (often used for DELETE or PUT), but there is no content to return in the response body.

4. What is the exact difference between 401 Unauthorized and 403 Forbidden?

Answer: 401 Unauthorized means the client has not authenticated; the server does not know who the user is. 403 Forbidden means the client is authenticated and their identity is known, but they lack the necessary permissions (authorization) to access the requested resource.

5. What is a "safe" HTTP method?

Answer: A safe HTTP method is one that is strictly read-only and does not alter the state of the resource on the server. GET, HEAD, and OPTIONS are safe methods. Note that while all safe methods are idempotent, not all idempotent methods are safe (e.g., DELETE is idempotent but not safe).

6. What is CORS, and why does a REST API need to handle it?

Answer: CORS (Cross-Origin Resource Sharing) is a security mechanism enforced by web browsers. If your REST API is hosted on a different domain, protocol, or port than the frontend web application consuming it, the API must be configured to return specific CORS HTTP headers (like Access-Control-Allow-Origin) to permit the browser to process the response.

7. What is the best practice for handling large collections of resources in a REST API?

Answer: You should implement pagination, filtering, and sorting using query parameters rather than modifying the base URI path. For example, GET /api/users?status=active&sort=createdAt,desc&page=2&size=50. Returning massive datasets in a single response degrades database performance, consumes too much memory, and increases network latency.


MICROSERVICES

1. What are the primary trade-offs when migrating from a monolithic architecture to microservices?

Answer: While microservices offer independent scalability, technological flexibility, and autonomous deployments, they introduce significant operational complexity. You trade fast in-memory method calls for network calls, which increases latency and the risk of partial failures. It also makes data consistency, debugging, and end-to-end testing much harder compared to a monolith.

2. How should microservices communicate with each other, and when would you choose synchronous over asynchronous communication?

Answer: Microservices can communicate synchronously (e.g., REST, gRPC) or asynchronously (e.g., message queues like RabbitMQ or event streams like Kafka). You should use synchronous communication only when the client absolutely requires an immediate response to proceed. Asynchronous communication is preferred for background processing, decoupling services, and improving system resilience, as the sender doesn't block waiting for the receiver.

3. What is the role of an API Gateway in a microservices architecture?

Answer: An API Gateway acts as the single entry point for all client requests. Instead of clients calling dozens of individual microservices directly, the gateway routes the requests to the appropriate backend services. It also centralizes cross-cutting concerns like authentication, SSL termination, rate limiting, load balancing, and response aggregation.

4. How do you troubleshoot a failure or performance bottleneck that spans across multiple microservices?

Answer: You must use distributed tracing. When an initial request enters the system, it is assigned a unique correlation ID. This ID is passed along in the headers of every subsequent inter-service call or event message. Logs from all individual services are then aggregated in a centralized tool (like the ELK stack, Zipkin, or Jaeger), allowing you to filter by the correlation ID and reconstruct the entire lifecycle of the request.

5. What is the Circuit Breaker pattern, and why is it essential in microservices?

Answer: It prevents cascading failures when a downstream service is unresponsive. If failure rates exceed a threshold, the circuit "opens," immediately failing subsequent requests or returning a fallback response instead of tying up threads waiting for timeouts. After a cooldown period, it enters a "half-open" state to test if the service has recovered.

6. How do microservices dynamically find each other without hardcoding IP addresses?

Answer: Through Service Discovery. Microservice instances register their dynamically assigned IP addresses and ports with a central Service Registry (like Netflix Eureka or Consul) when they start. When Service A needs to communicate with Service B, it queries the registry to find the available routing information.


MULTITHREADING

1. What is the difference between Runnable and Callable?

Answer: Both represent tasks designed to be executed by another thread. Runnable does not return a result and cannot throw checked exceptions. Callable returns a result (wrapped in a Future object) and is allowed to throw checked exceptions.

2. Why should you use an ExecutorService instead of manually creating new threads?

Answer: Creating and destroying threads is a resource-intensive operation. An ExecutorService (thread pool) manages and reuses a pool of worker threads. This reduces CPU overhead, prevents application crashes from creating too many concurrent threads, and simplifies task lifecycle management.

3. What is a deadlock, and how can you prevent it?

Answer: A deadlock happens when two or more threads are blocked indefinitely, each waiting for a lock that the other thread holds. The most reliable way to prevent deadlocks is to ensure that all threads always acquire multiple locks in the exact same, globally agreed-upon order.

4. What is the difference between the wait() and sleep() methods?

Answer: wait() is an Object method used for inter-thread communication; calling it forces the thread to release the lock on that object until another thread calls notify(). sleep() is a static Thread method that pauses execution for a set duration, but the thread absolutely keeps holding any locks it has acquired.

5. What is the purpose of the java.util.concurrent.atomic package (e.g., AtomicInteger)?

Answer: These classes provide thread-safe, lock-free programming for single variables. Instead of using slow synchronized blocks to safely increment a counter across multiple threads, atomic classes use hardware-level Compare-And-Swap (CAS) instructions to perform the update safely and much faster.

6. What are the different states in the lifecycle of a Java Thread?

Answer: A thread can be in one of six distinct states: New (created but not yet started), Runnable (executing or ready to execute in the JVM), Blocked (waiting to acquire a monitor lock), Waiting (waiting indefinitely for another thread to perform an action), Timed Waiting (waiting for a specified maximum time), and Terminated (has completed its execution).

7. What is the difference between a synchronized method and a synchronized block?

Answer: A synchronized method automatically locks the entire object instance (using this) for the full duration of the method. A synchronized block allows you to lock only a specific, critical section of the code and even specify a different lock object. Using a block is generally better practice because it holds the lock for the shortest possible time, reducing thread contention.


SPRING CORE

1. What is Inversion of Control (IoC), and how does Dependency Injection (DI) relate to it?

Answer: IoC is a design principle where the control of object creation and lifecycle management is transferred from your application code to a framework (the Spring Container). DI is the specific design pattern used to implement IoC; the container "injects" the required dependencies into an object at runtime, rather than the object creating them itself using the new keyword.

2. What are the differences between Constructor Injection and Setter Injection, and when should you use each?

Answer: Constructor injection provides dependencies through the class constructor. It is the recommended best practice because it makes the bean immutable and ensures all mandatory dependencies are present before the object is fully instantiated. Setter injection uses setter methods, which allows the object to be instantiated first and dependencies to be injected later, making it suitable for optional dependencies.

3. Why is Field Injection (using @Autowired directly on private fields) generally discouraged?

Answer: Field injection hides dependencies, making the code harder to read and virtually impossible to instantiate outside of the Spring container (such as in isolated unit tests) without using reflection tools. It also masks bad design by making it too easy to violate the Single Responsibility Principle by silently injecting dozens of dependencies into a single class.

4. How does @Autowired resolve dependencies, and what happens if multiple beans of the same type exist?

Answer: @Autowired resolves dependencies primarily by type. If Spring finds multiple beans of the same type (e.g., two classes implementing the same interface), it will throw a NoUniqueBeanDefinitionException because it doesn't know which one to pick. You resolve this by using the @Qualifier("beanName") annotation alongside @Autowired to specify exactly which bean to inject, or by marking one implementation with @Primary.

5. What are the core Bean Scopes available in Spring, and which one is the default?

Answer: The default scope is Singleton (one shared instance per Spring container). The other core scope is Prototype (a brand new instance is created every time the bean is requested). Web-aware Spring applications also feature Request, Session, and Application scopes, which tie the bean's lifecycle to HTTP requests or user sessions.

6. How does Spring know which classes to manage as beans during startup when using Autowiring?

Answer: Spring uses Component Scanning. When you configure your application (e.g., using @SpringBootApplication or @ComponentScan), Spring automatically scans the specified base packages for classes annotated with stereotype annotations like @Component, @Service, @Repository, or @Controller. It then automatically registers them as bean definitions in the IoC container.

7. What is the difference between @Component, @Service, @Repository, and @Controller?

Answer: All four are Spring stereotype annotations that register a class as a Spring bean. @Component is the generic base annotation. @Service is a specialization indicating the class holds business logic. @Repository is for the data access layer and provides automatic translation of underlying database exceptions into Spring's unified DataAccessException. @Controller is specifically for the presentation layer, allowing the class to handle web requests in Spring MVC.

8. How can you execute custom logic immediately after a Spring bean is initialized and its dependencies are injected?

Answer: You can annotate a void, no-argument method within the bean with @PostConstruct. The Spring container guarantees this method will be called exactly once, immediately after the bean is instantiated and all @Autowired dependencies have been successfully injected. For teardown logic before the bean is destroyed, you use the @PreDestroy annotation.


SPRING MVC

1. What is the difference between the @Controller and @RestController annotations?

Answer: @Controller is used for traditional server-side rendered web applications; its methods typically return a String representing the name of a view template (like Thymeleaf or JSP). @RestController is a convenience annotation that combines @Controller and @ResponseBody. It bypasses the view resolution process entirely, automatically serializing the returned object (usually into JSON) and writing it directly to the HTTP response body.

2. How do you extract values from the URI path versus the query string?

Answer: You use @PathVariable to extract dynamic variables directly embedded within the URI path itself (e.g., extracting "123" from /users/{id}). 
You use @RequestParam to extract key-value pairs passed in the URL's query string (e.g., extracting "123" from /users?id=123).

3. What is the purpose of the @RequestBody annotation?

Answer: @RequestBody is used in a controller method parameter to tell Spring to deserialize the incoming HTTP request body (usually a JSON payload) directly into a Java object. Spring uses built-in message converters (like Jackson) to map the JSON fields to the corresponding properties of your Java class.

4. What is the purpose of @ControllerAdvice and @ExceptionHandler?

Answer: @ControllerAdvice is a global interceptor that allows you to handle exceptions across the entire application in one central place. By defining @ExceptionHandler methods within this class, you can catch specific exceptions (like UserNotFoundException) thrown by any controller and return a standardized HTTP response (such as a 404 status with a custom JSON error object).

5. What is the purpose of the Model interface in a Spring MVC controller?

Answer: It acts as a container for application data. When handling a request, a controller can add attributes (key-value pairs) to the Model object. Spring then automatically passes this model to the View layer (like Thymeleaf or JSP) so the dynamic data can be extracted and rendered into the final HTML response.

6. What is the difference between @RequestMapping and @GetMapping?

Answer: @RequestMapping is a general-purpose annotation that can map any type of HTTP request (GET, POST, PUT, DELETE) to a controller method by explicitly defining the method attribute (e.g., @RequestMapping(value = "/users", method = RequestMethod.GET)). @GetMapping is a convenient shorthand annotation specifically for mapping HTTP GET requests (e.g., @GetMapping("/users")), which makes your controller code cleaner and easier to read.

7. What is ResponseEntity and why would you return it instead of a regular object in a @RestController?

Answer: ResponseEntity represents the entire HTTP response, including the body, headers, and status code. While returning a plain object automatically yields a 200 OK status, returning a ResponseEntity allows you to dynamically set the appropriate HTTP status code (like 201 Created or 404 Not Found) and inject custom headers based on the outcome of your business logic.


Spring AOP

1. What is Aspect-Oriented Programming (AOP) in Spring?

Answer: AOP is a programming paradigm that helps decouple cross-cutting concerns from your core business logic. It allows you to define common behaviors in a single place (an Aspect) and apply them declaratively across your application.

2. Give examples of common cross-cutting concerns that AOP is used for.

Answer: Typical examples include logging, transaction management (@Transactional), security and authorization, caching, and performance monitoring.

3. What is the difference between a JoinPoint and a Pointcut?

Answer: A JoinPoint is any specific point during the execution of a program (like a method being called) where an aspect could be applied. A Pointcut is an expression (often using regex) that specifies exactly which JoinPoints the aspect should actually target.

4. What is "Advice" in Spring AOP, and what are the common types?

Answer: Advice is the actual code or action that gets executed by an aspect at a selected JoinPoint. The standard types of advice are @Before, @After, @AfterReturning, @AfterThrowing, and @Around.

5. How does the @Around advice work?

Answer: @Around is the most powerful advice type. It wraps entirely around a method execution, allowing you to write logic that runs both before and after the method. It also gives you control over when (or even if) the original method is actually invoked by calling ProceedingJoinPoint.proceed().

6. What are the main annotations used in Spring AOP, and what do they do?

Answer: Spring AOP primarily uses AspectJ annotations to define and apply cross-cutting concerns. The core annotations include:

@Aspect: Declares a standard Java class as an aspect.
@Pointcut: Defines an expression to match specific join points (methods), determining where the advice applies.

Advice Annotations (determine when the logic runs):

@Before: Executes just before the targeted method.
@After: Executes after the method finishes, regardless of the outcome (success or exception).
@AfterReturning: Executes only if the method completes successfully.
@AfterThrowing: Executes only if the method throws an exception.
@Around: Wraps the method execution. It is the most powerful advice, allowing you to run custom logic before and after the invocation, alter return values, or bypass the method entirely using ProceedingJoinPoint.proceed()


CI/CD

1. What is a CI/CD pipeline in the context of Java development?

Answer: A CI/CD (Continuous Integration and Continuous Deployment) pipeline is an automated set of steps that software goes through to make it to production. For a Java developer, it typically automates compiling the code, running unit tests, packaging the application (e.g., into a JAR file), and deploying it to a server.

2. What role do tools like Maven or Gradle play within a pipeline?

Answer: Maven and Gradle are the build automation tools executed by the pipeline runner (like Jenkins or GitHub Actions). The pipeline triggers these tools to resolve Java dependencies, compile the source code, run the test suites, and generate the final deployable artifact.

3. Why is automated testing a mandatory stage in a CI pipeline?

Answer: It acts as a quality gate. Whenever a developer pushes new Java code, the pipeline automatically runs tools like JUnit and Mockito. If any test fails, the pipeline immediately halts and marks the build as broken, ensuring that faulty code cannot be merged or deployed to production environments.

4. How does Docker fit into a modern Java deployment pipeline?

Answer: After the pipeline builds the Java artifact (JAR/WAR), the next step is often to copy that artifact into a Docker image along with a specific Java Runtime Environment (JRE). The pipeline then pushes this image to a registry. This guarantees the Java application will run identically across all environments, eliminating "it works on my machine" issues.

5. What is the purpose of integrating SonarQube (or similar static analysis tools) into a pipeline?

Answer: These tools automatically analyze the Java source code during the pipeline run to detect bugs, security vulnerabilities, and code smells. They can enforce quality gates, such as failing the pipeline if the unit test coverage drops below a certain percentage (e.g., 80%) or if a critical security flaw is detected.

6. What is the difference between Continuous Integration (CI), Continuous Delivery (CD), and Continuous Deployment?

Answer: CI is the practice of frequently merging code changes into a central repository, where automated builds and tests are run. Continuous Delivery ensures that the code is always in a "deployable" state, but the final release to production is a manual decision. Continuous Deployment takes it a step further by automatically deploying every change that passes the pipeline directly to production without human intervention.

7. What is an "Artifact Repository" (like Nexus or Artifactory), and why is it used in a pipeline?

Answer: An artifact repository is a dedicated server used to store and manage the compiled versions of your Java applications (JARs, WARs) and their dependencies. In a pipeline, instead of rebuilding the same code for every environment, you build it once in the CI stage, upload it to the repository, and then "pull" that exact same version for testing and production deployments. This ensures consistency across environments.

8. What is "Pipeline as Code," and what are its benefits?

Answer: Pipeline as Code means defining your CI/CD workflow in a configuration file (like a Jenkinsfile, .gitlab-ci.yml, or github-actions.yml) that lives inside your project’s version control alongside your Java code. This allows the pipeline to be versioned, easily audited, shared across teams, and automatically restored if the build server fails.


JAVA 7, 11, 17

1. What are the most significant features introduced in Java 8 compared to earlier versions?

Answer: Java 8 introduced a paradigm shift toward functional programming. The main features include:

Lambda Expressions: Anonymous functions that simplify code, especially when working with functional interfaces.

Stream API: Allows functional-style, declarative operations (like map, filter, and reduce) on collections of objects.

Optional Class: A container object used to represent the presence or absence of a value, helping to prevent NullPointerException.

Date and Time API (java.time): A new, thread-safe, and immutable API for handling dates and times.

Default Methods: The ability to add implemented methods to interfaces without breaking existing implementations.

2. What notable features were added in Java 11 for developers migrating from Java 8?

Answer: Java 11 (an LTS release) focused on standardization and operational improvements. Key additions include:

New HTTP Client API: A modern, standardized, and fully asynchronous HTTP client supporting HTTP/1.1, HTTP/2, and WebSockets.

Local-Variable Syntax for Lambda Parameters: Allows the use of var in lambda expressions, ensuring consistency with local variables while enabling the use of annotations on parameters.

New String Methods: Utility methods like isBlank(), lines(), strip(), and repeat().

Single-File Source-Code Programs: The ability to run a single Java source file directly using the java command without explicit compilation.

3. As an LTS release, what major language features does Java 17 bring to the table compared to Java 11?

Answer: Java 17 introduced several language enhancements focused on reducing boilerplate and improving design safety. The main features are:

Records: A concise way to declare immutable data carrier classes, automatically generating constructors, getters, equals(), hashCode(), and toString().

Text Blocks: Multi-line string literals (""") that eliminate the need for cumbersome escape sequences and string concatenation.

Pattern Matching for instanceof: Removes the need for explicit casting after an instanceof check by extracting the matched object into a new scoped variable.

Sealed Classes: Allows developers to explicitly declare which classes or interfaces are permitted to extend or implement a given class/interface, providing better control over inheritance hierarchies.

4. What is a Functional Interface in Java 8?

Answer: An interface with exactly one abstract method. It serves as the target type for lambda expressions. They are typically marked with the @FunctionalInterface annotation to enforce this rule at compile time (e.g., Runnable, Callable, Predicate).

5. What are Method References?

Answer: A compact, shorthand syntax (::) for a lambda expression that only calls an existing method.  They improve readability by letting you refer to a method by name directly, such as System.out::println instead of x -> System.out.println(x).

6. What is the difference between intermediate and terminal operations in the Java 8 Stream API?

Answer: Intermediate operations (like filter(), map(), or sorted()) transform a stream into another stream. They are lazy and do not execute until a terminal operation is invoked. Terminal operations (like collect(), forEach(), or reduce()) trigger the execution of the pipeline and produce a non-stream result or side-effect.

7. What is the role of the Collectors utility class when working with Streams?

Answer: The Collectors class provides implementations for various reduction operations used with the Stream.collect() terminal method. It allows developers to easily accumulate stream elements into collections (using toList(), toSet()), group elements by a specific property (groupingBy()), or perform statistical summaries (like counting or averaging).


SQL

1. What is the difference between the WHERE and HAVING clauses?

Answer: The WHERE clause filters individual rows before any grouping or aggregation takes place. The HAVING clause filters groups of rows after the GROUP BY clause and aggregate functions have been applied.

2. What is a database Index, and what are its pros and cons?

Answer: An index is a data structure (often a B-tree) that improves the speed of data retrieval operations on a table at the cost of additional storage space and slower write operations. It works like an index in a book. While it speeds up SELECT queries, it slows down INSERT, UPDATE, and DELETE operations because the index must be updated alongside the data.

3. Explain the concepts of Primary Key and Foreign Key.

Answer: A Primary Key is a column (or set of columns) that uniquely identifies each row in a table. It cannot contain NULL values. A Foreign Key is a column in one table that references the Primary Key in another table, establishing a relationship between the two and enforcing referential integrity.

4. What is a Database Transaction and what does ACID stand for?

Answer: A transaction is a single, logical unit of work that consists of one or more SQL statements. ACID stands for Atomicity (all or nothing), Consistency (data remains valid), Isolation (concurrent transactions don't interfere), and Durability (committed changes are permanent). This ensures data integrity even in the event of a system failure.

5. What are aggregate functions?

Answer: Aggregate functions perform a calculation on a set of values and return a single summarizing value. Common examples include COUNT(), SUM(), AVG(), MAX(), and MIN(). They are often used in conjunction with the GROUP BY clause.

6. When would you choose to use an INNER JOIN versus a LEFT JOIN in a real-world scenario?

Answer: You use an INNER JOIN when you strictly need records that have matching data in both tables. For example, retrieving a list of users who have successfully placed an order. You use a LEFT JOIN when you need all records from your primary (left) table, regardless of whether related data exists. For example, generating a report of all registered users alongside their order history, ensuring users with zero orders are still included in the report.

7. How does the GROUP BY clause work, and what is a common syntax error developers make when using it?

Answer: GROUP BY collapses rows that share the same values in specified columns into summary rows, typically used alongside aggregate functions like SUM() or COUNT(). The most common developer mistake is including a column in the SELECT statement that is neither included in the GROUP BY clause nor wrapped in an aggregate function, which results in a syntax error in most relational databases.

8. What is the "N+1 query problem," and how do you resolve it at the database query level?

Answer: The N+1 problem occurs when an application executes one query to retrieve a list of N parent records, and then subsequently executes N additional individual queries to fetch the related child records for each parent. At the SQL level, this is resolved by using a JOIN to fetch both the parent and related child data together in a single, comprehensive query.

9. What is the difference between the CHAR and VARCHAR data types?

Answer: CHAR stores fixed-length character strings and pads them with spaces if the input is shorter than the defined length. VARCHAR stores variable-length strings, using only the necessary storage space for the actual string plus a small overhead to record the length, making it more efficient for data that varies in size.

10. What is the purpose of the DISTINCT keyword?

Answer: The DISTINCT keyword is used immediately after SELECT to filter out duplicate rows from the result set. It ensures that the query returns only unique values, or unique combinations of values if multiple columns are specified.

11. How does the IN operator work in a WHERE clause?

Answer: The IN operator allows you to check if a column's value matches any value within a specified list or a subquery. It serves as a much cleaner, more readable shorthand for stringing together multiple OR conditions.

12. How do you use wildcards with the LIKE operator for pattern matching?

Answer: The LIKE operator is used in a WHERE clause to search for a specified pattern in a string column. It relies on two primary wildcards:

% (Percent sign): Represents zero, one, or multiple characters. For example, LIKE 'Java%' matches any string starting with "Java".
_ (Underscore): Represents exactly one single character. For example, LIKE 'J_va' matches "Java", "Jbva", or any other five-character string fitting that exact frame.


BUILD AUTOMATION TOOLS

1. What is a build automation tool, and why is it essential for Java projects?

Answer: A build automation tool is a software utility that automates the repetitive tasks required to convert raw Java source code into a runnable application. It is essential because it standardizes and speeds up processes like compiling code, downloading dependencies, running tests, and packaging the final artifact, minimizing human error.

2. What is "Dependency Management" in the context of a build tool?

Answer: Dependency management is the automated process of declaring, resolving, and downloading the external libraries (JAR files) that a project needs to compile and run. The build tool automatically fetches the specified versions from a central server, eliminating the need for developers to manually download and store them in the project repository.

3. What is a "transitive dependency"?

Answer: A transitive dependency is an indirect dependency. If your project depends on Library A, and Library A relies on Library B to function, Library B is considered a transitive dependency of your project.  The build tool automatically detects and downloads both to ensure the project compiles successfully.

4. What is the difference between a Local Repository and a Remote/Central Repository?

Answer: A Remote/Central Repository is a web-based server that hosts open-source Java libraries. A Local Repository is a hidden directory on the developer's own machine where the build tool caches the libraries downloaded from the remote repository, preventing the need to re-download the same files for future builds.

5. What is a "Build Lifecycle"?

Answer: A build lifecycle is a predefined sequence of phases or steps that the tool executes to build the project.  While the naming varies slightly by tool, a standard lifecycle generally includes cleaning the build directory, compiling the source code, executing unit tests, and packaging the compiled code into a distributable format.

6. In Java build tools, what is an "Artifact"?

Answer: An artifact is the final, tangible output produced by the build process. For Java applications, this is typically a compressed file containing the compiled .class files and resources, such as a JAR (Java ARchive), WAR (Web ARchive), or EAR (Enterprise ARchive) file.

7. What is the primary purpose of the build configuration file?

Answer: The build configuration file serves as the blueprint for the project. It tells the build tool exactly what it needs to know: the project's metadata (name, version), the list of external dependencies required, the plugins to use, and custom instructions on how to compile, test, and package the application.

8. What does it mean to perform a "Clean" build, and when is it necessary?

Answer: A clean build forces the build tool to delete the output directory containing previously compiled files and generated artifacts before starting a fresh build process. It is necessary when you want to ensure that no outdated, cached, or orphaned files are interfering with the new build, guaranteeing a clean output.

9. How do build tools assist with software testing?

Answer: Build tools integrate directly with testing frameworks (like JUnit or TestNG). During the build lifecycle, the tool automatically detects the test classes, compiles them, executes the tests, and generates a report indicating passes and failures. If a test fails, the tool usually halts the build process to prevent a broken artifact from being created.

10. Why are build tools critical for Continuous Integration (CI) pipelines?

Answer: CI servers (like Jenkins or GitLab CI) are simply orchestrators; they don't inherently know how to compile Java code. They rely entirely on the project's build tool to execute the build via a command-line instruction. The build tool ensures that the application is built and tested in the exact same standardized way on the CI server as it is on a developer's local machine.


Docker

1. What is Docker?

Answer: Docker is an open-source platform that automates the packaging, deployment, and management of applications within lightweight, isolated environments called containers.

2. How does a Docker Container differ from a Virtual Machine (VM)?

Answer: A VM includes a full guest operating system and requires a hardware hypervisor, making it heavy and slow to start. A Docker container is lightweight because it shares the host system's OS kernel and only packages the application and its specific dependencies.

3. What is the difference between a Docker Image and a Docker Container?

Answer: A Docker Image is a read-only, immutable template containing the application code, libraries, and environment settings. A Docker Container is the live, runnable instance of that image.

4. What is a Dockerfile?

Answer: A Dockerfile is a plain text document containing a sequential set of instructions (such as FROM, COPY, RUN, and CMD) that the Docker daemon executes to automatically build a new Docker image layer by layer.

5. What is Docker Hub?

Answer: Docker Hub is the default, cloud-based public registry provided by Docker. Developers use it to push, pull, store, and share Docker images with their team or the global community.

6. What is a Docker Volume used for?

Answer: A Docker Volume is used for data persistence. Because containers are ephemeral (any local data is lost when the container is deleted), volumes safely store database files or application data directly on the host machine, outside the container's temporary file system.

7. What is Docker Compose?

Answer: Docker Compose is a utility used to define and manage multi-container Docker applications. It allows developers to configure all required services, networks, and volumes in a single docker-compose.yml file, starting the entire environment with one command (docker-compose up).

8. What is the difference between the docker run and docker start commands?

Answer: The docker run command creates a brand new container from a specified image and executes it. The docker start command simply resumes a pre-existing container that is currently in a stopped state.

9. How do you expose a container's port to the host machine?

Answer: You use the -p (or --publish) flag with the docker run command to map a port from the host machine to a specific port inside the container. For example, docker run -p 8080:80 nginx forwards traffic from the host's port 8080 to the container's port 80.

10. What is the purpose of Docker networking?

Answer: Docker networking enables isolated containers to securely communicate with one another, the host machine, or external networks. The default "bridge" network allows containers running on the same host daemon to resolve and talk to each other using their container names.

11. How do you execute a command or open a shell inside a currently running container?

Answer: You use the docker exec command. To access an interactive terminal within the container, you use the -i (interactive) and -t (tty) flags alongside the shell path. For example: docker exec -it <container_name_or_id> /bin/bash (or /bin/sh for lightweight images like Alpine).

12. What is the difference between the CMD and ENTRYPOINT instructions?

Answer: Both define the default executable behavior of the container. CMD provides default commands and arguments that can be easily overwritten by appending a new command at the end of docker run. ENTRYPOINT sets a hardcoded executable that cannot be easily overridden; any arguments passed at the end of docker run are simply appended as arguments to the ENTRYPOINT process.

13. How do you list the containers currently running on your system?

Answer: You use the docker ps command. By default, it displays only the active, running containers along with their IDs, names, and mapped ports. To see all containers on your machine, including those that are stopped or exited, you append the -a flag (docker ps -a).

14. What command is used to download an image from a registry without starting a container?

Answer: You use the docker pull command followed by the image name and an optional tag (e.g., docker pull postgres:15). This simply fetches the read-only image layers from Docker Hub (or a private registry) and stores them on your local machine for future use.

15. What command is used to list all the Docker images stored on your local machine?

Answer: You use the docker images command (or docker image ls). This outputs a list of all locally available images, displaying their repository name, tag, image ID, creation time, and file size.


HIBERNATE & SPRING DATA JPA

1. What is JPA, and how does it relate to Hibernate?

Answer: JPA (Java Persistence API) is a standard specification for Object-Relational Mapping (ORM) in Java. Hibernate is a framework that implements this specification, providing the actual underlying functionality.

2. What is Spring Data JPA?

Answer: It is a framework built on top of JPA that significantly reduces boilerplate code. It allows developers to define repository interfaces, and Spring automatically generates the implementation and database queries at runtime.

3. What does the @Entity annotation do?

Answer: It marks a Java class as a JPA entity, meaning its state is managed by the persistence context and its instances will be mapped to rows in a specific database table.

4. What is the purpose of the @Id annotation?

Answer: It designates the field in an entity class that serves as the primary key, corresponding to the primary key column in the underlying database table.

5. What is the difference between @OneToMany and @ManyToOne?

Answer: @OneToMany maps one parent entity instance to multiple child instances. @ManyToOne maps multiple child instances to a single parent. They are frequently used together to define a bidirectional relationship.

6. What is the EntityManager in JPA?

Answer: It is the primary API interface used to interact with the persistence context. It handles the lifecycle of entities, managing operations like persist, merge, remove, and find.

7. How does Spring Data JPA's query derivation work?

Answer: Spring Data parses the names of repository methods (like findByLastNameAndAgeGreaterThan) and automatically constructs the corresponding SQL or JPQL queries without requiring manual implementation.

8. How do you define a custom query when method naming is not enough?

Answer: You use the @Query annotation above the repository method, passing in the custom JPQL (Java Persistence Query Language) or native SQL string to execute.

9. What is Lazy Loading?

Answer: A performance optimization where associated entities are not retrieved from the database immediately. Instead, a proxy is loaded, and the actual data is only fetched when the association is explicitly accessed in the code.

10. What is Eager Loading?

Answer: A fetch strategy where associated child entities are immediately retrieved from the database at the exact same time the parent entity is fetched.

11. What is the N+1 query problem?

Answer: A common performance bottleneck where the application executes 1 query to retrieve a list of N parent entities, and then subsequently executes N additional queries to fetch the related lazy-loaded child entities for each parent.

12. What is the First-Level Cache in Hibernate?

Answer: It is a mandatory, session-scoped cache associated with the current EntityManager. It ensures that if you query for the same entity multiple times within the same transaction, the database is only hit once.

13. What is the difference between save() and saveAndFlush() in Spring Data JPA?

Answer: save() attaches the entity to the persistence context, but the actual SQL INSERT or UPDATE may be delayed until the transaction commits. saveAndFlush() forces the immediate synchronization of the entity state to the database.

14. What is the role of the @Transactional annotation?

Answer: It defines the scope of a single database transaction. It ensures that all database operations within the annotated method succeed together (commit) or fail together (rollback) if a runtime exception occurs.

15. When should you use Eager loading versus Lazy loading in JPA?

Answer: Use Lazy loading as the default for almost all associations (especially collections like @OneToMany) to avoid severe performance penalties and high memory consumption from fetching unneeded data.  Use Eager loading only when you know with absolute certainty that the related entities will always be accessed together with the parent entity in every use case (for example, fetching a User and their AccountPreferences).

16. What is the default rollback behavior of the @Transactional annotation in Spring?

Answer: By default, Spring only rolls back a transaction if a method throws an unchecked exception (a subclass of RuntimeException) or an Error. It does not roll back for checked exceptions.

17. How do you force a transaction to roll back for checked exceptions?

Answer: You configure the rollbackFor attribute within the annotation, such as @Transactional(rollbackFor = Exception.class), which tells Spring to roll back the transaction for any exception thrown.

18. What happens if a non-transactional method calls a @Transactional method within the exact same class?

Answer: The transaction will not start. Spring uses proxy classes to manage transactions; internal method calls (self-invocation) bypass this proxy, meaning the @Transactional annotation is completely ignored.

19. What are the four main states of an entity in the JPA lifecycle?

Answer: The four states are: Transient (newly created, not yet associated with the EntityManager), Persistent (managed by the EntityManager and backed by the database), Detached (previously managed, but the persistence context has been closed or cleared), and Removed (scheduled for deletion from the database).

20. What is the purpose of the cascade attribute in JPA relationships?

Answer: The cascade attribute (such as CascadeType.ALL or CascadeType.REMOVE) tells JPA to automatically propagate database operations from a parent entity to its associated child entities. For example, if you delete a parent entity, cascading ensures all of its linked children are also deleted without requiring separate manual queries.
