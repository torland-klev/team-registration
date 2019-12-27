import React, { Component } from 'react';
import './CreatePlayerView.css';

export default class CreatePlayerView extends Component {
  constructor(props){
    super(props);
    this.state = {
      title: "Create Player",
    };
  }

  render(){
    return(
      <div className="CreatePlayerView">{this.state.title}</div>
    );
  }
}
