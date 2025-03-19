IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[api_weather]') AND type in (N'U'))
DROP TABLE [dbo].[api_weather]
GO

/****** Object:  Table [dbo].[api_weather]    Script Date: 19/3/2025 09:59:24 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[api_weather](
	[latitude] [float] NOT NULL,
	[longitude] [float] NOT NULL,
	[interval_current_weather] [int] NULL,
	[is_day_current_weather] [int] NULL,
	[temperature_current_weather] [float] NULL,
	[time_current_weather] [varchar](255) NULL,
	[weather_code_current_weather] [int] NULL,
	[wind_direction_current_weather] [int] NULL,
	[wind_speed_current_weather] [float] NULL,
	[interval_current_weather_units] [varchar](255) NULL,
	[is_day_current_weather_units] [varchar](255) NULL,
	[temperature_current_weather_units] [varchar](255) NULL,
	[time_current_weather_units] [varchar](255) NULL,
	[weather_code_current_weather_units] [varchar](255) NULL,
	[wind_direction_current_weather_units] [varchar](255) NULL,
	[wind_speed_current_weather_units] [varchar](255) NULL,
	[elevation] [float] NOT NULL,
	[generation_time_ms] [float] NOT NULL,
	[timezone] [varchar](255) NULL,
	[timezone_abbreviation] [varchar](255) NULL,
	[utc_offset_seconds] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[latitude] ASC,
	[longitude] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[usuarios]    Script Date: 19/3/2025 10:00:55 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[usuarios]') AND type in (N'U'))
DROP TABLE [dbo].[usuarios]
GO

/****** Object:  Table [dbo].[usuarios]    Script Date: 19/3/2025 10:00:55 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[usuarios](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[apellido] [varchar](255) NULL,
	[celular] [varchar](255) NULL,
	[ciudad] [varchar](255) NULL,
	[latitud] [float] NULL,
	[longitud] [float] NULL,
	[email] [varchar](255) NULL,
	[fecha_nacimiento] [date] NULL,
	[genero] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[username] [varchar](255) NULL,
	[nombre] [varchar](255) NULL,
	[pais] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
