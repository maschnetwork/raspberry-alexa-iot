const express = require('./config/express');
const router = require('./middleware/router');

//Initialize Express App
const app = express.getConfiguredExpressApp();

//Apply Middleware
router(app);

const server = app.listen(80, () => console.log('Node IOT server listening on port ' + 80));

module.exports = server;