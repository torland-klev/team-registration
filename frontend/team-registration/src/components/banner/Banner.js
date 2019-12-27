import React, { Component } from 'react';
import './Banner.css';
import { TextButton } from '../';
import { ButtonContainer } from './';

export default class Banner extends Component{

  render(){
    return(
      <div className="Banner">
        <TextButton bold text="appname" onClick={() => (window.location.href = '/players')} style={{fontSize: '30px'}}/>
        {this.props.title}
        <ButtonContainer />
      </div>
    );
  }
}
