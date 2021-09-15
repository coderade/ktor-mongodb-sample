# ktor-mongodb-sample

Sample project of how to use MongoDb and Kotlin/Ktor


## How to use

To run the Application, first we need orchestrate the MongoDb container, to do this we need to have the Docker and Docker 
Compose installed. To learn how to install these tools please follow their official documentations:

* [Install Docker](https://docs.docker.com/install/) 
* [Install Docker Compose](https://docs.docker.com/compose/install/)


### Building the MongoDB image using docker-compose

To build the mongo image, on the root directory of this project, run the following command:

    docker compose up --build    

The command will create and build the mongodb image pulling from the MongoDb official docker [repository](https://hub.docker.com/_/mongo) with latest version.


### Running the Application

To Run the application, use the default Run option in [IDEA](https://www.jetbrains.com/idea/) IDE in the `src/main/kotlin/ci/valde/Application.kt` file.

## Testing 

With the application running we can test using the curl command doing a get request to the `/cars` endpoint.

To list all the cars this run:

    curl localhost:8080/cars
  
A result like the following will be returned to you:

    [
      {
        "id":{
          "timestamp":1631706188,
          "counter":10447889,
          "machineIdentifier":7430267,
          "processIdentifier":21328,
          "timeSecond":1631706188,
          "date":1631706188000,
          "time":1631706188000
        },
        "model":"BMW X5 M",
        "year":2010,
        "fuel":99.9,
        "idAsHex":"6141dc4c71607b53509f6c11"
      },
      {
        "id":{
          "timestamp":1631706188,
          "counter":10447890,
          "machineIdentifier":7430267,
          "processIdentifier":21328,
          "timeSecond":1631706188,
          "date":1631706188000,
          "time":1631706188000
        },
        "model":"2009 Cadillac CTS-V",
        "year":2009,
        "fuel":12.9,
        "idAsHex":"6141dc4c71607b53509f6c12"
      },
      {
        "id":{
          "timestamp":1631706188,
          "counter":10447891,
          "machineIdentifier":7430267,
          "processIdentifier":21328,
          "timeSecond":1631706188,
          "date":1631706188000,
          "time":1631706188000
        },
        "model":"Bugatti Veyron 16.4 Grand Sport Vitesse",
        "year":2012,
        "fuel":50,
        "idAsHex":"6141dc4c71607b53509f6c13"
      }
     ...
    ]

To get a specific car use:

    curl localhost:8080/cars/<idAsHex>

To fuel up a specific car (update the fuel of the car to 99.9), we can use the following endpoint passing 
idAsHex as parameter

    curl -X POST localhost:8080/fuel-up/<idAsHex>


To replace a car, we can use the following endpoint:

    curl -X POST localhost:8080/replace -v \
        -H "Content-Type: application/json" \
        -d '{
                "id":"<idAsHex>",
                "model":"Nissan Kicks SL 1.6",
                "year":2018,
                "fuel":99.9
            }' 

    


