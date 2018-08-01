// External modules
const iotController = require('../controller/iotController');

module.exports = (app) => {

    app.get("/", (req, res) => res.send("Hello IOT Thingy!"));

    app.post('/light', iotController.setLightColor);
    app.post('/coffee', iotController.setCoffeeState);
    app.post('/temperature', iotController.setTemperature);

    app.get('/light', iotController.getLightState);
    app.get('/coffee', iotController.getCoffeeState);
    app.get('/temperature', iotController.getTemperature);

};
