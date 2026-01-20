# 💱 Conversor de Monedas - Challenge Backend Java

<p align="left">
   <img src="https://img.shields.io/badge/STATUS-FINALIZADO-green">
   <img src="https://img.shields.io/badge/JAVA-17%2B-orange">
</p>

## 📝 Descripción

Aplicación de consola en Java que realiza conversiones de divisa en tiempo real consumiendo una API externa.
Este proyecto fue desarrollado como parte del desafío Backend, aplicando principios de **Programación Orientada a Objetos (POO)** y buenas prácticas de arquitectura de software.

## ✨ Características

- **Consumo de API:** Conexión HTTP con `ExchangeRate-API`.
- **Arquitectura Limpia:** Separación de responsabilidades (Cliente API, DTOs, Lógica de Negocio).
- **Menú Dinámico:** Sistema de opciones escalable basado en `List` y `Records`, permitiendo agregar nuevos pares de monedas sin modificar la lógica principal.
- **Manejo de Errores:** Gestión robusta de excepciones (`try-catch`) para entradas inválidas o fallos de conexión.

## 🛠️ Tecnologías

- **Java SDK:** (Versión utilizada, ej. 21 o 25 LTS)
- **Gson:** Librería de Google para deserialización de JSON.
- **Java HTTP Client:** Para las peticiones web.

## 🏗️ Arquitectura del Proyecto

El sistema se divide en componentes con responsabilidades únicas:

1.  **`Principal`**: Orquestador del flujo. Gestiona la interacción con el usuario y el ciclo de vida de la aplicación.
2.  **`ConsultarMoneda`**: Cliente HTTP encargado de la comunicación con la API externa.
3.  **`Moneda` (Record)**: DTO (Data Transfer Object) que modela la respuesta de la API y encapsula la lógica matemática de conversión.
4.  **`ParMoneda` (Record)**: Objeto de configuración que mapea las opciones del menú con los códigos ISO 4217 necesarios para la API.

### Diagrama de Clases Simplificado
```mermaid
classDiagram
    class Principal {
        +main()
    }
    class ConsultarMoneda {
        +buscarMoneda(base, target) Moneda
    }
    class Moneda {
        <<Record>>
        +base_code
        +target_code
        +conversion_rate
        +calcularResultado(cantidad) double
    }
    
    Principal --> ConsultarMoneda : Usa
    ConsultarMoneda --> Moneda : Retorna