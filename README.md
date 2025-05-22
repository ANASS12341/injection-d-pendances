# 💉 Injection de Dépendances - TP1

Ce projet Java illustre un petit système distribué basé sur le **principe d’injection de dépendances (DI)** en utilisant **Spring Framework**.  
L’objectif est de découpler les différentes couches (DAO, métier, présentation) et de gérer dynamiquement leurs dépendances :

- 📄 Via un fichier **XML** (`config.xml`)
- 🧩 Via des **annotations** (`@Repository`, `@Service`, scan de composants)

---

## 🗂️ Structure du projet

![image](https://github.com/user-attachments/assets/b5563048-9dbd-432b-a824-315278234c1a)

---

## 🔧 Composants principaux

### 1. 🗄️ Couche DAO

- `DaoImpl`  
  → Simule l'accès à une base de données avec la méthode `getData()`.

- `DaoImplV2`  
  → Simule l’accès à des capteurs, retourne une autre valeur via `getData()`.

### 2. 🧠 Couche Métier

- `MetierImpl`  
  → Annoté avec `@Service` ou défini dans le fichier XML.  
  → Implemente `calculate()` qui utilise le DAO injecté pour effectuer un calcul.

### 3. 🎛️ Couche Présentation

- `PresSpringXML`  
  → Point d’entrée principal : charge le contexte Spring via `config.xml`, exécute `metier.calculate()`.

- `Pres2`  
  → Mode **injection manuelle** :
    - Lit un fichier `config.txt`
    - Instancie dynamiquement les classes (réflexivité)
    - Injecte et exécute `calculate()`

---

## ⚙️ Configuration

### 1. 📦 Fichier Spring XML (`src/main/resources/config.xml`)

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd">

  <!-- DAO alternatif (capteurs) -->
  <bean id="d" class="master.sdia.ext.DaoImplV2"/>

  <!-- Service métier -->
  <bean id="metier" class="master.sdia.metier.MetierImpl">
    <constructor-arg ref="d"/>
  </bean>

</beans>
master.sdia.dao.DaoImpl
master.sdia.metier.MetierImpl
2. 📝 Injection manuelle (config.txt)
Fichier config.txt à créer dans src/main/resources/ :

Copier
Modifier
master.sdia.dao.DaoImpl
master.sdia.metier.MetierImpl
📦 Dépendances Maven
xml
Copier
Modifier
<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>6.2.5</version>
  </dependency>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.2.5</version>
  </dependency>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-beans</artifactId>
    <version>6.2.5</version>
  </dependency>
</dependencies>
🚀 Exécution
▶️ Mode 1 : Spring XML (PresSpringXML)
bash
Copier
Modifier
mvn compile exec:java -Dexec.mainClass=master.sdia.pres.PresSpringXML
Charge config.xml

Affiche le résultat calculé par la couche métier

▶️ Mode 2 : Injection manuelle (Pres2)
bash
Copier
Modifier
mvn compile exec:java -Dexec.mainClass=master.sdia.pres.Pres2
Lit config.txt

Instancie les classes avec la réflexion

Injecte et exécute la logique métier

✅ Résultat attendu
text
Copier
Modifier
Résultat = 22.0
💡 Remarques et extensions possibles
Comparaison injection XML vs réflexivité

Extensions possibles :

Injection par setter ou champ

Scan d’annotations (@Repository, @Service)

Gestion des scopes (singleton, prototype)

Switch dynamique entre plusieurs implémentations de DAO
