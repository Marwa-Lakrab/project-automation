pipeline {
    agent any

    environment {
        // Définir les variables pour les rapports Cucumber
        CUCUMBER_JSON = 'target/cucumber-report.json'
        CUCUMBER_HTML = 'target/cucumber-report.html'
    }

    stages {
        stage('Checkout') {
            steps {
                // Récupérer le code source depuis le dépôt Git
                checkout([$class: 'GitSCM', 
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[url: 'https://github.com/Marwa-Lakrab/project-automation.git']]
                ])
            }
        }

        stage('Install Dependencies') {
            steps {
                // Installer les dépendances via Maven sans exécuter les tests
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // Exécuter les tests Cucumber et générer les rapports JSON et HTML
                sh """
                    mvn test \
                    -Dcucumber.options="--plugin json:${CUCUMBER_JSON} --plugin html:${CUCUMBER_HTML} --tags @click" 
                """
            }
        }

        stage('Publish Cucumber Report') {
            steps {
                // Publier les résultats du rapport Cucumber dans Jenkins
                cucumber fileIncludePattern: '**/cucumber-report.json',
                         jsonReportDirectory: 'target'
            }
        }

        stage('Archive Reports') {
            steps {
                // Archiver les rapports JSON et HTML générés
                archiveArtifacts artifacts: "${CUCUMBER_JSON}, ${CUCUMBER_HTML}", allowEmptyArchive: false
            }
        }
    }

    post {
        always {
            // Toujours publier les résultats des tests JUnit (même en cas d'échec)
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
