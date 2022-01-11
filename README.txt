# RevuesOnLine
Ce qui ne fonctionne pas:

La limitation a 400 caractère de la description d'une revue
L'import d'une image pour le visuel de la revue
La détection de doublon

Ce qui fonctionne :
On peut ajouter,supprimer, modifier et importer un csv dans client et les trois premieres options dans abonnement, revue, periodicite
Au lancement, on peut choisir entre mysql et listememoire
Et tous les autres details annexes


Repartition des tâches:

ConnexionDao.java :Louis
Persistance.java :Louis
Classes métier (client, periodicite, revue) : Louis
ListeMémoire et MySQL de Client, Abonnement, Revue, Periodicite : Julien
Interface textuelle de Client, Abonnement, Periodicite, Revue : Louis
Interface graphique de l'application: Julien
Design de l'interface graphique : Louis
package dao_factory et toutes les classes qui s'y trouvent : Julien
Test main : Louis
Modification de ListeMemoire et MySql d'Abonnement du fait du changement du type Date : Julien
Possibilité de choisir entre mysql et listememoire : Louis
Gestion de la date dans la classe métier Abonnement_pojo : Julien
Normalisation du code postal et de la ville de la classe Client: Louis
Fonction ajouter, modifier, supprimer, importer csv dans l'interface graphique : Julien
Amélioration des classes métier: Julien
Correction de derniers petits bugs et relecture: Louis

Estimation en pourcentage de la répartition du travail:
Julien 50%
Louis 50%
