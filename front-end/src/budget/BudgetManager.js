import { useEffect, useState } from "react";


function BudgetManager(){

    const [expenses,setExpenses] = useState();


    return(
        <div>
            <header className="budget-header">
                <div className="budger-header-to-be-assigned">
                    <span className="budget-header-total-amount">$</span>
                    <p>Ready to be assigned</p>
                    <button className="budget-header-assigned-button"></button>
                </div>
            </header>
            <hr/>
            <body>
                <section className="budget-expense-view">
                    
                </section>
                <section className="budget-expense-statistics">
                    
                </section>
            </body>
        </div>
    );
}

export default BudgetManager;