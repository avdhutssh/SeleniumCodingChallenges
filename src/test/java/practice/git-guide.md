# Git Guide: From Basics to Advanced

A comprehensive guide to essential and advanced Git commands, concepts, and workflows. Each command includes its purpose, usage, and an example. Practice these commands to master Git!

---

## Table of Contents
1. [Introduction to Source Control & Git](#introduction-to-source-control--git)
2. [Easy: Essential Git Commands](#easy-essential-git-commands)
3. [Intermediate: Branching, Merging, and Collaboration](#intermediate-branching-merging-and-collaboration)
4. [Advanced: Rewriting History, Recovery, and Power Tools](#advanced-rewriting-history-recovery-and-power-tools)
5. [Git Aliases](#git-aliases)
6. [Git Objects & Internals](#git-objects--internals)
7. [GitHub & Collaboration Workflows](#github--collaboration-workflows)
8. [References](#references)

---

## Introduction to Source Control & Git
- **Source Control**: Tracks changes to files, enables collaboration, and maintains history.
- **Local vs Remote**: Local is your machine; remote is a shared server (e.g., GitHub).

---

## Easy: Essential Git Commands

### 1. Initialize a Repository
- **Purpose**: Start tracking a project with Git.
- **Command**: `git init`
- **Example**:
  ```sh
  git init
  ```

### 2. Check Status
- **Purpose**: See changes, staged files, and untracked files.
- **Command**: `git status`
- **Example**:
  ```sh
  git status
  ```

### 3. Add Files to Staging
- **Purpose**: Stage files for commit.
- **Command**: `git add <file>`
- **Example**:
  ```sh
  git add README.md
  git add .  # Add all changes
  ```

### 4. Commit Changes
- **Purpose**: Save staged changes to history.
- **Command**: `git commit -m "message"`
- **Example**:
  ```sh
  git commit -m "Initial commit"
  ```

### 5. View Commit Log
- **Purpose**: See commit history.
- **Command**: `git log`
- **Example**:
  ```sh
  git log
  ```

### 6. Connect to Remote Repository
- **Purpose**: Link local repo to remote (e.g., GitHub).
- **Command**: `git remote add origin <url>`
- **Example**:
  ```sh
  git remote add origin https://github.com/user/repo.git
  ```

### 7. Push Changes
- **Purpose**: Upload commits to remote.
- **Command**: `git push origin <branch>`
- **Example**:
  ```sh
  git push origin main
  ```

### 8. Pull Changes
- **Purpose**: Download and merge changes from remote.
- **Command**: `git pull`
- **Example**:
  ```sh
  git pull origin main
  ```

### 9. Clone a Repository
- **Purpose**: Copy a remote repo locally.
- **Command**: `git clone <url>`
- **Example**:
  ```sh
  git clone https://github.com/user/repo.git
  ```

### 10. Check Differences
- **Purpose**: See changes between commits, branches, or working directory.
- **Command**: `git diff`
- **Example**:
  ```sh
  git diff
  git diff HEAD~1 HEAD
  ```

---

## Intermediate: Branching, Merging, and Collaboration

### 1. Create a Branch
- **Purpose**: Work on features independently.
- **Command**: `git branch <branch-name>`
- **Example**:
  ```sh
  git branch feature-x
  ```

### 2. Switch Branches
- **Purpose**: Move between branches.
- **Command**: `git checkout <branch-name>` or `git switch <branch-name>`
- **Example**:
  ```sh
  git checkout feature-x
  git switch main
  ```

### 3. Create and Switch in One Step
- **Command**: `git checkout -b <branch-name>` or `git switch -c <branch-name>`
- **Example**:
  ```sh
  git checkout -b new-feature
  ```

### 4. Merge Branches
- **Purpose**: Combine changes from one branch into another.
- **Command**: `git merge <branch-name>`
- **Example**:
  ```sh
  git checkout main
  git merge feature-x
  ```

### 5. Resolve Merge Conflicts
- **Purpose**: Manually fix conflicting changes.
- **Command**: Edit files, then `git add <file>` and `git commit`

### 6. Delete a Branch
- **Command**: `git branch -d <branch-name>`
- **Example**:
  ```sh
  git branch -d feature-x
  ```

### 7. Track Remote Branches
- **Purpose**: Work with branches on remote.
- **Command**: `git fetch`, `git branch -r`, `git checkout -t origin/<branch>`
- **Example**:
  ```sh
  git fetch
  git branch -r
  git checkout -t origin/feature-x
  ```

### 8. Undo Changes
- **Restore file**: `git restore <file>`
- **Unstage file**: `git restore --staged <file>`
- **Revert commit**: `git revert <commit-hash>`
- **Example**:
  ```sh
  git restore README.md
  git restore --staged README.md
  git revert a1b2c3d
  ```

### 9. Stash Changes
- **Purpose**: Temporarily save changes.
- **Command**: `git stash`, `git stash pop`, `git stash list`
- **Example**:
  ```sh
  git stash
  git stash list
  git stash pop
  ```

### 10. Tagging
- **Purpose**: Mark releases/versions.
- **Command**: `git tag <tagname>`, `git tag -a <tagname> -m "message"`, `git push --tags`
- **Example**:
  ```sh
  git tag v1.0
  git tag -a v1.1 -m "Release 1.1"
  git push --tags
  ```

---

## Advanced: Rewriting History, Recovery, and Power Tools

### 1. Amend Last Commit
- **Purpose**: Change last commit message or add files.
- **Command**: `git commit --amend`
- **Example**:
  ```sh
  git commit --amend -m "New message"
  git add missedfile.txt
  git commit --amend
  ```

### 2. Reflog
- **Purpose**: View all changes (even lost commits).
- **Command**: `git reflog`
- **Example**:
  ```sh
  git reflog
  ```

### 3. Reset
- **Purpose**: Move HEAD and optionally working directory.
- **Soft Reset**: Keep changes staged: `git reset --soft <commit>`
- **Mixed Reset**: Unstage changes: `git reset --mixed <commit>`
- **Hard Reset**: Discard all changes: `git reset --hard <commit>`
- **Example**:
  ```sh
  git reset --soft HEAD~1
  git reset --hard a1b2c3d
  ```

### 4. Clean Untracked Files
- **Purpose**: Remove untracked files.
- **Command**: `git clean -fd`
- **Example**:
  ```sh
  git clean -fd
  ```

### 5. Rebase
- **Purpose**: Reapply commits on top of another base tip.
- **Command**: `git rebase <branch>`
- **Interactive Rebase**: `git rebase -i <commit>`
- **Example**:
  ```sh
  git rebase main
  git rebase -i HEAD~3
  ```

### 6. Squash Commits
- **Purpose**: Combine multiple commits into one.
- **Command**: Use interactive rebase, mark commits as `squash` or `fixup`.
- **Example**:
  ```sh
  git rebase -i HEAD~3
  # Change 'pick' to 'squash' for commits to combine
  ```

### 7. Cherry Pick
- **Purpose**: Apply a specific commit from another branch.
- **Command**: `git cherry-pick <commit-hash>`
- **Example**:
  ```sh
  git cherry-pick a1b2c3d
  ```

### 8. Garbage Collection
- **Purpose**: Clean up unreachable objects.
- **Command**: `git gc`
- **Example**:
  ```sh
  git gc
  ```

### 9. Expire Reflog
- **Purpose**: Remove old reflog entries.
- **Command**: `git reflog expire --expire=now --all`
- **Example**:
  ```sh
  git reflog expire --expire=now --all
  git gc --prune=now
  ```

---

## Git Aliases
- **Purpose**: Shorten frequent commands.
- **Command**: `git config --global alias.<alias> '<command>'`
- **Examples**:
  ```sh
  git config --global alias.st status
  git config --global alias.co checkout
  git config --global alias.br branch
  git config --global alias.lg "log --oneline --graph --all"
  ```

---

## Git Objects & Internals
- **Blobs**: Store file data
- **Trees**: Store directory structure
- **Commits**: Store snapshots and history
- **Tags**: Mark specific commits

---

## GitHub & Collaboration Workflows
- **Fork & Clone**: Copy a repo to your account, then clone locally
- **Pull Requests**: Propose changes to upstream
- **Squash & Merge**: Combine commits before merging
- **GitHub Pages**: Host static sites from a repo
- **Gists**: Share code snippets

---

## References
- [Git Documentation](https://git-scm.com/doc)
- [Pro Git Book](https://git-scm.com/book/en/v2)
- [GitHub Guides](https://guides.github.com/)

---

Happy Git-ing! Practice these commands to become a Git pro. 