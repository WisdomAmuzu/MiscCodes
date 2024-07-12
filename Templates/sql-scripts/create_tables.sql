-- CREATE USER user WITH ENCRYPTED PASSWORD 'pass';

GRANT ALL PRIVILEGES ON DATABASE dbname TO user;

CREATE TYPE TRANSTATUS as ENUM ('paid', 'pending', 'reversed', 'cancelled');
CREATE TYPE REVERSALSTATUS as ENUM ('pending', 'reversed');
CREATE TYPE USERGROUP as ENUM ('ADMIN', 'SUPERVISOR', 'TELLER', 'REPORTER', 'USER_MANAGER' ); -- Reporters can access reports only
CREATE TYPE USERSTATUS as ENUM ('Active', 'Not Active');
-- ++++++++++++++++++++++++++++++
-- TABLES
-- ++++++++++++++++++++++++++++++
-- branches
-- chargedetails
-- charges
-- institutions
-- logins
-- payments
-- paymenttype
-- receipts
-- reversals
-- users
-- +++++++++++++++++++++++++++++
-- autdittrail
-- personal_access_tokens
-- +++++++++++++++++++++++++++++

CREATE TABLE IF NOT EXISTS branches (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) UNIQUE NOT NULL,
	branchCode VARCHAR(5),
	sortCode VARCHAR(6),
	suspAccNo VARCHAR(50),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS chargedetails (
	id SERIAL PRIMARY KEY NOT NULL,
	payment VARCHAR(17),
	charge INT,
	amount NUMERIC(10,2) NOT NULL CHECK (amount >= 0),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS charges (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(300) UNIQUE,
	institution INT,
	paymenttype INT,
	amount NUMERIC(10,2) NOT NULL CHECK (amount >= 0),
	mandatory BIT(1),
	sAHCFee BIT(1),
	rank INT,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS institutions (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) UNIQUE,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS logins (
	id SERIAL PRIMARY KEY NOT NULL,
	"user" INT,
	ipaddress VARCHAR(50),
	computername VARCHAR(50),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP	
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS payments (
	id		SERIAL PRIMARY KEY NOT NULL,
	referenceNo VARCHAR(17) UNIQUE NOT NULL,
	accountNo VARCHAR(50),
	suspaccno VARCHAR(50),
	branch INT,
	institution INT,
	paymentmethod VARCHAR(20),
	paymenttype INT,
	teller INT,
	passportNo VARCHAR(100),
	surname VARCHAR(100),
	othernames VARCHAR(100),
	customerPhoneNo VARCHAR(15),
	customerEmail VARCHAR(50),
	description TEXT,
	amount NUMERIC(10,2) NOT NULL CHECK (amount >= 0),
	status tranStatus,
	created_at TIMESTAMP DEFAULT current_timestamp,
	updated_at TIMESTAMP DEFAULT current_timestamp,
	request TEXT,
	bbIdentifier VARCHAR(80),
	bbStatus VARCHAR(50),
	bbResponse TEXT
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS paymenttypes (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) UNIQUE,
	institution INT,
	accountno VARCHAR(50),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS receipts (
	id SERIAL PRIMARY KEY NOT NULL,
	number VARCHAR(20) UNIQUE NOT NULL,
	payment VARCHAR(17) UNIQUE NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS reversals (
	id SERIAL PRIMARY KEY NOT NULL,
	referenceNo VARCHAR(17) UNIQUE NOT NULL,
	payment VARCHAR(17) UNIQUE NOT NULL,
	description TEXT,
	status reversalstatus,
	reason TEXT,
	bbStatus VARCHAR(50),
	bbIdentifier VARCHAR(80),
	bbResponse TEXT,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS users (
	id SERIAL PRIMARY KEY,
	lastTranDate TIMESTAMP,
	username VARCHAR(50) UNIQUE,
	lastlogin TIMESTAMP DEFAULT current_timestamp,
	userGroup userGroup,
	fullName VARCHAR(100),
	status userStatus DEFAULT 'Active',
	branch INT,
	initials VARCHAR(5),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS audittrail (
    id SERIAL PRIMARY KEY NOT NULL,
	tranID INT ,
	processDate DATE DEfAULT current_date,
	processTime TIME DEFAULT current_time,
	moduleName VARCHAR(50),
	userAction CHAR,
	userCode INT,
	remarks TEXT,
	trailType VARCHAR(50),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------

CREATE TABLE IF NOT EXISTS personal_access_tokens (
    id SERIAL PRIMARY KEY NOT NULL,
    tokenable_type VARCHAR(255) NOT NULL,
    tokenable_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    token VARCHAR(64) NOT NULL UNIQUE,
    abilities TEXT NULL,
    last_used_at TIMESTAMP NULL,
    expires_at TIMESTAMP NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-------------------------------------------------------------



ALTER TABLE users
ADD CONSTRAINT fk_user_branch
FOREIGN KEY (branch)
REFERENCES branches (id)
ON DELETE SET NULL;

ALTER TABLE payments
ADD CONSTRAINT fk_payment_teller
FOREIGN KEY (teller)
REFERENCES users (id)
ON DELETE SET NULL;

ALTER TABLE payments
ADD CONSTRAINT fk_payment_institution
FOREIGN KEY (institution)
REFERENCES institutions (id)
ON DELETE SET NULL;

ALTER TABLE payments
ADD CONSTRAINT	fk_payment_type
FOREIGN KEY (paymenttype)
REFERENCES paymenttypeS (id)
ON DELETE SET NULL;

ALTER TABLE payments
ADD CONSTRAINT fk_payment_branch
FOREIGN KEY (branch)
REFERENCES branches (id)
ON DELETE SET NULL;

ALTER TABLE reversals
ADD CONSTRAINT fk_reversal_payment
FOREIGN KEY (payment)
REFERENCES payments (referenceno)
ON DELETE SET NULL;

ALTER TABLE receipts
ADD CONSTRAINT fk_payment_receipt
FOREIGN KEY	(payment)
REFERENCES payments (referenceno)
ON DELETE SET NULL;

ALTER TABLE charges
ADD CONSTRAINT fk_institution_charges
FOREIGN KEY (institution)
REFERENCES institutions (id)
ON DELETE SET NULL;

ALTER TABLE charges
ADD CONSTRAINT fk_charges_paymenttype
FOREIGN KEY (paymenttype)
REFERENCES paymenttypes (id)
ON DELETE SET NULL;

ALTER TABLE chargedetails
ADD CONSTRAINT fk_chargedetail_payment
FOREIGN KEY (payment)
REFERENCES payments (referenceno)
ON DELETE SET NULL;

ALTER TABLE chargedetails
ADD CONSTRAINT fk_chargedet_ptype
FOREIGN KEY (charge)
REFERENCES charges (id)
ON DELETE SET NULL;

ALTER TABLE logins
ADD CONSTRAINT fk_user_login
FOREIGN KEY ("user")
REFERENCES users (id)
ON DELETE SET NULL;

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO user;

GRANT USAGE, SELECT, UPDATE ON SEQUENCE branches_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE charges_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE chargedetails_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE institutions_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE logins_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE payments_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE personal_access_tokens_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE reversals_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE users_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE receipts_id_seq TO user;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE paymenttypes_id_seq TO user;

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE users TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE branches TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE institutions TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE paymenttypes TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE payments TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE reversals TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE receipts TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE charges TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE chargedetails TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE audittrail TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE personal_access_tokens TO vfs;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE logins TO vfs;


