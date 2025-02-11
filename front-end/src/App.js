import './App.css'; 
import SideBarNav from './sidebarNav';
import {Switch, Route } from "react-router-dom";
import UserRegister from "./user/Useregister"



function App() {
  return (
    <div className="App">
      <SideBarNav/>
      <Switch>
        <Route path = "/users/signup" exact={true}><UserRegister/></Route>
      </Switch>


    </div>
  );
}

export default App;
