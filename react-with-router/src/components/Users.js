import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
class Users extends Component {


    // Method for rendering list of users, uses data from props, passed from App.js
    renderUserList() {
        let userList = [];
        this.props.data.users.map((user, index) => {
                return (
                    userList.push(
                        <tr key={index}>
                            <td><img src={user.picture.large} alt="img"/></td>
                            <td>first: {user.first + ' ' + user.last}</td>
                            {/* here we pass the clicked user to the user page via state */}
                            <td><NavLink to={{pathname: '/user/' + index, state: {data: user}}}>Details</NavLink></td>
                        </tr>
                    )
                )
            }
        )
        return userList;
    }

    render() {
        return (
            <div>
                <table className="table">
                    <thead>
                    <tr>
                        <th>IMG</th>
                        <th>Name</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.renderUserList()}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default Users;
