const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');

function getConfiguredExpressApp(){
    const app = express();

    app.use(bodyParser.urlencoded({
        extended: true
    }));
    app.use(bodyParser.json());
    app.use(express.static(path.join(__dirname, 'public')));

    return app;
}

module.exports = {
    getConfiguredExpressApp: getConfiguredExpressApp
}