import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import "./Userregister.css";



function UserLogin(){

    const [credentials, setCredentials] = useState({username:"",password:""});
    const [message, setMessage] = useState(null);
    const navigate = useNavigate();
    

    async function handleSubmit(event){
        event.preventDefault()
        try {
            
            const response = await fetch("login", {
              headers: { "Content-Type": "application/json" },
              method: "POST",
              body: JSON.stringify(credentials),
            });
            const data = await response.json();
        
            if (!response.ok) {
              throw new Error(data.message || "Error en la solicitud.");
            }
        
            setMessage(data.message || "Registro exitoso");
            navigate('/budget', { replace: true });
          } catch (error) {
            setMessage(error.message || "Ocurrió un error inesperado");
          }           


    }

    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setCredentials(values => ({...values, [name]: value}))
    }

    return(
        <div className="form-container">
            <h1 align-items="center">User Login</h1>
            <form className = "form" onSubmit={handleSubmit}>
                {message && <p>{message}</p>}
                <label className="form-input">Enter your username:
                    <input 
                    type="text" 
                    name="username" 
                    value={credentials.username} 
                    onChange={handleChange}
                    required
                    />
                </label>
                <label className="form-input">Enter your password:
                    <input 
                    type="password" 
                    name="password" 
                    value={credentials.password} 
                    onChange={handleChange}
                    required
                    />
                </label>
                <button className="input" type="submit" value="Submit">Submit</button>
            </form>
        </div>

    )

}
export default UserLogin;