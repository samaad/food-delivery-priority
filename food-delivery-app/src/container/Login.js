import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { doLogin } from "../app/order/order.action";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const dispatch = useDispatch();
  const onSubmit = () => {
    if (username && password) {
      dispatch(doLogin(username, password));
    }
  };
  return (
    <div className="card border-dark mb-3">
      <div className="card-header">Login</div>
      <div className="card-body text-dark">
        <h5 className="card-title">Sign in</h5>
        <form>
          <div className="mb-3">
            <label htmlFor="username" className="form-label">
              Username
            </label>
            <input
              type="text"
              className="form-control"
              id="username"
              aria-describedby="usernameHelp"
              required
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              name="username"
            />
          </div>
          <div className="mb-3">
            <label htmlFor="password" className="form-label">
              Password
            </label>
            <input
              type="password"
              className="form-control"
              id="password"
              required
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              name="password"
            />
          </div>

          <button onClick={onSubmit} type="button" className="btn btn-primary">
            Submit
          </button>
        </form>
      </div>
    </div>
  );
};

export default Login;
