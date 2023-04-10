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
  
  
    <img width="1440" alt="Screenshot 2023-04-09 at 20 22 15" src="https://user-images.githubusercontent.com/32091211/230787215-894632bb-3848-4a48-9923-72b432165330.png">
    <img width="1440" alt="Screenshot 2023-04-09 at 20 21 40" src="https://user-images.githubusercontent.com/32091211/230787224-a05f807b-09a5-43d0-9431-19a654f69e08.png">

  
