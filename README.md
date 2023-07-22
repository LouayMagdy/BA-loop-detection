# BA-loop-detection
A basic starting prototype for loop detection and sketching using springboot and reactjs for BA internship

# Agenda
- [Backend Section](#backend-section) 
- [Frontend Section](#frontend-section) 
- [Sample Examples](#sample-examples)

<a name="-backend-section"></a>
## Backend Section   
The backend is implemented using **_SpringBoot_** <a><img width ='32px' src ='https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png'></a> and its logic is as follows:
- Getting Self Loops if found ... implemented in **getSelfLoops() method** in [GraphFactory class](./loop-detection-backend/src/main/java/com/example/loopdetectionbackend/service/GraphFactory.java/)
- Forming the graph out of the edges ... implemented in **makeGraph() method** in [GraphFactory class](./loop-detection-backend/src/main/java/com/example/loopdetectionbackend/service/GraphFactory.java/)
- **_Johnson's Algorithm_ Implementation** to find all graph cycles. The algorithm works as follows:
    1) Getting all SCCs of sizes > 1 using **Tarjan's Algorithm** ... implemented in [SCCTarjanGetter class](./loop-detection-backend/src/main/java/com/example/loopdetectionbackend/service/SCCTarjanGetter.java/)
    2) Getting loops from SCCs starting with least-number-vertex ... implemented in [LoopDetectorService Class](./loop-detection-backend/src/main/java/com/example/loopdetectionbackend/service/LoopDetectorService.java/)
    3) Re-form the graph again neglecting the start index and repeat the above two steps ... implemented in [LoopDetectorService Class](./loop-detection-backend/src/main/java/com/example/loopdetectionbackend/service/LoopDetectorService.java/)
- find more about _Johnson's Algorithm_ [here](https://www.cs.tufts.edu/comp/150GA/homeworks/hw1/Johnson%2075.PDF)

<a name="-frontend-section"></a>
## Frontend Section  
It is implemented using **_ReactJs_**  <a> <img width ='32px' src ='https://raw.githubusercontent.com/rahulbanerjee26/githubAboutMeGenerator/main/icons/reactjs.svg'> </a> and composed of parent page implemented in [Welcome_page](./loop-detection-frontend/src/welccome_page/) and having 2 components:
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
## Sample Examples
You can find 3 test samples in [tests](./loop-detection-frontend/src/test/), let's try to upload each of them:
1) Uploading [test.csv](./loop-detection-frontend/src/test/test.csv/)
   
![image](https://github-production-user-asset-6210df.s3.amazonaws.com/95547833/255023037-5a6aaf0e-767a-4f21-b6b5-dc50c053f2dc.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20230722%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230722T121438Z&X-Amz-Expires=300&X-Amz-Signature=84c25e8b032eaceb88979480c4736a02b4612277d2d509f31b80164c12a7992f&X-Amz-SignedHeaders=host&actor_id=95547833&key_id=0&repo_id=668342181)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/8c11c9fa-00b3-4239-aaea-c200d7c12c14)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/0659e2b5-f1b1-45ad-961f-735d0b1bf539)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/8f1d509a-6895-4c0f-b281-3c32758990e9)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/aa4709e0-fade-43e6-b420-e0f161b1fe92)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/f47516f8-4279-42e7-bf52-471915ff8569)


2) Uploading [test2.csv](./loop-detection-frontend/src/test/test2.csv/)

![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/ac44a443-8f62-46c2-af51-5554357c68e8)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/b0fab068-cdbf-4fdc-804f-c681a7fc4fe5)
![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/a822e07b-2e4f-4dbb-96ed-38d407b4d65f)

3) Uploading [tes3.csv](./loop-detection-frontend/src/test/tes3.csv/)

![image](https://github.com/LouayMagdy/BA-loop-detection/assets/95547833/f97fa496-eaf4-474a-89e2-9cd948c99d3d)


