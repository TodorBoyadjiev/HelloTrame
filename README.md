# HelloTrame

## Un analyseur de protocoles offline qui prend en entrée une fichier .txt 

Il peut analyser les protocoles Ethernet, IPv4, UDP, DNS et DHCP. La procedure de lancement est décrit dans le howtoDO.txt. Le programme peux aussi prendre un fichier avec plusieurs lignes blanches, de caractères aléatoires.

### Built With
* [Java](https://www.java.com)

## Structure de code
Le programme fonctionne de le manière suivant:
- Main récupère l'argument mis en parametre dans le terminal, puis Main appelle ReadFile
- ReadFile isole les trames et les transmet au AnalyseTrame
- AnalyseTrame fait scanner les fichiers et extrait les informations
- le resultat est sauvegard� dans result.txt

Il y a 3 fichiers de base:
- Main.java
- ReadFile.java
- AnalyseTrame.java

Il y a 5 fichiers qui servent pour a analyser les protocoles, 1 pour chaque protocole:
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
