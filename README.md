# Path-find
Path-find is a desktop application for visualizing path finding algorithms. The user can visualize any of the following algorithms:
- **Breadth-First Search (BFS)**
- **Depth-First Search (DFS)**
- **Dijkstra's Algorithm**
- **A-Star (A\*) Algorithm**
- **Bidirectional Search**
---
## Table of Contents
- [Installation](#installation)
- [How to use](#how-to-use)
- [License](#licence)
---
## Installation
To be able to properly use the application, make sure you have at least the `21.0.3 JDK version` and that  the JDK path is set in the environment variables. Click [here](https://adoptium.net/temurin/releases/) to find the latest OpenJDK version. Further tutorials of setting up the environment can be found online.
You can check your java version by opening the `cmd` and typing: 
```bash
java -version
```
### Building the project
```bash
# Open a terminal (Command Prompt or PowerShell for Windows, Terminal for macOS or Linux)

# Ensure Git is installed
# Visit https://git-scm.com to download and install console Git if not already installed

# Clone the repository
git clone https://github.com/phantomCat1/Path-find.git

# Navigate to the project directory
cd Path-find

# Compile the source files
javac -d classes src/main/java/gui/*.java src/main/java/model/*.java src/main/java/solvers/*.java

# For Linux, you can simply run
javac -d classes src/**/*.java

# Navigate to the previously created classes directory, where the clss files are stored
cd ../classes

# To run the project
java gui.MainFrame

```
---
## Usage
While running the application, the user can click on any cell to set the **starting** and **ending** cells. 
The user can then click or drag across the cells to create **walls**, i.e. obstacles. The user can also click on the **Eraser** radio button to enable erasing and modification of the cells, which is performed through clicking for the **starting** and **ending** cells and clicking or dragging for the **walls**.
Pressing the **Solve** button allows the user to choose the path finding algroithm (s)he wishes to use. During the execution of the algorithm, the user can see the order in which cells are being explored, adjust the execution speed using the slider and  Stop the execution using the **Stop** button. At the end of the exploration, the final traced path is colored yellow. 
Finally, the user can choose to reset the cells in any way (s)he wishes to using the buttons of the **Stop** panel.
The above instructions can also be seen by clicking on the **Help** button.

---
## License
This project is licensed under the MIT License. See the [LICENSE](https://github.com/phantomCat1/Path-find/tree/main?tab=MIT-1-ov-file) section for more details.
