import './App.css';
import EmployeesView from './Component/employee/EmployeesView';
import Home from './Home';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "/node_modules/bootstrap/dist/js/bootstrap.min.js";
import Nav from './Component/common/Nav';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import AddEmployees from './Component/employee/AddEmployees';
import EditEmployees from './Component/employee/EditEmployees';
import EmployeeProfile from './Component/employee/EmployeeProfile';

function App() {
  return (
    <main className="container mt-5 ">
     
      
      <Router>
        <Nav/>
        {/* <EmployeesView /> */}
        <Routes>
          <Route exact path='/' element={<EmployeesView/>}></Route>
          <Route exact path='/view-employees' element={<EmployeesView/>}></Route>
          <Route exact path='/add-employees' element={<AddEmployees/>}></Route>
          <Route exact path='/edit-employee/:id' element={<EditEmployees/>}></Route>
          <Route exact path='/employee-profile/:id' element={<EmployeeProfile/>}></Route>

          
        </Routes>
      </Router>
    </main>
  );
}

export default App;
