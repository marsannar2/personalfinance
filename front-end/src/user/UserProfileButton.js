import { useState } from "react";
import { Link } from "react-router-dom"; 
import "./styles/UserProfileButton.css";

function UserProfileButton(){

    const [user,setUser] = useState({username:"johndoe",email:"johndoe@gmail.com"});


    return(
        <button className="auth-button" type="button">
            <img className = "profile-icon" src = "profile-icon.jpg" alt="profile-picture" ></img>
            <div className="user-info-container">
                <p className="profile-text"><Link to={`users/profile`} style={{ textDecoration: "none" }}> {user.username}´s Budget </Link></p>
                <p className="profile-text">{user.email} </p>
            </div>
            
        </button>        
    )





}

export default UserProfileButton;