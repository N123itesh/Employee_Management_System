import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link ,useNavigate, useParams } from "react-router-dom";

const EditEmployees = () => {
    let nevigate = useNavigate();
    const { id } = useParams();
    const [employee, setEmployees] = useState({
        firstName: "",
        lastName: "",
        email: "",
        department: ""
    });

    const { firstName, lastName, email, department } = employee;


      useEffect(() => {
        loadEmployee();
    }, [id])

    const loadEmployee = async () => {
        const result = await axios.get(`http://localhost:8080/employees/employee/${id}`);
            setEmployees(result.data)

    }


    const handleInputChange = (e) => {
        setEmployees({ ...employee, [e.target.name]: e.target.value });
    };

    const updateEmployee = (e) => {
        e.preventDefault();

        axios
            .put(`http://localhost:8080/employees/update/${id}`, employee)
            .then(() => {
                alert("Employee added successfully");
            })
            .catch((error) => {
                console.error(error);
                alert("Error saving employee");
            });
        nevigate("/view-employees");
    };

    return (
        <div className="container col-sm-8 py-2 px-5 shadow">
            <h2 className='mt-5'>Edit Employee</h2>
            <form onSubmit={updateEmployee}>

                <div className="input-group mb-5">
                    <label className="input-group-text">First Name</label>
                    <input
                        type="text"
                        name="firstName"
                        className="form-control"
                        value={firstName}
                        onChange={handleInputChange}
                        required
                    />
                </div>

                <div className="input-group mb-5">
                    <label className="input-group-text">Last Name</label>
                    <input
                        type="text"
                        name="lastName"
                        className="form-control"
                        value={lastName}
                        onChange={handleInputChange}
                        required
                    />
                </div>

                <div className="input-group mb-5">
                    <label className="input-group-text">Email ID</label>
                    <input
                        type="email"
                        name="email"
                        className="form-control"
                        value={email}
                        onChange={handleInputChange}
                        required
                    />
                </div>

                <div className="input-group mb-5">
                    <label className="input-group-text">Department Name</label>
                    <input
                        type="text"
                        name="department"
                        className="form-control"
                        value={department}
                        onChange={handleInputChange}
                        required
                    />
                </div>

                <button type="submit" className="btn btn-outline-success btn-lg me-3">
                    Save
                </button>

                <Link to="/view-employees" className="btn btn-outline-warning btn-lg">
                    Cancel
                </Link>

            </form>
        </div>
    );
};



export default EditEmployees
