# Message-processor
This repository contains a test message processor project.<br />
**Note:-** This is only supported for the single customer(jal - hardcoded) but can extend for multiple customers. 

**Steps to execute.**
1. Need to start at least three instances like the following image.
![alt text](https://github.com/prabathariyaratna/message-processor/blob/master/files/diagram_001.png "diagram")

2. Setup simple NGIX load balancer in front of the three nodes.

3. Use this [file](https://github.com/prabathariyaratna/message-processor/blob/master/files/request.txt) to create and execute the sample request to test the setup.
![alt text](https://github.com/prabathariyaratna/message-processor/blob/master/files/diagram_002.png "diagram")<br />
**Note:-** Highlighted details need to be changed to create multiple FHL(sample - only to demonstrate the sample) messages with different Master AWBs.
   
