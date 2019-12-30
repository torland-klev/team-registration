import React, { Component } from 'react';
import './CreatePlayerView.css';
import { createUser } from '../../services/FetchHTTP';

export default class CreatePlayerView extends Component {
  constructor(props){
    super(props);
    this.state = {
      title: "Create Player",
      selectedFile: null
    };
  }

  onChangeHandler = (event) => {
    const file = event.target.files[0];
    this.setState({
      selectedFile: file,
    })
  }

  buildFileSelector(){
    const fileSelector = document.createElement('input');
    fileSelector.setAttribute('type', 'file');
    fileSelector.setAttribute('accept', 'image/*');
    fileSelector.onchange = this.onChangeHandler;
    return fileSelector;
  }

  componentDidMount(){
    this.fileSelector = this.buildFileSelector();
  }

  handleFileSelect = (e) => {
    e.preventDefault();
    this.fileSelector.click();
  }

  render(){

    const similar =
      <div className="InformationContainer">
        <input type="text" placeholder="Player Name" maxLength="64" required id="name-input"/>
        <input type="date" required id="date-input"/>
      </div>;
    if (this.state.selectedFile){
      return(
        <div className="CreatePlayerContainer">
          <img src={URL.createObjectURL(this.state.selectedFile)} onClick={this.handleFileSelect} alt="Player Portrait" />
          {similar}
          <div className="SubmitButton" onClick={() => createUser(document.getElementById("name-input").value, document.getElementById("date-input").value, this.state.selectedFile)} >
            <h5>Create Player</h5>
          </div>
        </div>
      )
    } else {
      return(
        <div className="CreatePlayerContainer">
          <div className="UploadImage" onClick={this.handleFileSelect}>
            +
          </div>
          {similar}
          <div className="SubmitButton" style={{visibility: "hidden"}}><h5>Invisible</h5></div>
        </div>
      );
    }
  }
}
