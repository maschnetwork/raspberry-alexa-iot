/* eslint-disable  func-names */
/* eslint-disable  no-console */

const defaultHandler = require('./default_handler');
const customHandler = require('./custom_handler');
const Alexa = require('ask-sdk');



const skillBuilder = Alexa.SkillBuilders.standard();

exports.handler = skillBuilder
  .addRequestHandlers(
    defaultHandler.HelpHandler,
    defaultHandler.ExitHandler,
    defaultHandler.SessionEndedRequestHandler,
    customHandler.SetLightColorHandler,
    customHandler.MakeCoffeeHandler,
    customHandler.GetTemperatureHandler,
    customHandler.GetNewFactHandler,
  )
  .addErrorHandlers(defaultHandler.ErrorHandler)
  .lambda();
