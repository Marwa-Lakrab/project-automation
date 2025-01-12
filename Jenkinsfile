pipeline {
    agent any

    environment {
        CUCUMBER_RESULTS = 'target/cucumber-report'
        CUCUMBER_HTML = 'target/cucumber-html-report.html'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', 
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[url: 'https://github.com/Marwa-Lakrab/project-automation.git']]
                ])
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                script {
                    sh 'mvn test -Dcucumber.plugin=html:${CUCUMBER_HTML} -Dcucumber.plugin=json:${CUCUMBER_RESULTS}/cucumber.json'
                }
            }
        }

        stage('Publish Cucumber Report') {
            steps {
                script {
                    // Utilisez le plugin Cucumber Reports de Jenkins
                    cucumber fileIncludePattern: "${CUCUMBER_RESULTS}/cucumber.json", 
                             jsonReportDirectory: "${CUCUMBER_RESULTS}"
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml' // Assurez-vous que les rapports JUnit sont également archivés
        }
    }
}
