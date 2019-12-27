import React, { Component } from 'react';
import './PlayersView.css';
import { ListContainer } from '../../components';

export default class PlayersView extends Component {
  constructor(props){
    super(props);
    this.state = {
    };
  }

  render(){
    return(
      <div className="PlayersView">
        <ListContainer />
      </div>
    );
  }
}
