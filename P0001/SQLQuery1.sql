use LAB221_P1;
drop table tblUsers;
create table tblUsers(
	userID varchar(10) COLLATE SQL_Latin1_General_CP1_CS_AS,
	fullName nvarchar(50),
	password varchar(50) COLLATE SQL_Latin1_General_CP1_CS_AS,
	status bit,
	primary key (userId)
);
/*create table tblSuppliers(
	supCode varchar(10) primary key,
	supName nvarchar(50),
	address nvarchar(50),
	collaborating bit
);
create table tblItems(
	itemCode varchar(10) primary key,
	itemName nvarchar(50),
	unit varchar(50),
	price float,
	supplying bit,
	supCode varchar (10) foreign key references tblSuppliers(supCode)
)*/

