# Reto 1

**Arquitectura, estilo MVC (Model-View-Controller) con Patrón Command:**
El proyecto está estructurado en capas bien definidas. En el paquete **model**, la clase `SecurityDial` encapsula la lógica matemática del dial (movimientos circulares, control de límites y detección de paso por cero). En el paquete **view**, `ConsoleResultPrinter` se encarga únicamente de mostrar los resultados al usuario. En **controller**, `DialManager` actúa como orquestador: recibe los datos crudos, los convierte en comandos ejecutables y gestiona el flujo de la aplicación. Además, se introduce el paquete **command** para encapsular las acciones de movimiento.

**Principios:**
* **Responsabilidad Única (SRP):** Cada clase tiene un propósito único. `TextFileReader` solo lee archivos, `SecurityDial` solo calcula posiciones, y `DialManager` solo realiza los movimientos.
* **Inversión de Dependencias (DIP):** El sistema depende de abstracciones (`InputReader`, `SolutionPrinter`, `DialOperation`) y no de implementaciones concretas, facilitando el cambio de componentes.
* **Abierto-Cerrado (OCP):** El sistema es extensible. Gracias a la interfaz `DialOperation`, se pueden añadir nuevos tipos de movimientos creando un nuevo record sin modificar la lógica de cálculo del controlador.

**Otros:**
* **Clase Command:** Intermediario entre las clases de los paquetes controller y model. Encapsula toda la información necesaria para realizar una acción. Su objetivo es separar el momento en que se crea la orden del momento en que se ejecuta, permitiendo que el sistema sea más flexible y organizado
* **Java Records:** Uso de `ClockwiseShift` y `CounterClockwiseShift` para crear objetos de datos inmutables de forma poco verbosa.
* **Streams:** Uso de programación funcional (`map`, `filter`, `mapToInt`, `sum`) para procesar las instrucciones de manera declarativa y limpia.
* **Factory Method:** Implementado en `parseCommand` para generar las operaciones dinámicamente.
