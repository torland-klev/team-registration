import React, { Component } from 'react';
import './CreatePlayerView.css';

export default class CreatePlayerView extends Component {
  constructor(props){
    super(props);
    this.state = {
      title: "Create Player",
      selectedFile: null,
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
        <input type="text" placeholder="Player Name" maxLength="64" required/>
        <input type="date" required />
      </div>;
    if (this.state.selectedFile){
      return(
        <div className="CreatePlayerContainer">
          <img src={URL.createObjectURL(this.state.selectedFile)} onClick={this.handleFileSelect} />
          {similar}
        </div>
      )
    } else {
      return(
        <div className="CreatePlayerContainer">
          <div className="UploadImage" onClick={this.handleFileSelect}>
            +
          </div>
          {similar}
        </div>
      );
    }
  }
}
