import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
class User extends Component {

    render() {
        // Getting the data from Users.js and saves it in variable user for prettier JSX.
        let user = this.props.location.state.data;
        return (
            //Bootstrap magic
            <div className="container-fluid">
                <hr/>
                <h2>Details for {user.first + ' ' + user.last}</h2>
                <div className="row">
                    <div className="col-sm-1">
                        <p><span className="label label-info">Gender</span></p>
                        <p><span className="label label-info">First Name</span></p>
                        <p><span className="label label-info">Last Name</span></p>
                        <hr/>
                        <p><span className="label label-info">Street</span></p>
                        <p><span className="label label-info">City</span></p>
                        <p><span className="label label-info">Zip</span></p>
                        <hr/>
                        <p><span className="label label-info">Phone</span></p>
                        <p><span className="label label-info">Cell</span></p>
                        <p><span className="label label-info">Email</span></p>
                        <hr/>
                        <NavLink className="btn btn-primary" to="/">Back</NavLink>
                    </div>
                    <div className="col-sm-3">
                        <p>{user.gender}</p>
                        <p>{user.first}</p>
                        <p>{user.last}</p>
                        <hr/>
                        <p>{user.street}</p>
                        <p>{user.city}</p>
                        <p>{user.zip}</p>
                        <hr/>
                        <p>{user.phone}</p>
                        <p>{user.cell}</p>
                        <p>{user.email}</p>
                        <hr/>
                    </div>
                    <div className="col-sm-8">
                        <img src={user.picture.large} width="300px" height="300px" alt="img"/>
                    </div>
                </div>
            </div>

        );
    }
}

export default User;
