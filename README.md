# Reto Caja Ica

### RETO POKEMASTER

Solicitamos crear un proyecto backend de API REST que muestre información emulando la Pokedex. La información deberá ser almacenada en una base de datos de tu elección.

### Requisitos
Antes de comenzar, asegúrate de tener instalado lo siguiente:

- Java JDK 17 o superior
- Maven 3.x.x o superior
- IDE de tu preferencia (IntelliJ IDEA, Eclipse, etc.)

### Instalación y Uso
Clona el Repositorio
```bash
git clone https://github.com/Rpeche-pk/caja-ica.git
```
Ir al directorio del proyecto

```bash
  cd caja-ica
```

### Configuración Variables de entorno y Base de datos
El proyecto utiliza una base de datos postgressql usando como proveedor supabase y de forma local , debes de configurar las variables de entorno.

- crea la base de datos usando este comando

```sql
CREATE DATABASE IF NOT EXISTS poke;
```
- Luego ejecuta el script
```sql
CREATE TABLE IF NOT EXISTS pokemon (
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

INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Pikachu', 'Eléctrico', 'Omnívoro', 'Pequeño', '6.0 kg', 'Común', 'Siempre tiene energía estática en su cuerpo',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Bulbasaur', 'Planta/Veneno', 'Herbívoro', 'Pequeño', '6.9 kg', 'Común', 'El bulbo en su espalda puede absorber nutrientes del sol',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Charmander', 'Fuego', 'Carnívoro', 'Pequeño', '8.5 kg', 'Común', 'La llama en su cola indica su estado emocional',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Squirtle', 'Agua', 'Carnívoro', 'Pequeño', '9.0 kg', 'Común', 'Puede disparar agua a alta presión desde su boca',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Jigglypuff', 'Normal/Hada', 'Herbívoro', 'Pequeño', '5.5 kg', 'Común', 'Canta una canción de cuna que hace dormir a quien la escucha',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Meowth', 'Normal', 'Carnívoro', 'Pequeño', '4.2 kg', 'Común', 'Le encantan las monedas brillantes',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Psyduck', 'Agua', 'Omnívoro', 'Pequeño', '19.6 kg', 'Común', 'Siempre tiene dolor de cabeza',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Machop', 'Lucha', 'Carnívoro', 'Mediano', '19.5 kg', 'Poco Común', 'Entrena levantando rocas',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Abra', 'Psíquico', 'Carnívoro', 'Pequeño', '19.5 kg', 'Poco Común', 'Puede leer la mente de otros',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Gastly', 'Fantasma/Veneno', 'Carnívoro', 'Pequeño', '0.1 kg', 'Poco Común', 'Está compuesto por gases venenosos',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Onix', 'Roca/Tierra', 'Herbívoro', 'Grande', '210.0 kg', 'Poco Común', 'Vive en cuevas subterráneas',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Drowzee', 'Psíquico', 'Omnívoro', 'Mediano', '32.4 kg', 'Poco Común', 'Se alimenta de los sueños de las personas',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Exeggcute', 'Planta/Psíquico', 'Herbívoro', 'Pequeño', '2.5 kg', 'Poco Común', 'Consiste en seis huevos de semillas',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Koffing', 'Veneno', 'Carnívoro', 'Pequeño', '1.0 kg', 'Poco Común', 'Se infla para aumentar su tamaño',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Cubone', 'Tierra', 'Carnívoro', 'Pequeño', '6.5 kg', 'Poco Común', 'Lleva una calavera de su madre fallecida',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Snorlax', 'Normal', 'Herbívoro', 'Grande', '460.0 kg', 'Raro', 'Puede dormir durante días seguidos',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Jynx', 'Hielo/Psíquico', 'Carnívoro', 'Mediano', '40.6 kg', 'Raro', 'Su baile hipnotiza a sus oponentes',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Lapras', 'Agua/Hielo', 'Herbívoro', 'Grande', '220.0 kg', 'Raro', 'Es conocido por su dulce canto',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact, enabled)
VALUES ('Dragonite', 'Dragón/Volador', 'Carnívoro', 'Grande', '210.0 kg', 'Raro', 'Puede volar a grandes velocidades',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Mewtwo', 'Psíquico', 'Carnívoro', 'Mediano', '122.0 kg', 'Legendario', 'Fue creado artificialmente en un laboratorio',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Mew', 'Psíquico', 'Omnívoro', 'Pequeño', '4.0 kg', 'Legendario', 'Contiene el ADN de todos los Pokémon',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Zapdos', 'Eléctrico/Volador', 'Carnívoro', 'Grande', '52.6 kg', 'Legendario', 'Su cuerpo genera electricidad estática',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Moltres', 'Fuego/Volador', 'Carnívoro', 'Grande', '60.0 kg', 'Legendario', 'Tiene la habilidad de controlar el fuego',TRUE);
INSERT INTO pokemon (name, type, feeding, size, weight, rarity, fun_fact,enabled)
VALUES ('Articuno', 'Hielo/Volador', 'Carnívoro', 'Grande', '55.4 kg', 'Legendario', 'Puede congelar el aire a su alrededor',TRUE);
```

- Crear un usuario ADMINISTRATOR
```sql
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (name,password,role,username,last_modified_date,created_date)
VALUES ('Caja Ica','$2a$12$l1CCnnyXCLn22cPbCXxHpe2oYevSwtd0lKMDH0MYQQfCMdT1vn2su','ADMINISTRATOR','caja-ica',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
```
- Crea un archivo .env en la raiz del proyecto y coloca estas propiedades
```bash
SERVER_PORT=9896
DATASOURCE_URL=jdbc:postgresql://localhost:5432/poke
DATASOURCE_USERNAME=postgres
DATASOURCE_PASSWORD=root
```

### Compilar y Ejecutar
Puedes compilar y ejecutar el proyecto usando Maven. Desde la raíz del proyecto, ejecuta:

```bash
mvn clean install
```
- Luego, para ejecutar la aplicación:
```bash
mvn spring-boot:run
```

### Despliegue
La api esta desplegado en don web, puedes acceder a la documentación de la api en el siguiente enlace:

[Swagger API](http://149.50.137.89:9896/swagger-ui/index.html)

[DOCUMENTATION API](https://bump.sh/maipevi/doc/cajaica) <- Click para ver la documentación
