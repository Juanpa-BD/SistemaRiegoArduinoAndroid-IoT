# Sistema de Monitoreo y Control de Riego Automatizado (IoT)

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Arduino](https://img.shields.io/badge/Arduino-00979D?style=for-the-badge&logo=arduino&logoColor=white)
![C++](https://img.shields.io/badge/C++-00599C?style=for-the-badge&logo=c%2B%2B&logoColor=white)

## 📌 Descripción del Proyecto

El **Sistema de Monitoreo y Control de Riego Automatizado** es una solución IoT desarrollada para la asignatura *Aplicaciones Móviles para IoT* (INACAP). El proyecto integra un microcontrolador Arduino con una aplicación móvil nativa en Android, permitiendo la supervisión en tiempo real de variables ambientales y el control inalámbrico bidireccional de los actuadores de riego vía Bluetooth.

## ⚙️ Arquitectura del Sistema

El sistema consta de dos bloques principales interconectados mediante comunicación serial inalámbrica:

┌──────────────────────────┐          Bluetooth         ┌──────────────────────────┐
│    Aplicación Android    │ ◄──────────────────────► │   Microcontrolador IoT   │
│ (Interfaz UI + Control)  │      (Módulo HC-05)      │  (Arduino + Sensores)    │
└──────────────────────────┘                          └──────────────────────────┘


* **Cliente Móvil (Android):** Interfaz gráfica intuitiva que gestiona el acceso de usuarios, la recepción de telemetría de los sensores y el envío de instrucciones al sistema de riego.
* **Nodo Embebido (Arduino):** Encargado del muestreo de datos de sensores, procesamiento local y ejecución de comandos sobre la bomba de riego mediante relés.

## 🛠️ Tecnologías y Componentes

### **Hardware**

* **Microcontrolador:** Placa compatible con Arduino (Uno / Mega / Nano).
* **Módulo de Comunicación:** Bluetooth HC-05 (UART Serial).
* **Sensores:**
* Sensor de temperatura y humedad ambiente (DHT11 / DHT22).
* Sensor de humedad de suelo.

* **Actuadores:** Módulo de relé de 5V y motobomba de agua.

### **Software y Entornos**

* **Lógica Móvil:** Android Studio (Kotlin).
* **Interfaz de Usuario:** XML con diseño responsivo.
* **Firmware Embebido:** Arduino IDE (C/C++).
* **Protocolo:** Comunicación Serial Bluetooth SPP.

## 📱 Funcionalidades Clave

* **🔐 Módulo de Autenticación:** Pantalla de inicio de sesión y registro.
* **📊 Telemetría en Tiempo Real:** Visualización continua de lecturas de los sensores.
* **🎮 Control Remoto:** Panel para la activación manual o automatizada del riego.
* **🔗 Gestión de Conexión:** Emparejamiento e intercambio de datos con el HC-05.

## 🚀 Guía de Instalación y Despliegue

### 1. Configuración del Hardware y Firmware

1. Abre el archivo `.ino` en el **Arduino IDE**.
2. Conecta la placa Arduino y verifica las conexiones de los pines (HC-05, sensores y relé).
3. Sube el programa a la placa.

### 2. Despliegue de la Aplicación Móvil

1. Genera el APK desde Android Studio: `Build > Build Bundle(s) / APK(s) > Build APK(s)`.
2. Localiza el archivo en `app/build/outputs/apk/debug/app-debug.apk`.
3. Instálalo en tu dispositivo Android y concédele los permisos de Bluetooth.


## 👥 Equipo de Desarrollo

* **Institución:** INACAP.
* **Asignatura:** TI3042 - Aplicaciones Móviles para IoT.
