-- ==========================================
-- DATABASE: Online Comic/Novel Reading App
-- SQL Server Compatible
-- ==========================================

USE master;
GO

-- Xóa cơ sở dữ liệu nếu tồn tại
IF EXISTS (SELECT * FROM sys.databases WHERE name = 'OnlineComicApp')
    DROP DATABASE OnlineComicApp;
GO

-- Tạo lại cơ sở dữ liệu
CREATE DATABASE OnlineComicApp;
GO

USE OnlineComicApp;
GO

-- Bảng người dùng
CREATE TABLE users (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(50) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    email NVARCHAR(100) NOT NULL UNIQUE,
    created_at DATETIME DEFAULT GETDATE()
);

-- Bảng role
CREATE TABLE roles (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    role_name NVARCHAR(50) NOT NULL UNIQUE
);

-- Bảng trung gian user_roles (many-to-many)
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Bảng danh mục truyện
CREATE TABLE categories (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL UNIQUE,
    description NVARCHAR(MAX)
);

-- Bảng thể loại
CREATE TABLE genres (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL UNIQUE
);

-- Bảng truyện
CREATE TABLE stories (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    title NVARCHAR(255) NOT NULL,
    description NVARCHAR(MAX),
    author NVARCHAR(100),
    status NVARCHAR(20) CHECK (status IN ('ongoing','completed')) DEFAULT 'ongoing',
    created_at DATETIME DEFAULT GETDATE(),
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
);

-- Bảng nối truyện – thể loại (many-to-many)
CREATE TABLE story_genres (
    story_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (story_id, genre_id),
    FOREIGN KEY (story_id) REFERENCES stories(id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE
);

-- Bảng chương
CREATE TABLE chapters (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    story_id BIGINT NOT NULL,
    chapter_number INT NOT NULL,
    title NVARCHAR(255),
    content NVARCHAR(MAX),
    created_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (story_id) REFERENCES stories(id) ON DELETE CASCADE
);

-- Bảng bình luận
CREATE TABLE comments (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    user_id BIGINT NOT NULL,
    story_id BIGINT NOT NULL,
    content NVARCHAR(MAX) NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (story_id) REFERENCES stories(id) ON DELETE CASCADE
);

-- Bảng đánh giá truyện (rating)
CREATE TABLE ratings (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    user_id BIGINT NOT NULL,
    story_id BIGINT NOT NULL,
    rating INT CHECK(rating >= 1 AND rating <= 5),
    created_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (story_id) REFERENCES stories(id) ON DELETE CASCADE,
    CONSTRAINT uq_user_story UNIQUE(user_id, story_id) -- mỗi user chỉ được đánh giá 1 lần/1 truyện
);

-- Bảng lưu truyện yêu thích
CREATE TABLE favorites (
    user_id BIGINT NOT NULL,
    story_id BIGINT NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    PRIMARY KEY (user_id, story_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (story_id) REFERENCES stories(id) ON DELETE CASCADE
);

-- Bảng đánh dấu chương đã đọc
CREATE TABLE read_chapters (
    user_id BIGINT NOT NULL,
    chapter_id BIGINT NOT NULL,
    read_at DATETIME DEFAULT GETDATE(),
    PRIMARY KEY (user_id, chapter_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (chapter_id) REFERENCES chapters(id) ON DELETE CASCADE
);
