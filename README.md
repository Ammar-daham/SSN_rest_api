# Finnish SSN Validator 
This is a simple REST API developed using Spring Boot. The API provides a single endpoint for validating Finnish social security numbers (SSN).
The App includes JUnit tests for testing the valid format of SSN, The appliction dockerized using docker containers.

## Prerequisites
* Java 17 or later
* To run and pull Docker images, make sure your local machine have Docker Desktop installed and running. You can download Docker Desktop from the official website: https://www.docker.com/products/docker-desktop.


## Installion
* Clone the repository to your local machine:
  ```bash
    git clone git@github.com:Ammar-daham/SSN_rest_api.git
  ```

* Navigate to the project directory:
  ```
    cd SSN_rest_api
  ```
  
* import the app to the IDE eclipce or other and import the app using existing maven app.

* On the root directory right click and run as Maven install to install the jar file.

* To run the api type the following command:
  ```
    java -jar target/spring-boot-docker.jar
  ```
  
* You can run the app by right click on the root directory and run as Java Application

* The other way to run the app by pulling docker image from Docker Hub by typing the following command:

  ```
    docker pull ammarfad/spring-boot-app.jar:latest
  ``` 
  
* Then type the following command to run the docker image
 
    ```
      docker run -p 8080:8080 ammarfad/spring-boot-app.jar:latest
    ```
  
  
  ## API ENDPOINT
  
  * [http://localhost:8080/validate_ssn](http://localhost:8080/validate_ssn)
  
  
    <img width="1440" alt="Screenshot 2023-04-09 at 20 22 15" src="https://user-images.githubusercontent.com/32091211/230787215-894632bb-3848-4a48-9923-72b432165330.png">
    <img width="1440" alt="Screenshot 2023-04-09 at 20 21 40" src="https://user-images.githubusercontent.com/32091211/230787224-a05f807b-09a5-43d0-9431-19a654f69e08.png">

  
