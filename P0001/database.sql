USE [master]
GO
/****** Object:  Database [LAB221_P1]    Script Date: 28-Sep-20 5:07:29 PM ******/
CREATE DATABASE [LAB221_P1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'LAB221_P1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.NATTON\MSSQL\DATA\LAB221_P1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'LAB221_P1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.NATTON\MSSQL\DATA\LAB221_P1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [LAB221_P1] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [LAB221_P1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [LAB221_P1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [LAB221_P1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [LAB221_P1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [LAB221_P1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [LAB221_P1] SET ARITHABORT OFF 
GO
ALTER DATABASE [LAB221_P1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [LAB221_P1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [LAB221_P1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [LAB221_P1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [LAB221_P1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [LAB221_P1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [LAB221_P1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [LAB221_P1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [LAB221_P1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [LAB221_P1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [LAB221_P1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [LAB221_P1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [LAB221_P1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [LAB221_P1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [LAB221_P1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [LAB221_P1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [LAB221_P1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [LAB221_P1] SET RECOVERY FULL 
GO
ALTER DATABASE [LAB221_P1] SET  MULTI_USER 
GO
ALTER DATABASE [LAB221_P1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [LAB221_P1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [LAB221_P1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [LAB221_P1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [LAB221_P1] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'LAB221_P1', N'ON'
GO
ALTER DATABASE [LAB221_P1] SET QUERY_STORE = OFF
GO
USE [LAB221_P1]
GO
/****** Object:  Table [dbo].[tblItems]    Script Date: 28-Sep-20 5:07:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblItems](
	[itemCode] [varchar](10) NOT NULL,
	[itemName] [nvarchar](50) NULL,
	[unit] [varchar](50) NULL,
	[price] [float] NULL,
	[supplying] [bit] NULL,
	[supCode] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[itemCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblSuppliers]    Script Date: 28-Sep-20 5:07:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSuppliers](
	[supCode] [varchar](10) NOT NULL,
	[supName] [nvarchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[collaborating] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[supCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 28-Sep-20 5:07:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [varchar](50) NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'S1', N'Ngữ văn 12', N'1000', 13000, 1, N'S3')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'S2', N'Shin Cậu bé bút chì', N'1000', 19000, 1, N'S1')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'S3', N'Ngữ văn 12', N'1000', 13000, 0, N'S3')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'S4', N'Đắc Nhân Tâm', N'1000', 40000, 1, N'S4')
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'S1', N'Kim Đồng', N'55 Quang Trung, Hai Ba Trung, Ha Noi', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'S2', N'Trẻ', N'161B Lý Chính Thắng, Quận 3, TPHCM', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'S3', N'Tổng hợp thành phố Hồ Chí Minh', N'62 Nguyễn Thị Minh Khai, Quận 1, TPHCM', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'S4', N'Chính trị Quốc gia Sự thật', N'24 Quang Trung, Hoàn Kiếm, Hà Nội', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'S5', N'Giáo dục', N'81 Trần Hưng Đạo, Hà Nội', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'S6', N'First News', N'11I-H, Nguyễn Thị Minh Khai,  Quận 1, TPHCM', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'Admin', N'admin', N'Admin', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'admin', N'admin', N'admin', 0)
ALTER TABLE [dbo].[tblItems]  WITH CHECK ADD FOREIGN KEY([supCode])
REFERENCES [dbo].[tblSuppliers] ([supCode])
GO
USE [master]
GO
ALTER DATABASE [LAB221_P1] SET  READ_WRITE 
GO
