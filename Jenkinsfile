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
                script {
                    
configFileProvider([configFile(fileId: 'fccdf24e-aa6d-44a1-9aa7-2db0076915e4', variable: 'settingnexus')]){
  sh 'mvn  -B -DskipTests deploy -s $settingnexus'}
                
                }
            }
        }

     
}
	
	    


    
	
}
       
