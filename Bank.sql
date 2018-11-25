-- "/usr/share/java/mysql.jar:"
drop database bankdb;
create database bankdb;
use bankdb;

create table Employee(
	name varchar(30),
	contact varchar(10),
	salary int,
	address varchar(100),
	type varchar(10),
	employee_id int,
	constraint pk_employee PRIMARY KEY (employee_id)
);

create table ZonalHead(
		zonalhead_id int,
		constraint pk_zonalhead PRIMARY KEY (zonalhead_id)

);

create table  BankManager(
	bankmanager_id int,
	bankmanager_branch_id int,
	constraint pk_bankmanager PRIMARY KEY (	bankmanager_id)

);

create table CrossSellingAgent(
	commission int,
	crossseller_id int,
	crossseller_branch_id int,

	constraint pk_crossseller PRIMARY KEY (crossseller_id)
);


create table CustomerCare(
	customercare_id int,
	customercare_branch_id int,
	constraint pk_customercare PRIMARY KEY (customercare_id)
);

create table Branch(
	name varchar(20),
 	address varchar(30),
	contact varchar(10),
	branch_id int,
	branch_zonalhead_id int,
	branch_manager_id int,
	constraint pk_branch PRIMARY KEY (branch_id)
);


create table Account(
	balance float,
	accountnumber int,
	createddate date,
	account_branch_id int,
	account_customer_id int,

	constraint pk_account PRIMARY KEY (accountnumber)

);

create table  Customer(
	name varchar(10),
	contact varchar(10),
	address varchar(30),
	customer_id int,
	constraint pk_customer PRIMARY KEY (customer_id)
);


create table Insurance(
	deductamount int,
	paymentsremaining int,
	insurance_id int,
	insurance_account_id int,
	insurance_crossseller_id int,
	constraint pk_insurance PRIMARY KEY (insurance_id)
);

create table Transaction(
	transactiondate date,
	type varchar(10),
	transaction_id int,
	amount int,
	transaction_accountnumber int,
	constraint pk_transaction PRIMARY KEY (transaction_id)
);

create table Transfer(
	transfer_transaction_id int,
	transfer_account_id int,

	constraint pk_transfer PRIMARY KEY (transfer_transaction_id)
);

create table Deposit(
	deposit_transaction_id int,
	constraint pk_deposit PRIMARY KEY (deposit_transaction_id)
);

create table Loan(
	loan_id int,
	amount int,
	type varchar(15),
	loan_account_id int,
	loan_manager_id int,
	constraint pk_loan PRIMARY KEY (loan_id)
);

create table LowValueLoan(
	bankmanagerapproval boolean,
	lowvalueloan_id int,
	constraint pk_lowvalueloan PRIMARY KEY (lowvalueloan_id)

);

create table HighValueLoan(
	bankmanagerapproval boolean,
	zonalheadapproval boolean,
	highvalueloan_id int,
	constraint pk_highvalueloan PRIMARY KEY (highvalueloan_id)

);