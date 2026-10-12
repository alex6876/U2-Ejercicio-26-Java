# 🖨️ Simulación de Impresoras y Dispositivos de Impresión (POO y Herencia en Java)

Este proyecto es una aplicación en Java que modela un sistema de impresión con diferentes tipos de tecnologías (Láser e Inyección de Tinta). Pone en práctica conceptos clave de la **Programación Orientada a Objetos (POO)** como **clases abstractas**, **herencia**, reutilización de constructores mediante `super`, **sobrescritura de métodos (`@Override`)** y control de estados de suministros en memoria.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una superclase abstracta y múltiples implementaciones concretas:

*   **`Impresor` (Clase Abstracta)**: Define la plantilla y los atributos genéricos compartidos por cualquier dispositivo de impresión.
    *   **Atributos:** `modelo` y `resolucion` (medida en DPI).
    *   **Métodos principales:** 
        *   Constructor para inicializar los atributos base.
        *   `imprimirDocumento(String documento)`: Método abstracto que obliga a las subclases a implementar su propia lógica de impresión.
        *   `mostrarEstado()`: Muestra por consola las especificaciones generales del dispositivo.
*   **`ImpresorLaser`**: Modela una impresora de tecnología láser.
    *   **Atributos:** `niveltoner` (porcentaje de tóner disponible).
    *   **Comportamiento:** Valida que el tóner sea mayor a cero, descuenta un 10% por cada impresión realizada y extiende la visualización del estado mediante `super.mostrarEstado()`.
*   **`ImpresoraTinta`**: Modela una impresora de inyección de tinta.
    *   **Atributos:** `nivelCartucho` (porcentaje de tinta disponible).
    *   **Comportamiento:** Valida la disponibilidad del cartucho y aplica un descuento operativo similar al modelo láser.
*   **`Main`**: Punto de entrada del programa. Instancia dispositivos con diferentes niveles de suministros (uno con tóner y otro con cartucho agotado) para probar el control de errores y la visualización de estados.

---

## ⚙️ Reglas de Negocio y Control de Suministros

1. **Validación Preventiva de Insumos:** Antes de procesar cualquier documento, las clases concretas evalúan si el suministro crítico (`niveltoner` o `nivelCartucho`) es mayor a cero. Si está agotado, se interrumpe la tarea y se emite un mensaje de error por consola.
2. **Consumo Incremental y Tope Mínimo:** Cada impresión reduce el recurso en un 10%, asegurando mediante una validación interna que el porcentaje nunca tome valores negativos (`if (nivel < 0) nivel = 0;`).
3. **Reutilización de Comportamiento (`super`):** Tanto en los constructores como en el método `mostrarEstado()`, las subclases invocan el comportamiento de la clase padre mediante `super(...)` y `super.mostrarEstado()`, evitando duplicación de código.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
--- Impresora Láser ---
Modelo: HP 1200
Resolucion: 1200 DPI
nivel de toner: 20%
Imprimiendo con laser: Imforme.pdf
Impresion realizada correctamente.
Modelo: HP 1200
Resolucion: 1200 DPI
nivel de toner: 10%

--- Impresora Tinta ---
Modelo: Epson
Resolucion: 600 DPI
Nivel de cartucho: 0%
Error: cartucho de tinta agotado.
Modelo: Epson
Resolucion: 600 DPI
Nivel de cartucho: 0%
