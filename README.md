# Application de gestion de notes de frais

Ce projet est une application complète dans le contexte GSB composée de deux parties :

- **Frontend Angular**
- **Backend Spring Boot (Celui-ci)**

L'objectif est de permettre à des visiteurs de créer, consulter, modifier et supprimer leurs fiches de frais. Si le montant d'une fiche dépasse 150€, elle est automatiquement considérée comme une fiche hors forfait.

#### `backend/README.md`
# Backend — API Spring Boot

Le backend fournit une API REST pour gérer les fiches de frais des visiteurs.

## Fonctionnalités

- Création automatique des fiches "hors forfait" (si montant > 150 €)
- Création et mise à jour des fiches (montant, justificatifs, date (auto)) / supression / consultation (CRUD)

## Stack utilisée

- Java + Spring Boot
- Spring Data JPA
- MySQL
- Requêtes via Repository

## Lancer le backend

```bash
./mvnw spring-boot:run