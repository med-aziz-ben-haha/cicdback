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
        

       
        

     
} 
}
       
