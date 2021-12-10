# HelloTrame

## Un analyseur de protocoles offline qui prend en entrée une fichier .txt 

Il peut analyser les protocoles Ethernet, IPv4, UDP, DNS et DHCP. La procédure de lancement est décrite dans le howtoDO.txt. Le programme peut aussi prendre un fichier avec plusieurs lignes blanches et des caractères aléatoires.

### Built With
* [Java](https://www.java.com)

## Structure de code
Le programme fonctionne de la manière suivante:
- Main récupère l'argument mis en paramètre dans le terminal, puis Main appelle ReadFile.
- ReadFile isole les trames et les transmet au AnalyseTrame.
- AnalyseTrame scanne les trames et extrait les informations en utilisant les classes des différents protocoles.
- le résultat est sauvegardé dans result.txt.

Il y a 3 fichiers de base:
- Main.java
- ReadFile.java
- AnalyseTrame.java

Il y a 5 fichiers qui servent a analyser les protocoles, 1 pour chaque protocole:
- Ethernet.java
- IP.java
- UDP.java
- DNS.java
- DHCP.java

La plupart des fichiers utilisent un StringBuilder pour les affichages. 


<!-- CONTACT -->
## Contact

Todor Boyadjiev - boyadjievtodor@gmail.com
Samantha Richard - samantharichard1999@gmail.com


<p align="right">(<a href="#top">back to top</a>)</p>
