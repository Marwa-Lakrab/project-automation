pipeline {
    agent any

    environment {
        CUCUMBER_JSON = 'target/cucumber-report.json'
        CUCUMBER_HTML = 'target/cucumber-report.html'
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
                    // Commande Maven pour exécuter les tests et générer JSON et HTML
                    sh """
                        mvn test \
                        -Dcucumber.plugin=json:${CUCUMBER_JSON} \
                        -Dcucumber.plugin=html:${CUCUMBER_HTML}
                    """
                }
            }
        }

        stage('Publish Cucumber Report') {
            steps {
                script {
                    cucumber fileIncludePattern: "${CUCUMBER_JSON}", 
                             jsonReportDirectory: "target"
                }
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: "${CUCUMBER_JSON}, ${CUCUMBER_HTML}", allowEmptyArchive: false
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml' // Résultats des tests unitaires
        }
    }
}
