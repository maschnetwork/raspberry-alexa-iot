const chai = require('chai');
const should = chai.should();
const chaiHttp = require('chai-http');
const app = require('../index');

chai.use(chaiHttp);

var light = {color : "green"};

var coffee = {state : true};

var temperature = {
    temperature: 10.0,
    humidity: 12.0,
    pressure: 13.0
}

describe('Integration Test: ', () => {

    describe('IOT Controller', () => {
        it('Set and Get temperature', (done) => {
            chai.request(app)
                .post('/temperature')
                .send(temperature)
                .end((err, res) => {
                    should.not.exist(err);
                    res.status.should.eql(200);
                    res.type.should.eql('application/json');
                    
                    chai.request(app)
                     .get('/temperature')
                     .end((err, res) => {
                        should.not.exist(err);
                        res.status.should.eql(200);
                        res.type.should.eql('application/json');
                        should.equal(res.body.toString(), temperature.toString())
                    });
    
                    done();
                });
               
        });

        it('Set and Get coffee state', (done) => {
            chai.request(app)
                .post('/coffee')
                .send(coffee)
                .end((err, res) => {
                    should.not.exist(err);
                    res.status.should.eql(200);
                    res.type.should.eql('application/json');
                    
                    chai.request(app)
                     .get('/coffee')
                     .end((err, res) => {
                        should.not.exist(err);
                        res.status.should.eql(200);
                        res.type.should.eql('application/json');
                        should.equal(res.body.toString(), coffee.toString())
                    });

                    done();
                });
               
        });

        it('Set and Get light color', (done) => {
            chai.request(app)
                .post('/light')
                .send(light)
                .end((err, res) => {
                    should.not.exist(err);
                    res.status.should.eql(200);
                    res.type.should.eql('application/json');

                    chai.request(app)
                    .get('/light')
                    .end((err, res) => {
                       should.not.exist(err);
                       res.status.should.eql(200);
                       res.type.should.eql('application/json');
                       should.equal(res.body.toString(), light.toString())
                   });

                    done();
                });
               
        });

    });

});
