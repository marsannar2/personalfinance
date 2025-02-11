import { useState } from "react";
import "./Userregister.css";



function Useregister(){

    const [credentials, setCredentials] = useState({username:"",password:"",email:""});
    const [message, setMessage] = useState(null);

    async function handleSubmit(event){
        event.preventDefault()

        try {
            const response = await fetch("signup", {
              headers: { "Content-Type": "application/json" },
              method: "POST",
              body: JSON.stringify(credentials),
            });
            const data = await response.json();
        
            if (!response.ok) {
              throw new Error(data.message || "Error en la solicitud.");
            }
        
            setMessage(data.message || "Registro exitoso");
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
            <h1 align-items="center">User Register</h1>
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
            
                <label className="form-input">Enter your email:
                    <input 
                        type="text"
                        name="email" 
                        value={credentials.email} 
                        onChange={handleChange}
                        required
                    />
                </label>
                <button className="input" type="submit" value="Submit">Submit</button>
            </form>
        </div>

    )

}
export default Useregister;