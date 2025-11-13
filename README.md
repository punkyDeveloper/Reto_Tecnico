# 🗓️ Proyecto de Automatización - DatePicker con Serenity BDD

Proyecto de automatización de pruebas para la funcionalidad de selección de fechas utilizando **Serenity BDD**, **Screenplay Pattern** y **Cucumber**.

---

## 📋 Tabla de Contenidos

- [Descripción](#descripción)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Requisitos Previos](#requisitos-previos)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Instalación](#instalación)
- [Ejecución de Pruebas](#ejecución-de-pruebas)
- [Generación de Reportes](#generación-de-reportes)
- [Escenarios de Prueba](#escenarios-de-prueba)
- [Patrones de Diseño](#patrones-de-diseño)

---

## 📖 Descripción

Este proyecto automatiza las pruebas de la funcionalidad **DatePicker** de jQuery UI, verificando diferentes escenarios de selección de fechas:

- Selección de fechas en meses futuros
- Verificación del calendario emergente
- Navegación hacia meses anteriores
- Validación del formato de fechas

**URL bajo prueba:** [https://jqueryui.com/datepicker/](https://jqueryui.com/datepicker/)

---

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 15 | Lenguaje de programación |
| Gradle | 6.8 | Gestor de dependencias |
| Serenity BDD | 2.0.80 | Framework de automatización |
| Cucumber | 4.8.1 | BDD y Gherkin |
| Selenium WebDriver | 3.x | Automatización web |
| WebDriverManager | 5.9.2 | Gestión de drivers |
| JUnit | 4.12 | Framework de testing |

---

## ✅ Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java JDK 15** o superior
- **Gradle 6.8** o superior
- **Google Chrome** (última versión)
- **Git** (opcional, para clonar el repositorio)

### Verificar instalación:

```bash
java -version
gradle -v
```

---

## 📁 Estructura del Proyecto

```
Reto_Tecnico/
├── src/main/java/co/sqasa/
│   ├── pageObjects/
│   │   └── DatePickerUI.java          # Page Objects
│   ├── Steps/
│   │   ├── CambiarFocoAFrame.java     # Task: Cambiar foco al iframe
│   │   ├── SeleccionarFechaFutura.java # Task: Seleccionar fecha futura
│   │   ├── AbrirCalendario.java       # Task: Abrir calendario
│   │   └── SeleccionarFechaAtras.java # Task: Navegar hacia atrás
│   └── questions/
│       └── EstadoCalendario.java      # Question: Verificar visibilidad
│
├── test/
│   ├── java/co/sqasa/
│   │   ├── runners/
│   │   │   ├── TestRunner.java        # Runner Cucumber
│   │   │   └── SeleccionarFechaRunner.java # Runner JUnit
│   │   └── StepDef/
│   │       └── DatePickerStepDef.java # Step Definitions
│   └── resources/features/
│       └── tes.feature                # Escenarios Gherkin
│
├── build.gradle                       # Configuración Gradle
├── serenity.properties               # Configuración Serenity
└── README.md                         # Este archivo
```

---

## 🚀 Instalación

### 1. Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd Reto_Tecnico
```

### 2. Descargar dependencias

```bash
gradle build --refresh-dependencies
```

---

## ▶️ Ejecución de Pruebas

### Opción 1: Ejecutar todas las pruebas

```bash
gradle clean test
```

### Opción 2: Ejecutar con parámetros específicos

```bash
gradle clean test "-Dwebdriver.driver=chrome" "-Dwebdriver.base.url=https://jqueryui.com/datepicker/"
```

### Opción 3: Ejecutar solo tests JUnit

```bash
gradle clean test --tests co.sqasa.runners.SeleccionarFechaRunner
```

### Opción 4: Ejecutar solo tests Cucumber

```bash
gradle clean test --tests co.sqasa.runners.TestRunner
```

### Opción 5: Ejecución con logs detallados

```bash
gradle clean test --info
```

### Opción 6: Limpiar y reconstruir

```bash
gradle clean
gradle build --refresh-dependencies
gradle test
```

---

## 📊 Generación de Reportes

### Generar reporte de Serenity

```bash
gradle test aggregate
```

### Ver reporte en el navegador

El reporte se genera en:
```
target/site/serenity/index.html
```

Abre el archivo en tu navegador para ver:
- ✅ Resultados de ejecución
- 📸 Capturas de pantalla
- 📈 Estadísticas de pruebas
- 🔍 Detalles paso a paso

---

## 🧪 Escenarios de Prueba

### Escenarios implementados:

| # | Escenario | Prioridad | Tags |
|---|-----------|-----------|------|
| 1 | Selección de fecha en mes diferente | Alta | @SelectDate @Smoke |
| 2 | Verificar calendario emergente | Alta | @VerifyCalendar @Smoke |
| 3 | Navegación hacia meses anteriores | Media | @NavigateBackward @Regression |
| 4 | Selección con múltiples combinaciones | Media | @MultipleMonths @Regression |

### Ejecutar por tags:

```bash
# Solo pruebas Smoke
gradle clean test -Dcucumber.options="--tags @Smoke"

# Solo pruebas de Regresión
gradle clean test -Dcucumber.options="--tags @Regression"
```

---

## 🏗️ Patrones de Diseño

### Screenplay Pattern

Este proyecto implementa el **Screenplay Pattern** para automatización web:

#### **Actores (Actors)**
```java
Actor user = Actor.named("User");
```

#### **Habilidades (Abilities)**
```java
user.can(BrowseTheWeb.with(herBrowser));
```

#### **Tareas (Tasks)**
```java
user.attemptsTo(
    SeleccionarFechaFutura.conDias(3, "20")
);
```

#### **Preguntas (Questions)**
```java
user.should(
    seeThat("El calendario esta visible",
        EstadoCalendario.esVisible(),
        is(true))
);
```

#### **Page Objects**
```java
public static final Target CAMPO_FECHA = Target.the("campo de fecha")
    .located(By.id("datepicker"));
```

---

## 🐛 Solución de Problemas

### Problema: ChromeDriver no se descarga

**Solución:**
```bash
gradle clean test --refresh-dependencies
```

### Problema: Tests no se ejecutan

**Solución:**
1. Verificar que Java 15+ esté instalado
2. Limpiar caché de Gradle:
```bash
gradle clean
gradle cleanBuildCache
```

### Problema: Error de compilación

**Solución:**
```bash
gradle clean build --refresh-dependencies
```

---

## 📝 Convenciones de Código

- **Nomenclatura de clases:** PascalCase (`DatePickerUI`)
- **Nomenclatura de métodos:** camelCase (`seleccionarFecha`)
- **Nomenclatura de constantes:** UPPER_SNAKE_CASE (`CAMPO_FECHA`)
- **Idioma:** Código en español, Gherkin en inglés
- **Indentación:** 4 espacios

---

## 📈 Resultados Esperados

Al ejecutar todas las pruebas, deberías ver:

```
6 Scenarios (6 passed)
18 Steps (18 passed)
BUILD SUCCESSFUL
```

---

## 👥 Autor

**Santiago Hernández**  
Automatizador QA - SQA

---

## 📄 Licencia

Este proyecto es parte del **Reto Técnico de SQA** y está bajo la licencia de uso interno.

---

## 🔗 Referencias

- [Serenity BDD Documentation](https://serenity-bdd.info/)
- [Screenplay Pattern](https://serenity-js.org/handbook/design/screenplay-pattern/)
- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [jQuery UI DatePicker](https://jqueryui.com/datepicker/)

---

**Última actualización:** Noviembre 2025