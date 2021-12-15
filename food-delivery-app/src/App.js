import React from 'react';
import { useSelector } from 'react-redux';
import { isAuthenticate } from './app/order/order.selector';
import Layout from './container/Layout';
import Login from './container/Login';
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const isAuth = useSelector(isAuthenticate);
  console.log(isAuth)
  return (
    <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
        <a href="/tutorials" className="navbar-brand">
          s
        </a>
        <div className="navbar-nav mr-auto">
          <li className="nav-item">
            <a href="/tutorials" className="nav-link">
              Tutorials
            </a>
          </li>
        </div>
      </nav>
      <div className="container">
        {isAuth &&
          <Layout />
        }
        {!isAuth &&
          <Login />
        }
      </div>
    </div>
  );
}

export default App;
