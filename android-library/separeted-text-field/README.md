# 🔢 SeparatedTextField

Un componente reutilizable de Jetpack Compose para ingresar códigos tipo PIN o OTP usando casillas separadas.  
Ideal para pantallas de verificación o autenticación por código.

---

## 🚀 Instalación

### Usando JitPack

1. En `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

2. En tu `build.gradle.kts` del módulo app:

```kotlin
dependencies {
    implementation("com.github.micabustos:separatedtextfield:1.0.0")
}
```

---

## 🧪 Ejemplo de uso

```kotlin
@Composable
fun CodeInputExample() {
    var code by remember { mutableStateOf("") }

    SeparatedTextField(
        value = code,
        onValueChange = { code = it },
        isErrorOnCodeWritten = false,
        length = 4
    )
}
```

## 🧠 Integración recomendada con ViewModel

```kotlin
class OtpViewModel : ViewModel() {
    var codeNumber by mutableStateOf("")
    var isErrorOnCodeWritten by mutableStateOf(false)

    fun updateCodeNumber(input: String) {
        codeNumber = input
        isErrorOnCodeWritten = false
    }
}
```

```kotlin
@Composable
fun OtpScreen(viewModel: OtpViewModel = viewModel()) {
    SeparatedTextField(
        value = viewModel.codeNumber,
        onValueChange = { viewModel.updateCodeNumber(it) },
        isErrorOnCodeWritten = viewModel.isErrorOnCodeWritten,
        length = 4
    )
}
```

## 🎨 Personalización disponible

| Propiedad               | Tipo                | Descripción                                        |
|-------------------------|---------------------|----------------------------------------------------|
| `value`                 | String              | Código ingresado actualmente                       |
| `onValueChange`         | (String) -> Unit    | Callback que se dispara al escribir                |
| `isErrorOnCodeWritten`  | Boolean             | Si es `true`, muestra líneas en color de error     |
| `length`                | Int                 | Cantidad de dígitos esperados                      |
| `boxWidth`, `boxHeight` | Dp                  | Tamaño de cada casilla                             |
| `spaceBetweenFields`    | Dp                  | Espacio entre las casillas                         |
| `boxesCompleteColor`    | Color               | Color de línea cuando está completa                |
| `defaultIncompleteColor`| Color               | Color de línea cuando está vacía                   |
| `errorOnCodeColor`      | Color               | Color cuando se detecta un error                   |

---

## 🧠 Integración recomendada con ViewModel

```kotlin
class OtpViewModel : ViewModel() {
    var codeNumber by mutableStateOf("")
    var isErrorOnCodeWritten by mutableStateOf(false)

    fun updateCodeNumber(input: String) {
        codeNumber = input
        isErrorOnCodeWritten = false
    }
}
```

```kotlin
@Composable
fun OtpScreen(viewModel: OtpViewModel = viewModel()) {
    SeparatedTextField(
        value = viewModel.codeNumber,
        onValueChange = { viewModel.updateCodeNumber(it) },
        isErrorOnCodeWritten = viewModel.isErrorOnCodeWritten,
        length = 4
    )
}
```

---

## 📄 Licencia

Este proyecto está bajo la licencia MIT.  
Podés usarlo libremente en proyectos personales o comerciales.

---

## 💻 Autor

Creado con 💙 por [@BustosNahu](https://github.com/BustosNahu)
