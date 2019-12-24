import React, { Component } from 'react';
import './Banner.css';

export default class Banner extends Component{
  constructor() {
    super();
    this.state = {
      title: "Banner",
    }
  }

  render(){
    return(
      <div className="Banner">{this.state.title}</div>
    );
  }
}
