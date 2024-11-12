# Path-find
Path-find is a desktop application for visualizing path finding algorithms. The user can visualize any of the following algorithms:
- BFS
- DFS
- Dijkstra
- A-Star
- Bidirectional
---
## Installation
To be able to properly use the application, make sure you have at least the `21.0.3 JDK version` and that  the JDK path is set in the environment variables. Click [here](https://adoptium.net/temurin/releases/) to find the latest OpenJDK version. Further tutorials of setting up the environment can be found online.
You can check your java version by opening the `cmd` and typing: 
`java -version`
#### Cloning the project
To install the project, first clone the repository by running:
`git clone https://github.com/phantomCat1/Path-find.git`

#### Compiling the source files
Navigate inside the directory. Now you need to compile the files by running:
`javac -d classes src/main/java/gui/*.java src/main/java/model/*.java src/main/java/solvers/*.java`

For Linux, you can run:
`javac -d classes src/**/*.java`

#### Running the project
To finally run the project, navigate to the `classes` directory created previously:
`cd ../classes`
Finally, run:
`java gui.MainFrame`

----
## How to use
While running the application, the user can click on any cell to set the **starting** and **ending** cells. 
The user can then click or drag across the cells to create **walls**, i.e. obstacles. The user can also click on the **Eraser** radio button to enable erasing and modification of the cells, which is performed through clicking for the **starting** and **ending** cells and clicking or dragging for the **walls**.
Pressing the **Solve** button allows the user to choose the path finding algroithm (s)he wishes to use. During the execution of the algorithm, the user can see the order in which cells are being explored, adjust the execution speed using the slider and  Stop the execution using the **Stop** button. At the end of the exploration, the final traced path is colored yellow. 
Finally, the user can choose to reset the cells in any way (s)he wishes to using the buttons of the **Stop** panel.
The above instructions can also be seen by clicking on the **Help** button.
---
## License
This project is licensed under the MIT License. See the [LICENSE](https://github.com/phantomCat1/Path-find/tree/main?tab=MIT-1-ov-file) section for more details.
