# Minimization of Deterministic Finite Automata (DFA)  
*(Kozen, 1997 – Lecture 14)*

## Description
This project implements the **minimization of deterministic finite automata (DFA)** using the **partition refinement algorithm**, as described in *Kozen, 1997 – Lecture 14*.  

The program takes the description of one or more automata, identifies equivalent states, and outputs indistinguishable state pairs in **lexicographic order**.

---

## Features
- Supports reading multiple DFAs through standard input.  
- Works with alphabets of any size.  
- Implements the algorithm of **iterative refinement of equivalence classes**.  
- Outputs equivalent state pairs in the required format:  (i, j) (x, y) ...

where each line corresponds to a test case.

---

## Input Format
1. Number of test cases `c`.  
2. For each DFA:  
 - Number of states `n`.  
 - Alphabet symbols separated by spaces.  
 - Set of final states separated by spaces.  
 - Transition table with `n` rows (one per state).  

---

## Output Format
- For each test case, all **pairs of equivalent states** are printed in lexicographic order.  
- Each pair is represented as `(i, j)`.  
- Pairs are separated by a space.  
- Each output line corresponds to one DFA.  

---

## Example Execution

### Input
- 4
- 6
- a b
- 1 2 5
- 0 1 2
- 1 3 4
- 2 4 3
- 3 5 5
- 4 5 5
- 5 5 5
- 6
- a b
- 3 4 5
- 0 1 2
- 1 3 4
- 2 4 3
- 3 5 5
- 4 5 5
- 5 5 5
- 6
- a
- 1 4
- 0 1
- 1 2
- 2 3
- 3 4
- 4 5
- 5 0
- 4

### Expected Output

- (1, 2) (3, 4)
- (1, 2) (3, 4) (3, 5) (4, 5)
- (0, 3) (1, 4) (2, 5)
- (0, 1)

---

## Execution

### In Java
Compile:
```bash
javac ActividadI.java
```
---

## Reference
D. Kozen, Automata and Computability, Lecture 14, 1997.

## Authors
- Emmanuel Castaño Sepúlveda
- Jerónimo Conteras Sierra

## Course
- Adolfo Ándres Castro Sánchez
- 5465 – Formal Languages

