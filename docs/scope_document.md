# Project Scope Document

**Project:** Programming Project 3 - Optimal Selection
**Course:** CS-2430-502‚ Spring 2026
**Team Name:** Team B&E

## 1․ Project Objective
The aim of the project is to implement‚ test and compare a variety of algorithmic approaches to solving a Knapsack optimization problem․ The program must calculate which experiments to fly on a series of space shuttles‚ such that the total scientific rating is maximized and the total weight does not exceed 700 kg‚ given a set of such experiments and their properties․ The system is to be used for showing the differences between Greedy‚ Brute-Force and Dynamic Programming․

## 2․ In-scope items (Deliverables and features)
The project's objectives will be met through delivery of the following software and documentation components:

### 2․1 Software Implementation
* **Data Structure:** Each of the 12 identified scientific payloads is initialized via hard coding or configuration files‚ Weight‚ Rating․

**Greedy Algorithms (Part 1):**
* Highest Rating First (700kg Capacity)
* Lightest Weight First (700kg payload)
* Best Rating-to-Weight Ratio First (700kg capacity)

**Exhaustive Search / Brute Force (Part 2):**
* Generating all 4‚096 subsets․
* Identify and present the 3 highest-rated valid subsets (≤700 kg)․

**Comparison Output (Part 3):**
* You can format the output to print the results of all strategies to the console / terminal so that it is easier to see which greedy algorithms reached the true optimal solution․

**Dynamic Programming (Part 4):**
* Either Implementation of a DP table/algorithm for extra credit or comments that explain the particular array/algorithm in pseudocode format in the source code․

### 2․2 Documentation & Repository
* **Project Plan:** A document of work and status․
* **Design Artifacts:** This document and UML.png
* **README․md:** Instructions for building and running the software․
* **CONTRIBUTIONS․md:** team members with roles and specific evidence of their contributions to the repository (Commits‚ PRs)․

### 2․3 Assessment Deliverables
* **Formal Written Report:** A 3-5 page written report that analyzes both algorithms and answers all exploration assignment questions․
* **Screencast Video:** A code walkthrough and run of the application‚ ≤ 10 min long‚ with team members providing narration/captions․

## 3․ Out of Scope
* **Graphical User Interface (GUI):** The application will run through the standard terminal/console output․
* **Dynamic Inputs:** The project only requires 12 fixed items.

## 4․ Constraints & Assumptions
* **Maximum Weight Constraint:** The total weight of the selected products cannot exceed 700 kg․
* **Programming Language:** The project will be developed using a single primary programming language‚ which is Java.
* **Audience:** The code documentation and final report must be written to be understandable to a reasonably technical peer not currently enrolled in CS 2430․
* **System Environment:** The program must be compilable and executable in the standard environment for the selected language․

## 5․ Team roles and responsibilities․
Our team must rotate roles throughout our two projects

* **Implementation Lead:** Ethan Hadley‚  Responsible for algorithm implementation‚ integration‚ and the main branch health․
* **Verification Lead:** Ethan Hadley‚  Owns the test plan‚ edge case handling‚ and verification evidence․
* **Communications Lead:** Benjamin Paul, assembles the reports‚ the README with run instructions‚ and the deliverable․

## 6․ Success Criteria
The project will be judged a success if:
* All three Greedy algorithms and the Brute Force algorithm compile and execute the required output․
* The final code is commented and authorship is given․
* The team's report is a thorough comparison of the methods used and answers all assignment questions․
* The GitHub repository shows collaborative work via pull requests/commits (see CONTRIBUTIONS․md)․