import { useState } from "react";
import { Link } from "react-router-dom"; 
import "./styles/UserProfileButton.css";
import { FaUser } from "react-icons/fa";
import { IconContext } from "react-icons";

function UserProfileButton(){

    const [user,setUser] = useState({username:"johndoe",email:"johndoe@gmail.com"});


    return(
        <button className="auth-button" type="button">
            <IconContext.Provider value={{size:"2.5em",className:"user-profile-icon"}}>
                <FaUser />
            </IconContext.Provider>
            <div className="user-info-container">
                <p className="profile-text"><Link to={`users/profile`} style={{ textDecoration: "none" }}> {user.username}´s Budget </Link></p>
                <p className="profile-text">{user.email} </p>
            </div>
            
        </button>        
    )





}

export default UserProfileButton;