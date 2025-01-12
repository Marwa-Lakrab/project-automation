pipeline {
    agent any

    environment {
        ALLURE_RESULTS = 'allure-results'
        ALLURE_REPORT = 'target/allure-report'
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

        stage('Run Tests & Generate Reports') {
            steps {
                sh 'mvn test -Dsurefire.useFile=false -Dallure.results.directory=${ALLURE_RESULTS}'
            }
        }

        stage('Generate Allure Report') {
            steps {
                sh 'allure generate ${ALLURE_RESULTS} -c -o ${ALLURE_REPORT}'
            }
        }

        stage('Archive Artifacts') {
            steps {
                script {
                    if (fileExists("${ALLURE_RESULTS}")) {
                        archiveArtifacts artifacts: "${ALLURE_RESULTS}/**"
                    }
                    if (fileExists("${ALLURE_REPORT}")) {
                        archiveArtifacts artifacts: "${ALLURE_REPORT}/**"
                    }
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            allure includeProperties: false, jdk: '', results: [[path: "${ALLURE_RESULTS}"]]
        }
    }
}
