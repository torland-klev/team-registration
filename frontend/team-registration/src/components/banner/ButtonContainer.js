import React, { Component } from 'react';
import './Banner.css';
import { TextButton } from '../';

export default class ButtonContainer extends Component {

  render(){
    return(
      <div className="ButtonContainer">
        <TextButton text="Players" onClick={() => (window.location.href = '/players')}/>
        <TextButton text="Teams" onClick={() => (window.location.href = '/teams')}/>
        <TextButton text="Leagues" onClick={() => (window.location.href = '/leagues')}/>
      </div>
    );
  }
}
