# Realm

Escrita en C++ enfocada a móviles y reemplaza el uso tradicional de SQLite. Ofrece

* Muy rápida
* Poca configuración
* Migraciones
* Encriptación
* Anotaciones
* Listeners
* Realm adapters
* Soporte para JSON
* Fácil definición de relaciones

Es multiplataforma (Android, Swift, React Native, Xamarin). Soporte a librerias como GSON, Kotlin, RXJava entre otras.

## Instalación Realm en java

Ingresamos la dependencia en **build.gradle** Top-level

```gradle
classpath "io.realm:realm-gradle-plugin:5.13.0"
```

Posteriormente en el **build.gradle** Project

```gradle
apply plugin: 'realm-android'
```

Model ejemplo **PersonModel.java**

```java
public class PersonModel extends RealmObject {

    public String firstName;

    public String lastName;
}
```

Guardar y consultar información

```java
PersonModel person = new PersonModel();
person.firstName = "Andrea";
person.lastName = "Vega";

Realm.init(this);

//Instance
Realm realm = Realm.getDefaultInstance();

//Start transaction
realm.beginTransaction();

//Save
realm.copyToRealm(person);

//Close transaction
realm.commitTransaction();

//Query find all
RealmResults<PersonModel> realmResults = realm.where(PersonModel.class).findAll();
```