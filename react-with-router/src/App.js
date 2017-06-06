import React, {Component} from 'react';
import './App.css';
import jsonData from "./data/data.json";
import {BrowserRouter as Router,Route} from 'react-router-dom';
import Users from './components/Users'
import User from './components/User'

class App extends Component {
    // Imports data via import and add it to state
    state = {
        data: jsonData
    }
    render() {
        return (
          <div>
              <Router>
                  <div>
                      {/*Passes state with route + only renders if path === / */}
                      <Route exact path="/" render={props=><Users data={this.state.data}/>}/>
                      {/* User router, takes in param ID*/}
                      <Route exact path="/user/:id" component={User} />
                  </div>
              </Router>
          </div>
        );
    }
}

export default App;
