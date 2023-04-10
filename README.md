# Finnish SSN Validator 
This is a simple REST API developed using Spring Boot. The API provides a single endpoint for validating Finnish social security numbers (SSN).
The App includes JUnit tests for testing the valid format of SSN, The appliction dockerized using docker containers.

## Prerequisites
* Java 17 or later
* To run and pull Docker images, make sure your local machine have Docker Desktop installed and running. You can download Docker Desktop from the official website: https://www.docker.com/products/docker-desktop.


## Installation
* Clone the repository to your local machine:
  ```bash
    git clone git@github.com:Ammar-daham/SSN_rest_api.git
  ```

* Navigate to the project directory:
    ```
      cd SSN_rest_api
    ```
  
* Import the app to your preferred IDE, such as Eclipse, and import the app as an existing Maven project.

* On the root directory of the project, right-click and run as Maven install to install the jar file.

* To run the API, use either of the following methods:
  1. Using the command line, type the following command:
  
    ```
      java -jar target/spring-boot-docker.jar
    ```
  
  2.  In your IDE, right-click on the root directory of the project and run as Java Application.
      Note: Make sure you have the required JDK installed and set in your system's path.
  

* Another way to run the app is by pulling the Docker image from Docker Hub. Use the following commands:

    ```
      docker pull ammarfad/spring-boot-app.jar:latest
      docker run -p 8080:8080 ammarfad/spring-boot-app.jar:latest
    ```
 

     

  
  
  ## API ENDPOINT
  
  * [http://localhost:8080/validate_ssn](http://localhost:8080/validate_ssn)
    
    [EndPoint call](https://user-images.githubusercontent.com/32091211/230982269-68297519-0b8a-402d-848a-d875ae3ec62c.mov)    




  
