# blablacar
This is a repo dedicated for blablacar interview.



## Table of contents

- [Quick start](#quick-start)
- [What's included](#whats-included)


## Quick start

If you want to run the code, please follow these steps

- git clone this repo to your workspace.
- import it as Maven project in you favarite IDE.
- mvn clean install.
- uncomment main method in the LawnSimulation class to have fun!

The main entry point located in LawnSimulation.class, it create Lawn and mowers according to the width, length and mower number defined in the input file.


## What's included

Blablacar technical test

```text
blablacar/
└── src/
    ├── com.blablacar/
        ├── model
        │   ├── enums
        │   │   ├── Direction
        │   │   └── Instruction
        │   ├── Coordinate
        │   ├── Lawn
        │   └── Mower
        │
        └── service/
            ├── LawnSimulation
            └── MowerServices
```
