INSERT INTO appusers (username, password) VALUES
('john_doe', 'password123'),
('jane_doe', 'password456'),
('alice_smith', 'password789');

-- Poblar la tabla accounts
INSERT INTO accounts (quantity, account_type, connection, user_id) VALUES
(1000.50, 'CASH', 'Bank Account', 1),
(5000.00, 'CREDIT', 'Credit Card', 1),
(200.00, 'CASH', 'Wallet', 2),
(1500.00, 'LOANS_AND_MORTGAGE', 'Mortgage', 3);

-- Poblar la tabla categories
INSERT INTO categories (category, user_id) VALUES
('Groceries', 1),
('Utilities', 1),
('Entertainment', 2),
('Transport', 3);

-- Poblar la tabla expenses
INSERT INTO expenses (name, assigned, target, target_is_reached, user_id, category_id) VALUES
('Monthly Groceries', 300.00, 500.00, false, 1, 1),
('Electricity Bill', 100.00, 150.00, false, 1, 2),
('Netflix Subscription', 15.00, 15.00, true, 2, 3),
('Gasoline', 50.00, 100.00, false, 3, 4);

-- Poblar la tabla transactions
INSERT INTO transactions (amount, money_flow, description, account_id) VALUES
(200.00, 'INCOME', 'Salary', 1),
(50.00, 'EXPENSE', 'Groceries', 1),
(100.00, 'INCOME', 'Freelance Work', 2),
(30.00, 'EXPENSE', 'Electricity Bill', 2),
(15.00, 'EXPENSE', 'Netflix Subscription', 3),
(20.00, 'EXPENSE', 'Gasoline', 4);