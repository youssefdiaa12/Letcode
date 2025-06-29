pipeline {
    agent any

    tools {
        maven 'Maven 3'   // Defined in Jenkins global tools config
        jdk 'Java 17'     // Defined in Jenkins global tools config
    }

    environment {
        CHROME_DRIVER_PATH = '/usr/local/bin/chromedriver'  // Adjust as needed
    }

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/youssefdiaa12/Letcode.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Archive Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
