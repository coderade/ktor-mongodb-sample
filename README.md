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

With the aplication running we can test using the curl command doing a get request to the `/cars` endpoint.

To do this run:

    curl localhost:8080/cars
  
A result like the following will be returned to you:

    [ {
        "id" : {
            "timestamp" : 1631582435,
            "counter" : 16729557,
            "time" : 1631582435000,
            "machineIdentifier" : 5888057,
            "processIdentifier" : 6193,
            "timeSecond" : 1631582435,
            "date" : 1631582435000
        },
        "model" : "BMW X5 M",
        "year" : 2010
    }, {
        "id" : {
            "timestamp" : 1631582435,
            "counter" : 16729559,
            "time" : 1631582435000,
            "machineIdentifier" : 5888057,
            "processIdentifier" : 6193,
            "timeSecond" : 1631582435,
            "date" : 1631582435000
        },
        "model" : "2009 Cadillac CTS-V",
        "year" : 2009
    }, {
        "id" : {
            "timestamp" : 1631582435,
            "counter" : 16729561,
            "time" : 1631582435000,
            "machineIdentifier" : 5888057,
            "processIdentifier" : 6193,
            "timeSecond" : 1631582435,
            "date" : 1631582435000
        },
        "model" : "Bugatti Veyron 16.4 Grand Sport Vitesse",
        "year" : 2012
    }, 
    ...
    
    


