pipeline {
    agent any

    environment {
        // Variables pour les rapports Cucumber
        CUCUMBER_JSON = 'target/cucumber-report.json'
        CUCUMBER_HTML = 'target/cucumber-report.html'
    }

    stages {
        stage('Checkout') {
            steps {
                // Récupération du code depuis le repository Git
                checkout([$class: 'GitSCM', 
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[url: 'https://github.com/Marwa-Lakrab/project-automation.git']]
                ])
            }
        }

        stage('Install Dependencies') {
            steps {
                // Installation des dépendances avec Maven sans exécuter les tests
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // Exécution des tests Cucumber avec Maven et génération des rapports JSON et HTML
                sh """
                    mvn test \
                    -Dcucumber.plugin=json:${CUCUMBER_JSON} \
                    -Dcucumber.plugin=html:${CUCUMBER_HTML}
                """
            }
        }

        stage('Publish Cucumber Report') {
            steps {
                // Publication du rapport Cucumber dans Jenkins
                cucumber fileIncludePattern: "${CUCUMBER_JSON}", 
                         jsonReportDirectory: "target"
            }
        }

        stage('Archive Reports') {
            steps {
                // Archivage des rapports générés (JSON et HTML)
                archiveArtifacts artifacts: "${CUCUMBER_JSON}, ${CUCUMBER_HTML}", allowEmptyArchive: false
            }
        }
    }

    post {
        always {
            // Publication des résultats des tests unitaires (JUnit)
            junit 'target/surefire-reports/*.xml'
        }
    }
}
