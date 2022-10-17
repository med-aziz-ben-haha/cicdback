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
                

  sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.1 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/cicdback/ -Dfile=target/tpAchatProject-1.1.jar'
                
               
            }
        }

     
}
	
	    
        post {
		success{
		emailext attachLog: true, body: '''Dear Med Aziz,
we\'re happy to inform you that your pipeline build was successful.
Great work !
-Jenkins Team-''', subject: 'Build result - Success', to: 'mohamedaziz.benhaha@esprit.tn'
		}
		
		failure{
		emailext attachLog: true, body: '''Dear Med Aziz,
we\'re sorry to inform you that your pipeline build failed.
Keep working !
-Jenkins Team-''', subject: 'Build result - Failure', to: 'mohamedaziz.benhaha@esprit.tn'
		}
		
        always {
            cleanWs()
        }
    }

    
	
}
       
