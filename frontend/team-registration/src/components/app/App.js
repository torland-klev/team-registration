import React, { Component } from 'react';
import logo from '../../images/logo.svg';
import './App.css';
import { Banner } from '../';

export default class App extends Component {
  render(){
    return (
      <div className="App">
        <Banner title="Noe" />
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Hello World!
          </p>
        </header>
      </div>
    );
  }
}
