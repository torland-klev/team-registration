import React, { Component } from 'react';
import './Body.css';

export default class Body extends Component {
  constructor(props){
    super(props);
    this.state = {
      title: "Body",
    };
  }

  render(){
    return(
      <div className="Body">{this.state.title}</div>
    );
  }
}
