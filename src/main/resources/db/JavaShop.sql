CREATE DATABASE PolyShop
USE [PolyShop]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 8/9/2022 5:03:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Image] [nvarchar](50) NULL,
	[Available] [bit] NOT NULL,
	[Address] [nvarchar](50) NULL,
	[Phone] [nvarchar](20) NULL,
	[fullname] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Authorities]    Script Date: 8/9/2022 5:03:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Authorities](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[RoleId] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 8/9/2022 5:03:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [nvarchar](20) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 8/9/2022 5:03:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ProductId] [int] NOT NULL,
	[OrderId] [int] NOT NULL,
	[Price] [float] NOT NULL,
	[Quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 8/9/2022 5:03:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CreateDate] [date] NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Available] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 8/9/2022 5:03:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Image] [nvarchar](50) NULL,
	[Price] [float] NULL,
	[NewPrice] [float] NULL,
	[CreateDate] [date] NULL,
	[CategoryId] [nvarchar](20) NOT NULL,
	[Available] [bit] NOT NULL,
	[Quantity] [int] NULL,
	[DaMua] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 8/9/2022 5:03:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[Id] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Accounts] ([Username], [Password], [Email], [Image], [Available], [Address], [Phone], [fullname]) VALUES (N'admin', N'123', N'admin@gmail.com', N'admin.png', 1, N'240/35', N'0765230162', N'Huy')
INSERT [dbo].[Accounts] ([Username], [Password], [Email], [Image], [Available], [Address], [Phone], [fullname]) VALUES (N'guest1', N'123', N'guest1@gmail.com', N'83bf2398.png', 1, N'240/35', N'0765230162', N'Lee')
INSERT [dbo].[Accounts] ([Username], [Password], [Email], [Image], [Available], [Address], [Phone], [fullname]) VALUES (N'guest2', N'123', N'guest2@gmail.com', N'fccda90b.png', 1, N'240/35', N'0765230162', N'Hoang')
INSERT [dbo].[Accounts] ([Username], [Password], [Email], [Image], [Available], [Address], [Phone], [fullname]) VALUES (N'staff', N'123', N'staff@gmail.com', N'staff.png', 1, N'240/35', N'0765230162', N'Tran')
INSERT [dbo].[Accounts] ([Username], [Password], [Email], [Image], [Available], [Address], [Phone], [fullname]) VALUES (N'Test1', N'123', N'H@g.c', N'c1623fab.png', 0, NULL, NULL, N'Huy')
INSERT [dbo].[Accounts] ([Username], [Password], [Email], [Image], [Available], [Address], [Phone], [fullname]) VALUES (N'user1', N'123', N'user1@gmail.com', N'user1.png', 1, N'240/35', N'0765230162', N'Thao')
INSERT [dbo].[Accounts] ([Username], [Password], [Email], [Image], [Available], [Address], [Phone], [fullname]) VALUES (N'user2', N'123', N'user2@gmail.com', N'ef21ead0.png', 1, N'240/35', N'0765230162', N'Tai')
GO
SET IDENTITY_INSERT [dbo].[Authorities] ON 

INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (1, N'admin', N'ADMIN')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (7, N'staff', N'STAFF')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (15, N'user1', N'USER')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (16, N'guest2', N'GUEST')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (17, N'Test1', N'USER')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (18, N'guest1', N'GUEST')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (19, N'user2', N'USER')
SET IDENTITY_INSERT [dbo].[Authorities] OFF
GO
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (N'AO_01', N'T-Shirt')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (N'AO_02', N'Shirt')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (N'AOKHOAC_01', N'Jacket')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (N'AOKHOAC_02', N'Hoodie')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (N'QUAN_01', N'Pants')
GO
SET IDENTITY_INSERT [dbo].[OrderDetails] ON 

INSERT [dbo].[OrderDetails] ([Id], [ProductId], [OrderId], [Price], [Quantity]) VALUES (1, 5, 2, 10000, 1)
INSERT [dbo].[OrderDetails] ([Id], [ProductId], [OrderId], [Price], [Quantity]) VALUES (2, 8, 2, 20000, 2)
INSERT [dbo].[OrderDetails] ([Id], [ProductId], [OrderId], [Price], [Quantity]) VALUES (3, 8, 3, 20000, 4)
INSERT [dbo].[OrderDetails] ([Id], [ProductId], [OrderId], [Price], [Quantity]) VALUES (4, 5, 4, 10000, 1)
INSERT [dbo].[OrderDetails] ([Id], [ProductId], [OrderId], [Price], [Quantity]) VALUES (5, 8, 4, 20000, 1)
SET IDENTITY_INSERT [dbo].[OrderDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([Id], [CreateDate], [Address], [Username], [Available]) VALUES (2, CAST(N'2022-06-08' AS Date), N'240/35E', N'admin', 1)
INSERT [dbo].[Orders] ([Id], [CreateDate], [Address], [Username], [Available]) VALUES (3, CAST(N'2022-08-09' AS Date), N'1111', N'staff', 1)
INSERT [dbo].[Orders] ([Id], [CreateDate], [Address], [Username], [Available]) VALUES (4, CAST(N'2022-08-09' AS Date), N'333333333', N'staff', 0)
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([Id], [Name], [Image], [Price], [NewPrice], [CreateDate], [CategoryId], [Available], [Quantity], [DaMua]) VALUES (5, N'Áo thun 1', N'aothun_1.png', 10000, 10000, CAST(N'2022-05-08' AS Date), N'AO_01', 0, 10, 0)
INSERT [dbo].[Products] ([Id], [Name], [Image], [Price], [NewPrice], [CreateDate], [CategoryId], [Available], [Quantity], [DaMua]) VALUES (8, N'Áo thun 2', N'aothun_2.png', 20000, 20000, CAST(N'2022-05-08' AS Date), N'AO_01', 1, 10, 0)
INSERT [dbo].[Products] ([Id], [Name], [Image], [Price], [NewPrice], [CreateDate], [CategoryId], [Available], [Quantity], [DaMua]) VALUES (9, N'Áo khoác 1', N'aothun_1.png', 14000, 14000, CAST(N'2022-05-08' AS Date), N'AOKHOAC_01', 1, 10, 0)
INSERT [dbo].[Products] ([Id], [Name], [Image], [Price], [NewPrice], [CreateDate], [CategoryId], [Available], [Quantity], [DaMua]) VALUES (10, N'Áo khoác 2', N'f6f28481.jpg', 40000, 40000, CAST(N'2022-05-08' AS Date), N'AOKHOAC_01', 1, 10, 0)
INSERT [dbo].[Products] ([Id], [Name], [Image], [Price], [NewPrice], [CreateDate], [CategoryId], [Available], [Quantity], [DaMua]) VALUES (11, N'Áo khoác 3', N'3c2c31ea.jpg', 100000, 100000, CAST(N'2022-05-08' AS Date), N'AOKHOAC_02', 1, 10, 0)
INSERT [dbo].[Products] ([Id], [Name], [Image], [Price], [NewPrice], [CreateDate], [CategoryId], [Available], [Quantity], [DaMua]) VALUES (12, N'Áo khoác 4', N'aothun_1.png', 2000000, 2000000, CAST(N'2022-05-08' AS Date), N'AOKHOAC_02', 1, 10, 0)
INSERT [dbo].[Products] ([Id], [Name], [Image], [Price], [NewPrice], [CreateDate], [CategoryId], [Available], [Quantity], [DaMua]) VALUES (13, N'Áo khoác 5', N'251fc089.jpg', 2000000, 2000000, CAST(N'2022-05-08' AS Date), N'AOKHOAC_02', 1, 10, 0)
INSERT [dbo].[Products] ([Id], [Name], [Image], [Price], [NewPrice], [CreateDate], [CategoryId], [Available], [Quantity], [DaMua]) VALUES (14, N'Áo thun 3', N'aothun_2.png', 20000, 20000, CAST(N'2022-05-08' AS Date), N'AO_01', 1, 10, 0)
INSERT [dbo].[Products] ([Id], [Name], [Image], [Price], [NewPrice], [CreateDate], [CategoryId], [Available], [Quantity], [DaMua]) VALUES (15, N'U1', N'4c5bdc2f.jpg', 1000000, 0, CAST(N'2022-08-09' AS Date), N'QUAN_01', 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
INSERT [dbo].[Roles] ([Id], [name]) VALUES (N'ADMIN', N'Administrators')
INSERT [dbo].[Roles] ([Id], [name]) VALUES (N'GUEST', N'Guest')
INSERT [dbo].[Roles] ([Id], [name]) VALUES (N'STAFF', N'Staff')
INSERT [dbo].[Roles] ([Id], [name]) VALUES (N'USER', N'User')
GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [fk_auth_id_roles] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Roles] ([Id])
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [fk_auth_id_roles]
GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [fk_auth_user_account] FOREIGN KEY([Username])
REFERENCES [dbo].[Accounts] ([Username])
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [fk_auth_user_account]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [fk_orderdetail_id_order] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [fk_orderdetail_id_order]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [fk_orderdetail_id_prod] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [fk_orderdetail_id_prod]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [fk_order_user_acc] FOREIGN KEY([Username])
REFERENCES [dbo].[Accounts] ([Username])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [fk_order_user_acc]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [fk_prod_id_categ] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [fk_prod_id_categ]
GO
