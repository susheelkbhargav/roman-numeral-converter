# roman-numeral-converter
Part of the take home assessment


## Index 


## 1. Goals

A HTTP Endpoint which must accept a URI in this format: http://localhost:8080/romannumeral?query={integer}
{integer} must be any integer value in the range 1-3999 as mentioned in Extension 1 (insert link). Errors can be returned in plain text format, but successful response must be a JSON document
equivalent to:
{
“input” : “1”,
“output” : “I”
}

Extension 1: To extend the range from 1-255 to 1-3999

Extension 3: To include additional DevOps capabilities in the project to represent preparing the project for ease of operation in a production environment (Like metrics, monitoring, logging). To include tooling to build a runnable Docker container for the service.

Extension 2(Optional): To Add support for range queries. of this format:
http://localhost:8080/romannumeral?min={integer}&max={integer}. 
{integer} must be an integer value for both the min and max parameters. Both min and max must be provided. Min must be less than max. Both must be in the
supported range 1-3999. 
To use multithreading in Java or async processing (JavaScript) to compute the values in the range in parallel, assemble the results and return them in ascending order from the minimum to the maximum value. Successful responses to these queries must include a JSON payload with an array named conversions, where each element of the array is an input/output pair of strings, in ascending order. e.g:

{
“conversions”: [
{ “input” : “1”, “output” : “I” },
{ “input” : “2”, “output” : “II” },
{ “input” : “3”, “output” : “III” }
]
}


## 2. Tools Required for the project.

 
  
  *Prerequisites in order of installation: 
  JDK 8+
  Maven 3.6
  * 
  
  To install JDK 8+ version on your system, go to JAVA SE JDK 8 offical download page [here](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html). Download the executable (.exe) file according to your OS requirements and run the executable on the machine
  
  To run the project on your machine, we need to install Maven, a dependency management system. 
  
  To install Maven Please go to the maven official installation page [here](https://maven.apache.org/download.cgi).
  
  Maven and this project requires installation of Java 8. Please refer to the installation order above.
  
  

### 3. Running the program
  

Clone the project using git clone command
  
     git clone https://github.com/susheelkbhargav/roman-numeral-converter.git
     
Navigate to the project folder 
  
    cd roman-numeral-converter-app
    
To build the project, run the following command
    
    mvn clean install

This command reads the dependencies in the pom.xml, clears any compiled files the project might have, runs tests and compiles each module from scratch. This will generate a jar file. This will generate a jar file and stores it in the target folder. Since you're already inside the project folder, change to target folder using cd

     cd target/

run the jar file using java -jar and the name of the snapshot.Here it is 
"roman-numeral-converter-app-0.0.1-SNAPSHOT.jar"

     java -jar roman-numeral-converter-app-0.0.1-SNAPSHOT.jar
     
We can start hitting the endpoint once the console prints a message similar to this

      INFO 3844 --- [           main] c.s.romannumeral.RomanNumsApplication    : Started RomanNumsApplication in 6.029 seconds (JVM running for 7.154)


After sucessful start of the server, Use any browser or any tool to access the API. 
  
      http://localhost:8080/romannumeral?query={integer} , 
replace '{integer}' with any integer number between 1 and 3999 (included)`

*Note : If there is any application already using port 8080 you may get error saying the port 8080 is already in use. To resolve this, you can either change the port (recommended) or stop the other process running on port 8080 if needed*

ALTERNATIVELY

   you can use docker to run the project. To install docker and its dependencies,click [here](https://docs.docker.com/get-docker/)
   
   pull the docker image from my docker hub using CLI using the uri
   
     docker pull susheelkbhargav/roman-numeral-converter-app
   
   map ports 8080, and 9091 to their respective ports for the container and run
   
     docker run -p 8080:8080 9091:9091 susheelkbhargav/roman-numeral-converter-app
 
 This will start the container and expose the api on the above ports
 
 Hit the API with either a "query" parameter or with "min" and "max" parameter. 
 
 For more on api-documentation go to the following url
    
     http://localhost/8080/api-docs

## 4. Development methodology

### Step 1: Requirement gathering 

     The first step was reading the assignment document in detail, I took considerable time to read the document. The required extensions was to expand the range of numbers to convert from 1-3999, and to make the project production ready i.e, it should give out the required output, give out the specified errors, throw exceptions, log correctly and expose endpoints for a production tool monitor or gather metrics, preferably in a containerized way

### Step 2: Design considerations  

   #### Language and Tools Considerations
   
    
  I chose Java (version 8) and Spring Boot to develop this application as Spring Boot has features like actuator which expose metrics as a HTTP endpoint which could be scraped or polled by a monitoring tool in a production environment (e.g, Prometheus). Spring Boot also has an embedded server which would help me in rapid deployment and debugging during the course of the development. And I can simply add the frameworks needed using maven.
    
  I am familiar with Docker so I could use a docker file to build a container with all the required dependencies and push it to a docker hub. The user could use the public URL to download the image and run the docker container without needing to install any tools or dependencies in the user's system.
    
  #### Application Design Considerations
  
  Considerable time is spent to make sure the application is designed using best practices. Some of them are:
      The romannumeral api will accept a GET request in JSON and will only respond in JSON
      The application is developed using seperation of concerns design pattern. The code for accepting Requests is put in the controller layer, the code to convert from Integer to Roman Numeral is put in the service layer, Exceptions are handled in exception layer ..etc
      
   

### Step 3: Test cases and development  

 All the edge cases like, input number 0, negative numbers and strings containing alphabets are tested using junit




## 5. Project layout
pom.xml                  # Maven pom file for build and dependencies     
README.md                # The current readme file

## 6. Data call flow 

 

## 8. Error handling

### Query value is 0
  
The server will return a **422 ( UNPROCESSABLE ENTITY ) status code along with a json object**:

    {
      status: "UNPROCESSABLE_ENTITY",
      message: "Query parameter value is 0, Roman numbers do not have a 0. Smallest supported value is 1."
    }


### Query value is not in range

The server will return a **422 ( UNPROCESSABLE ENTITY ) status code along with a json object**:

    {
	    status: "UNPROCESSABLE_ENTITY",
        message: "The number entered must be between 1and 3999"
    }
 
 
### Query value is not an integer

The server will return a **400 Bad Request status code because of MismatchedArgumentException** :

    {
	   
    }

## 10. Containerization and Metrics



## 11. References



