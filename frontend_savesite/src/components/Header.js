// src/components/Header.js
import React, { useState } from 'react';
import '../styles/Header.css';
import logo from '../assets/nobgLogo.png';
import { Link } from 'react-router-dom';
const Header = ({ setLanguage }) => {
    // Simulate user login status
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const toggleLogin = () => {
        setIsLoggedIn(!isLoggedIn);
    };
    return (
        <header className="header">
            <div className="logo">
                <Link to="/">
                    <img src={logo} alt="SaveSite Logo"/>
                </Link>
            </div>
            <nav className="nav">
                <ul>
                    <li><Link to="/">Home</Link></li>
                    {!isLoggedIn ? (
                        <>
                            <li><Link to="/register">Register</Link></li>
                            <li><Link to="/login">Login</Link></li>
                        </>
                    ) : (
                        <>
                            <li><Link to="/profile">Profile</Link></li>
                            <li><Link to="/logout" onClick={toggleLogin}>Logout</Link></li>
                        </>
                    )}
                </ul>
            </nav>

        </header>
    );
};

export default Header;
