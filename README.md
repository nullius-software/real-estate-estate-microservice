# Real Estate Estate Microservice - Setup Guide

Welcome to the Real Estate Estate Microservice project. This guide provides step-by-step instructions to set up the development environment locally.

## About This Repository

The `real-estate-estate-microservice` repository serves as the Estate Service for the Real Estate project. The Estate Microservice handles all estate-related operations such as property listings, property details, and more. It is built using Kotlin and SpringBoot.

## Prerequisites

- Docker: Ensure Docker is installed and running on your machine. Download from [docker.com](https://www.docker.com) if needed.
- Access to a terminal (bash, cmd, PowerShell, etc.).
- Internet connection to pull necessary images.
- Keycloak: Ensure Keycloak is running locally. The guide for configuring Keycloak locally can be found [here](https://github.com/nullius-software/real-estate-keycloak-render).
- Discovery Service: Ensure the discovery service is running locally. The guide for setting up the discovery service can be found [here](https://github.com/nullius-software/real-estate-discovery-service).

## Step 1: Clone the Repository

First, clone the `real-estate-estate-microservice` repository to your local machine:

```bash
git clone https://github.com/nullius-software/real-estate-estate-microservice.git
cd real-estate-estate-microservice
```

## Step 2: Build the Docker Image

Build the Docker image for the Estate Microservice:

```bash
docker build -t real-estate-estate-microservice .
```

## Step 3: Run the Docker Container

Run the Docker container for the Estate Microservice:

```bash
docker run -p 8082:8082 real-estate-estate-microservice
```

### Explanation:

- `-p 8082:8082`: Maps port 8082 from the container to your local machine.

Wait for the container to start. You’ll see logs indicating the Estate Microservice is ready when something like this appears:

```
Started EstateMicroserviceApplication in X.XXX seconds
```

## Step 4: Access the Estate Microservice

Open your browser and go to: [http://localhost:8082](http://localhost:8082).

You should see the Estate Microservice indicating that it is running.

## Step 5: Verify the Configuration

Ensure that the other microservices in the Real Estate project are configured to communicate with the Estate Microservice by checking their configuration files. They should have the Estate Microservice URL set to `http://localhost:8082`.
