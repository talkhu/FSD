import React, { Component }  from 'react'
import ReactDOM from 'react-dom';
import './index.css';
import VideoPlayer from './components/video-player';
import Course from './components/course';

import  { Tabs }  from 'element-react'
import 'element-theme-default'

//ReactDOM.render(<App />, document.getElementById('root'));

class App extends Component {
render() {
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
  )
}

}
//export default App;

ReactDOM.render(
  <App />,
  document.getElementById('root')
);
