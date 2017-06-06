# Prova d’esame del 23/09/2016 – Tema A


Si consideri il database “iscritti_corsi_gestionale”, contenente informazioni su studenti, corsi ed iscritti ai corsi, relativo alla laurea Magistrale in Ingegneria Gestionale nell’anno 2015/2016.

La tabella studente riporta tutti gli studenti iscritti, la tabella corso tutti i corsi offerti. La tabella iscrizione contiene informazioni sugli studenti iscritti ai corsi. Tutte le informazioni si riferiscono al solo corso di laurea magistrale di Ing. Gestionale nell’anno 2015/2016.

Si intende costruire un’applicazione JavaFX che permetta di interrogare tale base dati, e restituire informazioni utili alla gestione didattica del Politecnico di Torino. L’applicazione dovrà svolgere le seguenti funzioni:

## PUNTO 1a. Creare un grafo i cui nodi rappresentino sia tutti gli studenti che tutti i corsi. Ciascun nodo del grafo potrà rappresentare uno studente oppure un corso. Nella definizione del grafo, si usi la classe Nodo, mentre nella creazione dei vertici si utilizzino le classi Studente e Corso, che sono dichiarate come sotto-classi di Nodo. Un arco non orientato e non pesato collega uno studente ad un corso se lo studente è iscritto a quel corso. Il grafo così costruito è detto “bipartito”, in quanto non esisteranno archi fra due nodi di tipo studente o fra due nodi di tipo corso, ma solo tra nodi studente e nodi corso.b. Facendo click sul pulsante “Corsi frequentati”, stampare in output la frequenza del numero di corsi seguiti da ciascuno studente. In particolare, indicare quanti studenti sono iscritti ad un solo corso, quanti due, quanti tre, ecc.

## PUNTO 2a. Il responsabile della didattica deve presentare a tutti gli studenti della laurea magistrale di Ingegneria Gestionale un progetto innovativo, facendo un breve intervento in aula. Sviluppare un algoritmo ricorsivo per individuare quale sia l’insieme minimo di corsi (e quindi di interventi in aula), tali per cui la comunicazione raggiunga tutti gli studenti che frequentano almeno un corso. Utilizzare il pulsante “Visualizza Corsi” per calcolare e stampare in output il risultato.


Nella realizzazione del codice, si lavori a partire dalle classi (Bean e DAO, FXML) e dal database contenuti nel progetto di base. È ovviamente permesso aggiungere o modificare classi e metodi.

Tutti i possibili errori di immissione, validazione dati, accesso al database, ed algoritmici devono essere gestiti, non sono ammesse eccezioni generate dal programma.