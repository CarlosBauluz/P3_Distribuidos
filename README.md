# 📝 Práctica 3

## 👥 Integrantes
- 🧑‍💻 **Carlos Bauluz Rodríguez**
- 🧑‍💻 **Álvaro Pereda Sánchez**

## 📦 Versiones
- **Java**: openjdk version "1.8.0_442"

## 📄 Documento de la Práctica

Puedes consultar el documento completo de la práctica en formato PDF [aquí](https://github.com/CarlosBauluz/P3_Distribuidos/blob/main/Practica3.pdf).

## 🚀 Ejecutar la Práctica

Sigue los siguientes pasos para ejecutar la práctica:

### 1️⃣ Compilar los Archivos

Primero, asegúrate de compilar todos los archivos para evitar posibles errores:

```
idlj -fall Biblioteca.idl
javac ServidorBiblioteca.java
javac ClienteBiblioteca.java
```
### 2️⃣ Iniciar las Terminales

Necesitarás **tres terminales** para ejecutar los distintos archivos del programa:

#### 🖥️ Terminal 1: Iniciar el Puerto

Ejecuta el siguiente comando para iniciar el puerto:

```
tnameserv -ORBInitialPort 1050
```
#### 🖥️ Terminal 2: Iniciar el Servidor

En la segunda terminal, inicia el servidor con:

```
java ServidorBiblioteca -ORBInitialHost localhost -ORBInitialPort 1050
```
#### 🖥️ Terminal 3: Iniciar el Cliente

Finalmente, en la tercera terminal, inicia el cliente desde donde se harán todas las peticiones:

```
java ClienteBiblioteca -ORBInitialHost localhost -ORBInitialPort 1050
```
