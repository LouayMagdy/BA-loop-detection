
# BA-loop-detection
A basic starting prototype for loop detection and sketching using springboot and reactjs for BA internship

# Agenda
- [Backend Section](#backend-section)
- [Frontend Section](#frontend-section)
- [Sample Example](#sample-example)

<a name="-backend-section"></a>
## Backend Section
The backend Logic flows as follows:
- Getting Self Loops if found ... implemented in **getSelfLoops() method** in [GraphFactory class](./loop-detection-backend/src/main/java/com/example/loopdetectionbackend/service/GraphFactory.java/)
- Forming the graph out of the edges ... implemented in **makeGraph() method** in [GraphFactory class](./loop-detection-backend/src/main/java/com/example/loopdetectionbackend/service/GraphFactory.java/)
- **_Johnson's Algorithm_ Implementation** to find all graph cycles. The algorithm works as follows:
    1) Getting all SCCs of sizes > 1 using **Tarjan's Algorithm** ... implemented in [SCCTarjanGetter class](./loop-detection-backend/src/main/java/com/example/loopdetectionbackend/service/SCCTarjanGetter.java/)
    2) Getting loops from SCCs starting with least-number-vertex ... implemented in [LoopDetectorService Class](./loop-detection-backend/src/main/java/com/example/loopdetectionbackend/service/LoopDetectorService.java/)
- find more about _Johnson's Algorithm_ [here](https://www.cs.tufts.edu/comp/150GA/homeworks/hw1/Johnson%2075.PDF)

<a name="-frontend-section"></a>
## Frontend Section
It is composed of parent page implemented in [Welcome_page](./loop-detection-frontend/src/welccome_page/) and having 2 components:
## 1) [Form page](./loop-detection-frontend/src/form/)
  It contains the following:
  - Website Title and Rules.
  - CSV parser to parse the edge file after being uploaded.
  - the content is passed to [Welcome_page](./loop-detection-frontend/src/form/) to map vertices' names into numbers.
## 2) [Result page](./loop-detection-frontend/src/result/)
  It contains the following:
  - Sketching of each loop using **vis.js Library**
  - Pagination buttons to view other loops
    
<a name="-sample-example"></a>
## Sample Example
You can find 3 test samples in [tests](./loop-detection-frontend/src/test/), let's try to upload each of them:
1) Uploading [test.csv](./loop-detection-frontend/src/test/test.csv/)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/5a6aaf0e-767a-4f21-b6b5-dc50c053f2dc)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/237ce310-7208-483a-918b-aa67dc0b5edd)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/57b241dc-41f5-4fbe-94ad-a1e769c72269)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/e842d88d-1c3e-44c9-94cd-8b44f4dfee9e)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/22dd9991-c62d-4496-b746-8dcc8ccc8d5d)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/07f62787-1c58-465b-9722-c8320664e020)

2) Uploading [test2.csv](./loop-detection-frontend/src/test/test2.csv/)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/c7b8b59f-e420-44ed-83c4-4469a3a0c8fa)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/2e4b24bb-1021-44da-b5b4-02dd5a0c5f03)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/7cf1add1-7503-4597-8347-b9a05eace00f)

3) Uploading [tes3.csv](./loop-detection-frontend/src/test/tes3.csv/)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/9025d91b-5f8d-49fe-949d-5ab05043a993)


