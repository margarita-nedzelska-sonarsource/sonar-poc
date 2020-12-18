pipeline {
  agent {
    label {
      label "master"
      customWorkspace "/u01/data/jenkins/workspace/sonar_poc_GitHub/${BRANCH_NAME}"
    }
  }
  

  tools {
    maven 'maven3' 
    jdk 'JDK1.8' 
  }
  
  options { 
    disableConcurrentBuilds() 
  }
  
  stages {   
    stage('Build Project'){
      parallel{
        stage('Build Java') {
          steps {
            sh '''
              echo "PATH = ${PATH}"
              echo "M2_HOME = ${M2_HOME}"
              mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install
            '''
          }
        }
      }
    }
    
	
    stage('Sonar Code Analysis') {
          steps {
            script {
              scannerHome = tool 'Wynyard Sonar'
            }

            withSonarQubeEnv('Wynyard Sonar') {
				sh '''
                	/u01/data/jenkins/tools/hudson.plugins.sonar.SonarRunnerInstallation/Wynyard_Sonar/bin/sonar-scanner \
              			-Dsonar.projectKey=Sonar_POC_github -Dsonar.projectName=sonar_poc_github \
              			-Dsonar.projectVersion=$2 -Dsonar.java.coveragePlugin=jacoco -Dsonar.dynamicAnalysis=reuseReports \
              			-Dsonar.skipDesign=true -Dsonar.surefire.reportPath=target/surefire-reports \
              			-Dsonar.cpd.exclusions=**/*.* -Dsonar.java.sources=1.8 -Dsonar.sourceEncoding=UTF-8 \
                        -Dsonar.qualitygate.wait=true -Dsonar.allow_failure=true -Dsonar.qualitygate.timeout=800 -Dsonar.login=admin -Dsonar.password=admin \
                        -Dsonar.modules=sonar_poc_github -Dsonar_poc_github.sonar.projectName=sonar_poc_github -Dsonar_poc_github.sonar.projectBaseDir=./src \
			-Dsonar_poc_github.sonar.sources=./main/java -Dsonar_poc_github.sonar.java.binaries=../target/classes
                '''
            }
          }
        
    }
  }

}
