# Node.js REST Server for Raspberry PI IOT

This is a REST-Server built with Node.js and Express.js.
Several devices may POST and GET to this REST-Server via HTTP-Protocol and Updating a predifined status.

## Hosting Hint

If you want to run this server on the internet you can use for example: https://www.openode.io/

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

## Installing and Running the Server

A step by step series of examples that tell you have to get a development env running:

Install depencies
```
npm install
```

Run the server with:
```
node index.js
```
## Usage

Adding new Temperatures:

**POST OR GET to /coffee**
```
{
 "state":true
}
```
**POST OR GET to /light**
```
{
 "color":"rot"
}
```

**POST OR GET to /temperature**
```
 {
    "pressure": 954.48,
    "temperature": 36.91,
    "humidity": 30.8
}
```

## Running the tests

Mocha and Chai tests are included. You can run tests with:

```
npm run test
```

## Authors

* **Maximilian Schreiber**

## License

This project is licensed under the MIT License


