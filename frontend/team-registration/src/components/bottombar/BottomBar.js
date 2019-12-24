import React, { Component } from 'react';
import './BottomBar.css';

export default class BottomBar extends Component {
  constructor(props){
    super(props);
    this.state = {
      title: "Bottom Bar",
    };
  }

  render(){
    return(
      <div className="BottomBar">{this.state.title}</div>
    );
  }
}
