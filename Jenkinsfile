pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }


    stages {
    
    
        stage('Getting project from Git') {
            steps{
      			checkout([$class: 'GitSCM', branches: [[name: '*/aziz']], 
			extensions: [], 
			userRemoteConfigs: [[url: 'https://github.com/med-aziz-ben-haha/cicdback.git']]])
            }
        }
        
        
    
        stage('Cleaning the project') {
            steps{
                	sh "mvn -B -DskipTests clean  " 
            }
        }
        
        
    
        stage('Artifact Construction') {
            steps{
                	sh "mvn -B -DskipTests package " 
            }
        }
        
    
    
         stage('Unit Tests') {
            steps{
               		 sh "mvn test " 
            }
        }
        

       
       
        stage('Code Quality Check via SonarQube') {
            steps{
                
             		sh "  mvn sonar:sonar -Dsonar.projectKey=cicdback -Dsonar.host.url=http://172.10.0.140:9000 -Dsonar.login=263ecdbb74d2e43946778c5cebdd6de100062780"
 
            }
        }
    

        stage('Publish to Nexus') {
            steps {
                

  sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://172.10.0.140:8081/repository/cicdback/ -Dfile=target/tpAchatProject-1.0.jar'
                
               
            }
        }

     
}
	
	    


    
	
}
       
