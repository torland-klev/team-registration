import React, { Component } from 'react';

export default class Banner extends Component{
  constructor() {
    super();
    this.state = {
      title: "Some title!",
    }
  }

  render(){
    return(
      <div className="Banner">{this.props.title}</div>
    );
  }
}
