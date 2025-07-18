# Workers & Employeers

Aplicación de consola en C que conecta empleadores con trabajadores especializados.  
Permite a los empleadores crear cuentas, buscar y contratar trabajadores; y a los
trabajadores crear, editar o eliminar su perfil.

## Integrantes del proyecto

- Leandro Gómez Rovelli  
- Franco Da Resurreicao  
- Nahuel Barbato  
- Tomás Colombo  
- Nahuel Bustos


## Características

### Empleadores
* Crear e iniciar sesión en una cuenta
* Buscar trabajadores por especialidad y presupuesto
* Contratar trabajadores y registrar la contratación
* Ver historial de contrataciones
* Calificar contrataciones (opcional, vía estructura [Hiring](cci:1://file:///Users/nahu/Documents/UAI/workers&employeers/employeers/employeerImplementation.c:151:0-176:1))

### Trabajadores
* Crear perfil con:
  * Nombre
  * Especialidad (enum): `PLOMERIA`, `ALBANILERIA`, `CARPINTERIA`, `GASISTA`
  * Presupuesto por hora
  * DNI
* Editar o eliminar su perfil
* Ver contrataciones recibidas

## Estructuras de datos principales

```c
typedef enum {
    PLOMERIA,
    ALBANILERIA,
    CARPINTERIA,
    GASISTA,
    SPECIALTY_COUNT
} Specialty;

typedef struct {
    char  name[50];
    Specialty specialty;
    float budget_per_hour;
    long  dni;
} Worker;

typedef struct {
    char name[50];
    long dni;
} User;

typedef struct {
    long userDNI;
    long workerDNI;
    float rating;   // -1: sin calificar
} Hiring;

