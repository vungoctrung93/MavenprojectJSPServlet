IF NOT EXISTS(
	SELECT *
	FROM sys.databases
	WHERE name = 'EmployeeManagement'
) BEGIN CREATE DATABASE [EmployeeManagement]
END
GO USE [EmployeeManagement]
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO CREATE TABLE [dbo].[Users](
		[username] [nchar](50) NOT NULL,
		[fullname] [nchar](255) NOT NULL,
		[email] [nchar](255) NULL,
		[psword] [nchar](255) NOT NULL,
		CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED ([username] ASC) WITH (
			PAD_INDEX = OFF,
			STATISTICS_NORECOMPUTE = OFF,
			IGNORE_DUP_KEY = OFF,
			ALLOW_ROW_LOCKS = ON,
			ALLOW_PAGE_LOCKS = ON
		) ON [PRIMARY]
	) ON [PRIMARY]
GO