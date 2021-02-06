<img src="https://github.com/castor-software/depanalyzer/blob/master/.img/logo.svg" height="100px"  alt="DepAnalyzer"/>

[![Build Status](https://travis-ci.org/castor-software/depanalyzer.svg?branch=master)](https://travis-ci.org/castor-software/depanalyzer)

### What is DepAnalyzer?

DepAnalyzer allows to get a report of the dependencies used by a Java application. Given a `jar` file, DepAnalyzer 
instruments the bytecode to give a report about the name of the classes and methods of each dependency that are used, 
as computed via static analysis.

### Usage

java -jar Dep-analyzer-1.0-SNAPSHOT-jar-with-dependencies.jar "path to the jar file" "fully qualified name of the packaged dependency"

#### Example

**Input:**  

```
java -jar Dep-analyzer-1.0-SNAPSHOT-jar-with-dependencies.jar src/main/resources/descartes-1.2.4.jar org/pitest
```
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

## License

Distributed under the MIT License. See [LICENSE](https://github.com/castor-software/depanalyzer/blob/master/LICENSE.txt) for more information.

## Funding

DepClean is partially funded by the [Wallenberg Autonomous Systems and Software Program (WASP)](https://wasp-sweden.org).

<img src="https://github.com/castor-software/depanalyzer/blob/master/.img/wasp.svg" height="50px" alt="Wallenberg Autonomous Systems and Software Program (WASP)"/>