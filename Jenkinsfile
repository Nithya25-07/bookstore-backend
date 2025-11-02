pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                checkout scm
            }
        }

        stage('Build Backend') {
            steps {
                echo 'Building backend with Maven...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy Locally') {
            steps {
                echo 'Starting backend JAR...'
                bat 'start java -jar target\\bookstore-backend-1.0.0.jar'
            }
        }
    }

    post {
        success {
            echo '✅ Build and deployment successful!'
        }
        failure {
            echo '❌ Build failed. Please check Jenkins logs.'
        }
    }
}
