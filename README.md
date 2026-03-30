# LeetCodeSubmissions

# 🚀 LeetCode Submissions Archive

A structured, automated, and versioned repository of my accepted **LeetCode solutions** across multiple programming languages.

---

## 📌 Overview

This repository is designed to:

- 📚 Practice **Data Structures & Algorithms**
- 🧠 Improve **problem-solving consistency**
- 🗂 Maintain a **timestamped history of submissions**
- ⚙️ Demonstrate **workflow automation** using:
  - VS Code Tasks
  - PowerShell
  - GitHub Actions

---

## 🏗️ Repository Structure

### 🔹 Root Layout

```
C:.
│   move-leetcode.ps1
│   README.md
│
├───.github
│   └───workflows
│           sync_leetcode.yml
│
├───.vscode
│       tasks.json
│
├───YYYY-MM-DD-HH-MM-SS
│   └───problems
│       └───<problem-slug>
│               solution.<ext>
```

---

### 🔹 Example Snapshot

```
2023-06-06-15-30-42/
└── problems/
    ├── contains_duplicate/
    │   └── solution.cpp
    ├── longest_substring_without_repeating_characters/
    │   └── solution.java
    └── two_sum/
        └── solution.java
```

---

## ⚙️ Workflow Architecture

### 🧩 1. Problem Solving

- Problems are fetched using the **LeetCode VS Code extension**
- Solutions are written in preferred languages:
  - Python 🐍
  - Java ☕
  - C++ ⚡
  - C# 🔷
  - Others as needed

---

### 🔄 2. Local Storage

Initially stored as:

```
problems/<problem-slug>/solution.<ext>
```

---

### 🧠 3. Automation (Core Feature)

Using:

- `move-leetcode.ps1` (PowerShell script)
- VS Code Task (`tasks.json`)

#### 🔹 What it does:

- Creates a **timestamped folder**
- Moves all solved problems into it
- Cleans up the working directory

---

### ▶️ Run Automation

```
Ctrl + Shift + P → Run Task → Move LeetCode Solutions
```

---

### ☁️ 4. Version Control

- Changes are committed via VS Code Source Control
- Pushed to GitHub for permanent tracking

---

### 🔁 5. GitHub Actions (CI/CD Ready)

Located at:

```
.github/workflows/sync_leetcode.yml
```

#### 💡 Purpose:
- Automate repository updates
- Enable future enhancements like:
  - Auto-syncing
  - Validation pipelines
  - Scheduled commits

---

## 🛠️ Tech Stack

| Category        | Tools Used                         |
|----------------|----------------------------------|
| Editor         | VS Code                          |
| Automation     | PowerShell, VS Code Tasks        |
| Version Control| Git, GitHub                      |
| Languages      | Python, Java, C++, C#, etc.      |
| CI/CD          | GitHub Actions                   |

---

## 🎯 Key Features

- 📁 **Timestamp-based versioning**
- ⚡ **One-click automation workflow**
- 🧩 **Multi-language solutions**
- 🧼 **Clean and maintainable structure**
- 🔄 **Extensible CI/CD integration**

---

## 📈 Why This Repo Stands Out

Unlike a typical LeetCode repository, this project emphasizes:

- ✅ **Process over just solutions**
- ✅ **Automation-first approach**
- ✅ **Scalable structure for long-term use**
- ✅ **Professional engineering practices**

---

## 🚀 Future Enhancements

- 🔍 Auto-generate problem metadata (difficulty, tags)
- 📊 Progress tracking dashboard
- 🧾 Solution explanations (optional layer)
- 🤖 Fully automated sync with LeetCode submissions

---

## 🤝 Contribution

This is a personal learning repository, but ideas and suggestions are always welcome.

---

## 📜 License

This project is open-source and available under the **MIT License**.

---

## ⭐ Final Note

This repository reflects not just problem-solving ability, but also:

> **Discipline, structure, and engineering mindset applied to consistency.**

---