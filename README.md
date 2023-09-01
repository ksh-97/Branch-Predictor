
# Branch Predictor

### Key Features 
• Improved the processor performance in case there is a branching instruction

• Designed Bimodal, GShare, GAp, PAg, PAp branch predictor with given memory constraints for the given trace

• Improved the predictors by tuning the register sizes to achieve an accuracy of up to 96%

### Framework
• The folder traces contains five traces of branch instructions against which the predictor is tested. 
• maximum predictor size = (i) 2400 bits, (ii) 6400 bits and (iii) 9999 bits (iv)32000 bits for different cases
• Run the following commands:
	– ant clean: to clean class files and jar files from previous builds.
	– ant: to compile the java files.
	– ant make-jar: to create a jar file (akin to an X86 executable).
	– java -jar jar/BranchPredictor.jar traces/trace1 2400: this runs the simulator with the input trace trace1. It also tells the simulator that the maximum allowed predictor size is 2400bits.
	
###  Evaluating the design
 Tested using python test.py which gives accuracy and if the size has been exceeded
 
![image](https://github.com/ksh-97/Branch-Predictor/assets/97159706/44796fa5-1f1e-4e6d-8f60-d1c1751dad5b)

