pipeline {
    agent any

    stages {
        stage('Checkout'){
            steps {
                git branch: 'main', url: 'https://github.com/VineshNair83/jgsu-spring-petclinic.git'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
