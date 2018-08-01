const http = require('http');

const config = {
    COFFEE_PATH : "/coffee",
    TEMPERATURE_PATH : "/temperature",
    LIGHTS_PATH : "/light",
};


//Default Werte für die HTTP-Post Methode
var post_options = {
    hostname: "c4k-iot.us.openode.io",
    path: '',
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    }
  };

async function getTemperature() {
    return new Promise((resolve) => {
        http.get("http://c4k-iot.us.openode.io"+config.TEMPERATURE_PATH, (resp) => {
          let data = '';
  
          resp.on('data', (chunk) => {
              data += chunk;
          });
          
          resp.on('end', () => {
              resolve(JSON.parse(data).temperature)
          });
      });
    })
  }
  
  async function makeCoffee() {
    return new Promise((resolve) => {
        post_options.path = config.COFFEE_PATH;
        var req = http.request(post_options, function(res) {
          res.setEncoding('utf8');
          res.on('data', function (body) {
            resolve("success");
          });
        });
        
        req.on('error', function(e) {
          console.log('problem with request: ' + e.message);
        });
        
        req.write('{"state": true}');
        req.end();
      });
  }
  
  
  async function setLight(color) {
    return new Promise((resolve) => {
        post_options.path = config.LIGHTS_PATH;
        var req = http.request(post_options, function(res) {
          res.setEncoding('utf8');
          res.on('data', function (body) {
            resolve("success");
          });
        });
        
        req.on('error', function(e) {
          console.log('problem with request: ' + e.message);
        });
  
        req.write('{"color": "'+color+'"}');
        req.end();
      });
  }


module.exports = {
    setLight: setLight,
    makeCoffee: makeCoffee,
    getTemperature: getTemperature
};
  