import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import '../styles/Profile.css';

const Profile = () => {
  const { userId } = useParams();
  const [user, setUser] = useState(null);
  const [bookmarks, setBookmarks] = useState([]);

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/SaveSite/user/${userId}`);
        setUser(response.data);
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };

    const fetchBookmarks = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/SaveSite/bookmark/user/${userId}`);
        setBookmarks(response.data);
      } catch (error) {
        console.error('Error fetching bookmarks:', error);
      }
    };

    fetchUser();
    fetchBookmarks();
  }, [userId]);

  if (!user) return <p>Loading...</p>;
  if (!bookmarks) return <p>Loading bookmarks...</p>;

  return (
    <div className="profile-container">
      <h2 className="profile-header">{user.login}'s Profile</h2>
      <h3>Your Bookmarks</h3>
      <ul className="bookmarks-list">
        {bookmarks.map(bookmark => (
          bookmark && bookmark.title && bookmark.link ? (
            <li key={bookmark.id}>
             <span>{bookmark.title}</span> - <a href={bookmark.link} target="_blank" rel="noopener noreferrer">View Bookmark</a>
            </li>
          ) : null
        ))}
      </ul>
    </div>
  );
};

export default Profile;
