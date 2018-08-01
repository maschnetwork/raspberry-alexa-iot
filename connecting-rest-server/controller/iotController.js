var light = {color : ""};
var coffee = {state : false};
var temperature = {
    temperature: 0.0,
    humidity: 0.0,
    pressure: 0.0
}

function setTemperature(req, res){
    temperature = req.body
    res.status(200).send(temperature);
}

function setCoffeeState(req, res){
    coffee = req.body
    res.status(200).send(coffee);
}

function setLightColor(req, res){
    light = req.body
    res.status(200).send(light);
}

function getLightState(req, res){
    res.status(200).send(light);
}

function getCoffeeState(req, res){
    res.status(200).send(coffee);
}

function getTemperature(req, res){
    res.status(200).send(temperature);
}


module.exports = {
    setTemperature: setTemperature,
    setCoffeeState: setCoffeeState,
    setLightColor: setLightColor,
    getLightState: getLightState,
    getCoffeeState: getCoffeeState,
    getTemperature: getTemperature
};