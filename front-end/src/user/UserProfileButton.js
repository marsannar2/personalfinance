import { useState } from "react";
import { Link } from "react-router-dom"; 
import "./UserProfileButton.css";

function UserProfileButton(){

    const [user,setUser] = useState({username:"johndoe",email:"johndoe@gmail.com"});


    return(
        <div className="user-profile-button" >   
            <button className="auth-button">
                <img className = "profile-icon" src = "profile-icon.jpg" alt="profile-picture" ></img>
                <Link to={`users/profile`} className="auth-button" style={{ textDecoration: "none" }}></Link>  
                <p>{user.username} </p>
                <p>{user.email} </p>
            </button>                
        </div>
        
        
    )





}

export default UserProfileButton;