-- Create table for Pokemon
CREATE TABLE IF NOT EXISTS Pokemon (
    id SMALLSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    feeding VARCHAR(50) NOT NULL,
    size VARCHAR(50) NOT NULL,
    weight VARCHAR(50) NOT NULL,
    rarity VARCHAR(50) NOT NULL,
    fun_fact VARCHAR(250) NOT NULL
);

-- Insert data into the table
-- Pikachu
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Pikachu', 'Eléctrico', 'Omnívoro', 'Pequeño', '6.0 kg', 'Común', 'Siempre tiene energía estática en su cuerpo');

-- Bulbasaur
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Bulbasaur', 'Planta/Veneno', 'Herbívoro', 'Pequeño', '6.9 kg', 'Común', 'El bulbo en su espalda puede absorber nutrientes del sol');

-- Charmander
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Charmander', 'Fuego', 'Carnívoro', 'Pequeño', '8.5 kg', 'Común', 'La llama en su cola indica su estado emocional');

-- Squirtle
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Squirtle', 'Agua', 'Carnívoro', 'Pequeño', '9.0 kg', 'Común', 'Puede disparar agua a alta presión desde su boca');

-- Jigglypuff
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Jigglypuff', 'Normal/Hada', 'Herbívoro', 'Pequeño', '5.5 kg', 'Común', 'Canta una canción de cuna que hace dormir a quien la escucha');

-- Meowth
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Meowth', 'Normal', 'Carnívoro', 'Pequeño', '4.2 kg', 'Común', 'Le encantan las monedas brillantes');

-- Psyduck
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Psyduck', 'Agua', 'Omnívoro', 'Pequeño', '19.6 kg', 'Común', 'Siempre tiene dolor de cabeza');

-- Machop
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Machop', 'Lucha', 'Carnívoro', 'Mediano', '19.5 kg', 'Poco Común', 'Entrena levantando rocas');

-- Abra
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Abra', 'Psíquico', 'Carnívoro', 'Pequeño', '19.5 kg', 'Poco Común', 'Puede leer la mente de otros');

-- Gastly
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Gastly', 'Fantasma/Veneno', 'Carnívoro', 'Pequeño', '0.1 kg', 'Poco Común', 'Está compuesto por gases venenosos');

-- Onix
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Onix', 'Roca/Tierra', 'Herbívoro', 'Grande', '210.0 kg', 'Poco Común', 'Vive en cuevas subterráneas');

-- Drowzee
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Drowzee', 'Psíquico', 'Omnívoro', 'Mediano', '32.4 kg', 'Poco Común', 'Se alimenta de los sueños de las personas');

-- Exeggcute
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Exeggcute', 'Planta/Psíquico', 'Herbívoro', 'Pequeño', '2.5 kg', 'Poco Común', 'Consiste en seis huevos de semillas');

-- Koffing
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Koffing', 'Veneno', 'Carnívoro', 'Pequeño', '1.0 kg', 'Poco Común', 'Se infla para aumentar su tamaño');

-- Cubone
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Cubone', 'Tierra', 'Carnívoro', 'Pequeño', '6.5 kg', 'Poco Común', 'Lleva una calavera de su madre fallecida');

-- Snorlax
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Snorlax', 'Normal', 'Herbívoro', 'Grande', '460.0 kg', 'Raro', 'Puede dormir durante días seguidos');

-- Jynx
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Jynx', 'Hielo/Psíquico', 'Carnívoro', 'Mediano', '40.6 kg', 'Raro', 'Su baile hipnotiza a sus oponentes');

-- Lapras
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Lapras', 'Agua/Hielo', 'Herbívoro', 'Grande', '220.0 kg', 'Raro', 'Es conocido por su dulce canto');

-- Dragonite
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Dragonite', 'Dragón/Volador', 'Carnívoro', 'Grande', '210.0 kg', 'Raro', 'Puede volar a grandes velocidades');

-- Mewtwo
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Mewtwo', 'Psíquico', 'Carnívoro', 'Mediano', '122.0 kg', 'Legendario', 'Fue creado artificialmente en un laboratorio');

-- Mew
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Mew', 'Psíquico', 'Omnívoro', 'Pequeño', '4.0 kg', 'Legendario', 'Contiene el ADN de todos los Pokémon');

-- Zapdos
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Zapdos', 'Eléctrico/Volador', 'Carnívoro', 'Grande', '52.6 kg', 'Legendario', 'Su cuerpo genera electricidad estática');

-- Moltres
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Moltres', 'Fuego/Volador', 'Carnívoro', 'Grande', '60.0 kg', 'Legendario', 'Tiene la habilidad de controlar el fuego');

-- Articuno
INSERT INTO Pokemon (name, type, feeding, size, weight, rarity, fun_fact)
VALUES ('Articuno', 'Hielo/Volador', 'Carnívoro', 'Grande', '55.4 kg', 'Legendario', 'Puede congelar el aire a su alrededor');
