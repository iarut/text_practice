pipeline {
    agent any
    environment {
        JAVA_HOME = "${env.JAVA_HOME_11}" // Use JDK 11
        GRADLE_OPTS = "-Dorg.gradle.daemon=false -Dorg.gradle.caching=true"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Run Tests') {
            steps {
                sh './gradlew test --no-daemon --stacktrace --continue'
            }
            post {
                always {
                    junit 'build/test-results/test/**/*.xml'
                    publishHTML(
                        target: [
                            allowMissing: true,
                            alwaysLinkToLastBuild: true,
                            keepAll: true,
                            reportDir: 'build/reports/tests/test',
                            reportFiles: 'index.html',
                            reportName: 'Unit Test Report'
                        ]
                    )
                }
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
    }
    post {
        always {
            echo "Build status: ${currentBuild.currentResult}"
            script {
                if (currentBuild.currentResult == 'SUCCESS') {
                    cleanWs()
                }
            }
        }
        failure {
            echo 'Test failures detected!'
            // mail to: 'team@example.com', subject: 'Tests failed', body: "See details: ${env.BUILD_URL}"
        }
    }
}