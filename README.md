Sistema de Monitoreo y Control de Riego Automatizado (IoT)

📌 Descripción del Proyecto

El Sistema de Monitoreo y Control de Riego Automatizado es una solución IoT desarrollada para la asignatura Aplicaciones Móviles para IoT (INACAP - TI3042). El proyecto integra un microcontrolador Arduino con una aplicación móvil nativa en Android, permitiendo la supervisión en tiempo real de variables ambientales (temperatura y humedad) y el control inalámbrico bidireccional de los actuadores de riego vía Bluetooth.

⚙️ Arquitectura del Sistema

El sistema consta de dos bloques principales interconectados mediante comunicación serial inalámbrica:

┌──────────────────────────┐         Bluetooth         ┌──────────────────────────┐
│    Aplicación Android    │ ◄──────────────────────► │   Microcontrolador IoT   │
│ (Interfaz UI + Control)  │     (Módulo HC-05)       │  (Arduino + Sensores)    │
└──────────────────────────┘                           └──────────────────────────┘


Cliente Móvil (Android): Interfaz gráfica intuitiva que gestiona el acceso de usuarios, la recepción de telemetría de los sensores y el envío de instrucciones de encendido/apagado al sistema de riego.

Nodo Embebido (Arduino): Encargado del muestreo de datos de sensores, procesamiento local y ejecución de comandos sobre la bomba/válvula de riego mediante relés.

🛠️ Tecnologías y Componentes

Hardware

Microcontrolador: Placa compatible con Arduino (Uno / Mega / Nano).

Módulo de Comunicación: Bluetooth HC-05 (UART Serial).

Sensores:

Sensor de temperatura y humedad ambiente (DHT11 / DHT22).

Sensor de humedad de suelo (Higrómetro capacitivo/resistivo).

Actuadores: Módulo de relé de 5V y motobomba de agua / electroválvula.

Software y Entornos

Lógica Móvil: Android Studio (Kotlin, Arquitectura MVC/MVVM).

Interfaz de Usuario: XML con diseño responsivo.

Firmware Embebido: Arduino IDE (C/C++).

Protocolo de Comunicación: Comunicación Serial mediante tecnología Bluetooth SPP (Serial Port Profile).

📱 Funcionalidades Clave de la Aplicación

🔐 Módulo de Autenticación: Pantalla de Login segura y vista de Registro de Usuarios.

📊 Telemetría en Tiempo Real: Visualización continua de lecturas recibidas desde el módulo de sensores.

🎮 Control Remoto: Panel de actuadores para la activación y desactivación manual o automatizada del flujo de riego.

🔗 Gestión de Conexión: Emparejamiento e intercambio bidireccional de datos con el dispositivo Bluetooth HC-05.

🚀 Guía de Instalación y Despliegue

1. Configuración del Hardware y Firmware

Abre el archivo de firmware .ino en el Arduino IDE.

Conecta la placa Arduino a la
