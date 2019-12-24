import React, { Component } from 'react';
import {BrowserRouter, Route, Redirect} from 'react-router-dom';
import './App.css';
import { Banner, BottomBar, Body } from '../';
import { HomeView, PlayersView } from '../../views';

export default class App extends Component {
  render(){
    return (
      <div className="Container">
        <div className="App">
          <Banner />
          <div className="Body">
            <BrowserRouter>
              <div>
                <Route exact path='/' component={HomeView} />
                <Route exact path='/players' component={PlayersView} />
              </div>
            </BrowserRouter>
          </div>
          <BottomBar />
        </div>
      </div>
    );
  }
}
