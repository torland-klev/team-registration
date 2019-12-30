import React, { Component } from 'react';
import './CreatePlayerView.css';
import { createUser } from '../../services/XRH';

export default class CreatePlayerView extends Component {
  constructor(props){
    super(props);
    this.state = {
      title: "Create Player",
      selectedFile: null,
      name: "",
      date: ""
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
        <input type="text" placeholder="Player Name" maxLength="64" required onChange={(name) => (this.setState({name: name}))}/>
        <input type="date" required />
      </div>;
    if (this.state.selectedFile){
      return(
        <div className="CreatePlayerContainer">
          <img src={URL.createObjectURL(this.state.selectedFile)} onClick={this.handleFileSelect} alt="Player Portrait" />
          {similar}
          <div className="SubmitButton" onClick={() => createUser("test", "2019-01-01", this.state.selectedFile)} >
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
