INSERT INTO appusers (username, password,email) VALUES
('john_doe', 'password123','johndoe@gmail.com'),
('jane_doe', 'password456','janedoe@gmail.com'),
('alice_smith', 'password789','alicesmith@gmail.com');


INSERT INTO accounts (quantity, account_type, connection, user_id) VALUES
(1000.50, 'CASH', 'Bank Account', 1),
(5000.00, 'CREDIT', 'Credit Card', 1),
(200.00, 'CASH', 'Wallet', 2),
(1500.00, 'LOANS_AND_MORTGAGE', 'Mortgage', 3);


INSERT INTO expenses (name, assigned, target,expense_type, target_is_reached, user_id) VALUES
('Monthly Groceries', 300.00, 500.00,'BILLS' ,false, 1),
('Electricity Bill', 100.00, 150.00,'NEEDS',false, 1),
('Netflix Subscription', 15.00, 15.00,'WANTS' ,true, 2),
('Gasoline', 50.00, 100.00,'SAVINGS' ,false, 3);

INSERT INTO transactions (amount, money_flow, description, account_id) VALUES
(200.00, 'INCOME', 'Salary', 1),
(50.00, 'EXPENSE', 'Groceries', 1),
(100.00, 'INCOME', 'Freelance Work', 2),
(30.00, 'EXPENSE', 'Electricity Bill', 2),
(15.00, 'EXPENSE', 'Netflix Subscription', 3),
(20.00, 'EXPENSE', 'Gasoline', 4);