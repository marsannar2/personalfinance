import {React,useState} from "react";
import { Link } from 'react-router-dom';
import { Navbar, NavLink, NavItem,Nav} from 'reactstrap';
import sidebarNav from "./sidebarNav.css";
import UserProfileButton from "./user/UserProfileButton";




function SideBarNav() {
    

    return (
      <>
        <div className = "sidebar-nav">
            <UserProfileButton/>
            <Navbar expand="md" dark color="dark">
                <Nav className="navbar" navbar>
                    <NavItem classname="nav-item">
                        <NavLink className = "nav-link" tag={Link} to="/budget">Budget</NavLink>
                    </NavItem>
                    
                    <NavItem className="nav-item">
                        <NavLink className = "nav-link" tag={Link} to="/users">Stats</NavLink>
                    </NavItem>
                    
                    <NavItem className="nav-item">
                        <NavLink className = "nav-link" tag={Link} to="/accounts">All Accounts</NavLink>
                    </NavItem>
                    
                </Nav>   
            </Navbar>
            <hr></hr>
        </div>
       
      </>
    )
  }

  export default SideBarNav;