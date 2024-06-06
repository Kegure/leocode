// src/components/MainContent.js
import React from 'react';
import '../styles/MainContent.css';

const MainContent = () => {
  return (
    <main className="main-content">
      <section className="intro">
        <h1>Welcome to SaveSite</h1>
        <p>Your ultimate tool for saving and managing URLs efficiently.</p>
      </section>
      <section className="features">
        <h2>Features</h2>
        <ul>
          <li>Save and organize your bookmarks</li>
          <li>Create and manage groups</li>
          <li>Take and store notes</li>
          <li>Tag your saved URLs for easy search</li>
        </ul>
      </section>
    </main>
  );
};

export default MainContent;
