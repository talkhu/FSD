import React, { Component } from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from 'react-router-dom';
import Header from './layout/header';
import SideMenu from './layout/sidemenu';
import VideoPlayer from './components/video-player';
import Course from './components/course';
import  { Tabs, Input }  from 'element-react'
import 'element-theme-default';

class App extends Component {
  state = { hide: false };

  render() {
    const { hide } = this.state;

    return (
      <div>
        <Tabs activeName="2" onTabClick={ (tab) => console.log(tab.props.name) }>
        <Tabs.Pane label="Video Player" name="1">
           <VideoPlayer />
        </Tabs.Pane>
        <Tabs.Pane label="Play List" name="2">
           <Course />
        </Tabs.Pane>
        </Tabs>
      </div>
    );
  }

  handleToggleSideMenu = () => {
    this.setState(() => ({
      hide: !this.state.hide,
    }));
  };
}

export default App;
