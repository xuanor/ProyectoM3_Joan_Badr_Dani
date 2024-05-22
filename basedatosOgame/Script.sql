

--······························    CREAR TABLAS    ······························--

--CREAR TABLA DE CREDENCIALES DE USUARIOS
CREATE TABLE user_credentials (
    user_id NUMBER PRIMARY key not NULL,
    user_password VARCHAR2(50),
    user_name VARCHAR(15)
);

--CREAR TABLA DE ESTADISTICAS DE LOS PLANETAS
CREATE TABLE planet_stats (
    user_id NUMBER,
    planet_id NUMBER PRIMARY KEY NOT NULL,
    planet_name VARCHAR2(50),
    resource_metal_amount NUMBER,
    resource_dauterion_amount NUMBER,
    resource_defense NUMBER,
    resource_attack NUMBER,
    battle_counter NUMBER,
    missile_launcher_remaining NUMBER,
    ion_cannon_remaining NUMBER,
    plasma_cannon_remaining NUMBER,
    light_hunter_remaining NUMBER,
    heavy_hunter_remaining NUMBER,
    battle_ship_remaining NUMBER,
    armored_ship_remaining NUMBER,
    FOREIGN KEY (user_id) REFERENCES user_credentials(user_id)
);


--CREAR TABLA LighHunters
CREATE TABLE light_hunter (
    planet_id NUMBER PRIMARY KEY NOT NULL,
    armour NUMBER,
    atack NUMBER,
    FOREIGN KEY (planet_id) REFERENCES planet_stats(planet_id)
);

--CREAR TABLA heavy_hunters
CREATE TABLE heavy_hunter (
    planet_id NUMBER PRIMARY KEY NOT NULL,
    armour NUMBER,
    atack NUMBER,
    FOREIGN KEY (planet_id) REFERENCES planet_stats(planet_id)
);

--CREAR TABLA battle_ship
CREATE TABLE battle_ship (
    planet_id NUMBER PRIMARY KEY NOT NULL,
    armour NUMBER,
    atack NUMBER,
    FOREIGN KEY (planet_id) REFERENCES planet_stats(planet_id)
);

--CREAR TABLA armored_ship
CREATE TABLE armored_ship (
    planet_id NUMBER PRIMARY KEY NOT NULL,
    armour NUMBER,
    atack NUMBER,
    FOREIGN KEY (planet_id) REFERENCES planet_stats(planet_id)
);

--CREAR TABLA ion_cannon
CREATE TABLE ion_cannon (
    planet_id NUMBER PRIMARY KEY NOT NULL,
    armour NUMBER,
    atack NUMBER,
    FOREIGN KEY (planet_id) REFERENCES planet_stats(planet_id)
);

--CREAR TABLA battle_ship
CREATE TABLE missile_launcher (
    planet_id NUMBER PRIMARY KEY NOT NULL,
    armour NUMBER,
    atack NUMBER,
    FOREIGN KEY (planet_id) REFERENCES planet_stats(planet_id)
);

--CREAR TABLA battle_ship
CREATE TABLE battle_ship (
    planet_id NUMBER PRIMARY KEY NOT NULL,
    armour NUMBER,
    atack NUMBER,
    FOREIGN KEY (planet_id) REFERENCES planet_stats(planet_id)
);

--CREAR TABLA DE ESTADISTICAS DE LAS BATALLAS
CREATE TABLE battle(
    planet_id NUMBER,
    num_battles NUMBER PRIMARY KEY NOT NULL,
    battle_stats VARCHAR2(50),
    battle_log VARCHAR2(50),
    FOREIGN KEY (planet_id) REFERENCES planet_stats(planet_id)
);


--······························    INSERTAR DATOS    ······························--

--INSERTAR DATOS EN LA TABLA user_credentials
INSERT INTO user_credentials (
    user_id,
    user_password,
    user_name
)
VALUES (
    1,
    'ogame',
    'ogame'
);

--INSERTAR DATOS EN LA TABLA planet_stats 
INSERT INTO planet_stats (
    user_id ,
    planet_id ,
    planet_name ,
    resource_metal_amount ,
    resource_dauterion_amount ,
    resource_defense ,
    resource_attack ,
    battle_counter ,
    missile_launcher_remaining ,
    ion_cannon_remaining ,
    plasma_cannon_remaining ,
    light_hunter_remaining ,
    heavy_hunter_remaining ,
    battle_ship_remaining ,
    armored_ship_remaining
)
VALUES (
    (SELECT user_id FROM user_credentials),
    1,
    'PlanetaPrueba',
    10000,
    10000,
    0,
    0,
    0,
    10,
    10,
    10,
    100,
    10000,
    10,
    12
);

--INSERTAR DATOS EN LA TABLA battle_stats
INSERT INTO battle (
    planet_id,
    num_battles,
    battle_stats,
    battle_log
)
VALUES (
    (SELECT planet_id FROM planet_stats),
    1,
    "estadisticas batalla",
    "batalla paso a paso"
);

/*
UPDATE planet_stats
SET
    resource_metal_amount = 180000,
    resource_dauterion_amount = 26000,
    resource_defense = 0,
    resource_attack = 0,
    battle_counter = 0,
    missile_launcher_remaining = 10,
    ion_cannon_remaining = 2,
    plasma_cannon_remaining = 0,
    light_hunter_remaining = 15,
    heavy_hunter_remaining = 5,
    battle_ship_remaining = 0,
    armored_ship_remaining = 1;
*/