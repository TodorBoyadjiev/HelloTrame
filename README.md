# HelloTrame


## A Wireshark-based protocol analyser for Ethernet, IP, UDP and DNS/DHCP

### Structure of the code

The analyser uses a basic java main program, combined with a class ReadFile for reading .txt file protocols which are later exported to AnalyseTrame to be analysed.

For every protocol, a class is created. This class in analysed with the help of the String created from ReadFile. The class has different methods for every parameter, for exemple, IP has a method for extracting and converting the IP adresses and also a method takeIP() which produces a textual result.

### Ethernet protocol

There are three Ethernet parameters that we want to print - Destination MAC adress, Source MAC adress and Type of protocol embedded in Ethernet. The


