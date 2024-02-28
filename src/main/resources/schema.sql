CREATE TABLE IF NOT EXISTS Pokemon (
    id SMALLSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    feeding VARCHAR(50) NOT NULL,
    size VARCHAR(50) NOT NULL,
    weight VARCHAR(50) NOT NULL,
    rarity VARCHAR(50) NOT NULL,
    fun_fact VARCHAR(250) NOT NULL,
    enabled boolean DEFAULT true,
    last_modified_date timestamp not null default current_timestamp,
    created_date timestamp not null default current_timestamp
);