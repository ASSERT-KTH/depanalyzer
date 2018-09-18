[![Build Status](https://travis-ci.org/castor-software/dep-analyzer.svg?branch=master)](https://travis-ci.org/castor-software/dep-analyzer)
# Dep-analyzer: Analysis of dependencies at the bytecode level

Instruments the code to print the name of the classes and methods of a package used by a given jar file.

## Usage

java -jar Dep-analyzer-1.0-SNAPSHOT-jar-with-dependencies.jar "path to the jar file" "fully qualified name of the packaged dependency"

### Example

**Input:**
java -jar Dep-analyzer-1.0-SNAPSHOT-jar-with-dependencies.jar src/main/resources/descartes-1.2.4.jar org/pitest

**Output:**
```
Class: eu/stamp_project/mutationtest/descartes/reporting/JSONReportFactory.class
	Class used: org/pitest/mutationtest/ListenerArguments    Methods used: [getStartTime, getEngine, getOutputStrategy]
	Class used: org/pitest/mutationtest/engine/MutationEngine    Methods used: [getMutatorNames]
Class: eu/stamp_project/mutationtest/descartes/reporting/models/MethodRecord.class
	Class used: org/pitest/classinfo/ClassName    Methods used: [getNameWithoutPackage, asInternalName, getPackage, asJavaName]
	Class used: org/pitest/mutationtest/ClassMutationResults    Methods used: [getMutations]
	Class used: org/pitest/mutationtest/DetectionStatus    Methods used: [isDetected]
	Class used: org/pitest/mutationtest/MutationResult    Methods used: [getDetails, getStatus]
	Class used: org/pitest/mutationtest/engine/Location    Methods used: [getMethodName, equals, getMethodDesc, getClassName]
    ...
```




