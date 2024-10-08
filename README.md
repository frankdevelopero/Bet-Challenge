# BetApp - Aplicación de Gestión de Apuestas (Clean Architecture)

Una aplicación diseñada para gestionar y visualizar información sobre apuestas deportivas, permitiendo a los usuarios ver el historial de apuestas, detalles de cada apuesta, y realizar nuevas apuestas de manera eficiente y segura.


## Características Principales
- **Historial de Apuestas:** Visualización detallada del historial de apuestas del usuario.
- **Detalles de Apuestas:** Información específica de cada apuesta realizada.
- **Gestión de Usuario:** Autenticación y manejo de sesiones de usuarios.
- **Interfaz Interactiva:** Interfaz de usuario intuitiva con operaciones CRUD para apuestas.

## Tecnologías Implementadas
- **MVVM (Model-View-ViewModel)**: Patrón de diseño que facilita la separación de la lógica de desarrollo de la interfaz gráfica.
- **Clean Architecture:** Asegura la separación de preocupaciones, haciendo el código más modular y fácil de mantener.
- **Coroutines:** Gestiona la asincronía con una sintaxis más sencilla y un manejo eficiente de operaciones en segundo plano.
- **Retrofit:** Cliente HTTP para la comunicación con APIs en el backend.
- **Room Database:** Gestión de la base de datos local de la aplicación para un acceso rápido y seguro a los datos.
- **LiveData:** Permite observar cambios en los datos de manera reactiva.
- **Hilt-Dagger:** Proporciona una inyección de dependencias compilada en tiempo de ejecución para simplificar la arquitectura.
  ![alt text](https://miro.medium.com/max/1400/1*02Ink_nKAVnzLS8NA3rm_A.png)

### Ventajas de Coroutines
- **Simplicidad en código asíncrono:** Coroutines permite escribir código asincrónico que es fácil de leer y mantener.
- **Costo de rendimiento:** Crear coroutines es más barato en términos de recursos y tiempo en comparación con los hilos tradicionales.
- **Gestión del ciclo de vida:** Coroutines en combinación con LiveData facilitan la gestión del ciclo de vida de las operaciones en Android.

## Demostración de la Aplicación
![Login Screen](https://i.ibb.co/dmBpnN4/signin.png)
![Home Screen](https://i.ibb.co/wzRC9KH/home-history.png)
[![Ver Video](https://img.youtube.com/vi/VIDEO_ID/0.jpg)](https://drive.google.com/file/d/111cRwZNhPXbGlT7cSqxiReeZLATLRbAH/view?usp=sharing)

