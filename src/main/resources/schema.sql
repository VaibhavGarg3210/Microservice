CREATE TABLE IF NOT EXISTS `CUSTOMER` (
`customer_id` int AUTO_INCREMENT PRIMARY KEY,
`name` varchar(100) NOT NULL,
`email` varchar(100) NOT NULL,
`mobile_number` varchar(20) NOT NULL,
`created_at` date  NULL,
`created_by` varchar(100)  NULL,
`updated_at` date  NULL,
`updated_by` varchar(100)  NULL
);

CREATE TABLE IF NOT EXISTS `ACCOUNTS` (
`customer_id` int AUTO_INCREMENT PRIMARY KEY,
`ac_name` varchar(100)  NULL,
`ac_number` int AUTO_INCREMENT NOT NULL,
`ac_type` varchar(100) NOT NULL,
`branch_add` varchar(200) NOT NULL,
`created_at` date  NULL,
`created_by` varchar(100)  NULL,
`updated_at` date  NULL,
`updated_by` varchar(100)  NULL
);
