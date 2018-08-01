//Globale Konfiguration
const SKILL_NAME = 'Catalysts';
const api = require('./api');

//FACTS BEGIN

const facts = [
    'Catalysts gibt es in Innsbruck seit Dezember 2017',
    'Coding 4 Kids gibt es heuer in mehreren Bezirken'
];


const GetNewFactHandler = {

  canHandle(handlerInput) {
    const request = handlerInput.requestEnvelope.request;
    return request.type === 'LaunchRequest'
      || (request.type === 'IntentRequest'
        && request.intent.name === 'GetNewFactIntent');
  },

  handle(handlerInput) {
    const factArr = facts;
    const factIndex = Math.floor(Math.random() * factArr.length);
    const randomFact = factArr[factIndex];

    return handlerInput.responseBuilder
      .speak("Hier ist dein Fakt: " + randomFact)
      .withSimpleCard(SKILL_NAME, randomFact)
      .getResponse();
  },
};

//FACTS END


//TEMPERATURE BEGIN

const GetTemperatureHandler = {
  canHandle(handlerInput) {
    const request = handlerInput.requestEnvelope.request;
    return request.type === 'LaunchRequest'
      || (request.type === 'IntentRequest'
        && request.intent.name === 'GetTemperatureIntent');
  },

  async handle(handlerInput) {
      
      var celsius = await api.getTemperature();
      var celsius_clean = celsius.toString().replace(".", ",");
      
      return handlerInput.responseBuilder
      .speak("Die aktuelle Temperatur in eurem Büro beträgt " + celsius_clean + " Grad Celsius")
      .withSimpleCard(SKILL_NAME, celsius_clean)
      .getResponse();
      
  }

};

//TEMPERATURE END


//LIGHT BEGIN

const SetLightColorHandler = {
  canHandle(handlerInput) {
    const request = handlerInput.requestEnvelope.request;
    return request.type === 'LaunchRequest'
      || (request.type === 'IntentRequest'
        && request.intent.name === 'SetLightColorIntent');
  },

  async handle(handlerInput) {
    
    await api.setLight(handlerInput.requestEnvelope.request.intent.slots.farbe.value);
    
    return handlerInput.responseBuilder
      .speak("Das Licht ist nun " + handlerInput.requestEnvelope.request.intent.slots.farbe.value)
      .withSimpleCard(SKILL_NAME, "")
      .getResponse();
  },

};

//LIGHT END


//COFFEE BEGIN

const MakeCoffeeHandler = {
  canHandle(handlerInput) {
    const request = handlerInput.requestEnvelope.request;
    return request.type === 'LaunchRequest'
      || (request.type === 'IntentRequest'
        && request.intent.name === 'MakeCoffeeIntent');
  },
  async handle(handlerInput) {
    
    await api.makeCoffee();
    
    return handlerInput.responseBuilder
      .speak("Ok " +handlerInput.requestEnvelope.request.intent.slots.employee.value+" dein Kaffee wird nun zubereitet")
      .withSimpleCard(SKILL_NAME, "")
      .getResponse();
  },
};


//COFFEE END


module.exports = {
    MakeCoffeeHandler: MakeCoffeeHandler,
    SetLightColorHandler: SetLightColorHandler,
    GetTemperatureHandler: GetTemperatureHandler,
    GetNewFactHandler: GetNewFactHandler
}
