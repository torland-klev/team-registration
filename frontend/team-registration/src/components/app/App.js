import React, { Component } from 'react';
import {BrowserRouter, Route, Redirect} from 'react-router-dom';
import './App.css'
import { APP_NAME } from '../../config';
import { Banner, Footer } from '../';
import SiteImage from '../siteimage/SiteImage';
import { HomeView, PlayersView, CreatePlayerView } from '../../views';

export default class App extends Component {
  render(){
    return (
      <div className="Container">
        <SiteImage />
        <Banner text={APP_NAME} buttons={["Players", "Teams", "Leagues"]} onClick={["/players", "/teams", "/leagues"]}/>
        <BrowserRouter>
          <div className="Body">
            <Route exact path='/' component={HomeView} />
            <Route exact path='/players' component={PlayersView} />
            <Route exact path='/create-player' component={CreatePlayerView} />
          </div>
        </BrowserRouter>
        <Footer />
      </div>
    );
  }
}
