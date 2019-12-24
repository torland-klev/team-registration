import React, { Component } from 'react';
import './PlayersView.css';

export default class PlayersView extends Component {
  constructor(props){
    super(props);
    this.state = {
      title: "Players",
    };
  }

  render(){
    return(
      <div className="HomeView">{this.state.title}</div>
    );
  }
}
