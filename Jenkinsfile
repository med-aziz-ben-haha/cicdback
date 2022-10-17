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
                
             		sh "  mvn sonar:sonar -Dsonar.projectKey=cicdback -Dsonar.host.url=http://172.10.0.140:9000 -Dsonar.login=3d562f0bfa2bb060e5e1c63252d0e9ed6680797c"
 
            }
        }
       
        

     
} 
}
       
