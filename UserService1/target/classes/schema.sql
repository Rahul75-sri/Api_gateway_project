CREATE TABLE IF NOT EXISTS micro_users (
    id CHAR(36) PRIMARY KEY,                    -- Changed from 'Id' to 'id'
    name VARCHAR(255) NOT NULL,                 -- Changed from 'Name' to 'name'
    email VARCHAR(255) NOT NULL,                -- Changed from 'Email' to 'email'
    about TEXT,                                 -- Changed from 'About' to 'about'
    created_at TIMESTAMP(3) DEFAULT CURRENT_TIMESTAMP(3),
    updated_at TIMESTAMP(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT uk_micro_users_email UNIQUE (email),  -- Updated constraint reference
    INDEX idx_micro_users_name (name),               -- Updated index reference
    INDEX idx_micro_users_active_created (is_active, created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS api_keys (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id CHAR(36),
    api_key VARCHAR(255) UNIQUE NOT NULL,
    key_name VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (user_id) REFERENCES micro_users(id)
);
