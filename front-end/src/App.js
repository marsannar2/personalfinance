import './App.css'; 
import SideBarNav from './sidebarNav';
import {Routes, Route } from "react-router-dom";
import UserRegister from "./user/Useregister"
import UserLogin from "./user/UserLogin";



function App() {
  return (
    <div className="App">
      <SideBarNav/>
      <Routes>
        <Route path = "/users/signup" exact={true} element={<UserRegister />}/>
        <Route path = "/users/signin" exact={true} element={<UserLogin />}/>
      </Routes>


    </div>
  );
}

export default App;
