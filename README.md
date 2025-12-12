# 🌟 Automatización de Pruebas: Buggy Cars Rating 🧪

Este repositorio contiene una automatización de pruebas web construido con Selenium WebDriver, Java y TestNG, siguiendo el patrón de diseño Page Object Model (POM). El objetivo principal es automatizar y validar el registro de un usuario nuevo en la página web Buggy Cars Rating.


![Java](https://img.shields.io/badge/Java-v21+-68217A.svg)
![Selenium](https://img.shields.io/badge/Selenium-v4.38-c82333.svg)
![TestNG](https://img.shields.io/badge/TestNG-v7.11-5a433f.svg)
![Log4j2](https://img.shields.io/badge/Log4j2-v2.25.2-blue.svg)

## 📂 Estructura del Proyecto (Page Object Model)
El proyecto sigue una estructura limpia y modular basada en el patrón Page Object Model (POM) para mejorar la reusabilidad, mantenibilidad y legibilidad del código.

```
buggyCars
├── .gitignore                                         # Archivos y carpetas a ignorar por Git
├── pom.xml                                            # Configuración del proyecto Maven y dependencias
├── testng.xml                                         # Aquí se aplica todos los test de la suite.
└── 📂src
    ├── 📂main
    └── 📂test
        └── 📂java
        │    └── 📂com
        │         └── 📂aviatur
        │              └── 📂buggy_cars
        │                  ├── data                    # Clases para la gestión de datos de prueba
        │                  │   └──  📄Data.java
        │                  ├── listeners               # Clases de TestNG Listeners para monitoreo y reporte de pruebas
        │                  │   └──  📄Listeners.java
        │                  ├── pages                   # Clases de Page Objects que modelan las páginas de la UI
        │                  │   ├──  📄BasePage.java
        │                  │   ├──  📄MainPage.java
        │                  │   └──  📄RegisterPage.java
        │                  └── tests                   # Clases que contienen los métodos de prueba (@Test)
        │                      ├──  📄BaseTest.java
        │                      └──  📄RegisterTest.java
        └── resources
                └── log4j2.xml
```

## 🛠️ Configuración del Entorno
Para configurar y ejecutar este proyecto en tu máquina, sigue los siguientes pasos:

**Clonar el Repositorio:**
```
git clone https://github.com/JeidKata/tae_buggyCars.git

cd buggyCars
```
**Requisitos Previos:**

Java Development Kit (JDK) 21 o superior instalado.

Maven instalado (generalmente viene con IDEs como IntelliJ IDEA o Eclipse).

Un IDE compatible con Maven (IntelliJ IDEA, Eclipse).

**Importar el Proyecto en tu IDE:**

Abre tu IDE y selecciona "Open Project".

Navega a la carpeta buggyCars y selecciona el archivo pom.xml.

El IDE debería detectar automáticamente que es un proyecto Maven y descargar todas las dependencias.

## 🚀 Ejecución de las Pruebas
Puedes ejecutar las pruebas de varias maneras:

**Desde tu IDE:**

Haz clic derecho en cualquier clase de prueba individual (RegisterTest.java) y selecciona "Run 'ResgisterTest'".

Haz clic derecho en el archivo testng.xml y selecciona "Run 'testng.xml'".

**Desde la Línea de Comandos (Maven):**

Abre una terminal en la raíz del proyecto (buggyCars).

Ejecuta el siguiente comando:
```
mvn clean test
```
Esto limpiará el proyecto, compilará el código y ejecutará todas las pruebas definidas en el pom.xml (o en un testng.xml si está configurado en el pom.xml).

## 🧪 Escenarios de Prueba Implementados
El framework de automatización actualmente cubre el registro de un usuario nuevo en la página Buggy Cars Rating:

- Abre la página web: https://buggy.justtestit.org
- Da clic en la opción Registrar en el botón superior izquierdo.
- Se ingresan los datos de entrada. (Aquí se validan los mensajes de error)
- Da clic en el botón registrar.


⭐ **¡No olvides dar una estrella al repositorio si te fue útil!** ⭐

[![Made with ❤️ by Jeidy Olaya](https://img.shields.io/badge/Made%20with%20❤️%20by-Jeidy%20Olaya-red.svg)](https://github.com/JeidKata)
