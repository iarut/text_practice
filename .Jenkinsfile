pipeline {
    agent any
    environment {
        JAVA_HOME = "${env.JAVA_HOME_11}" // Используем JDK 11
        GRADLE_OPTS = "-Dorg.gradle.daemon=false -Dorg.gradle.caching=true"
    }
    stages {
        stage('Checkout') {
            steps {
                // Клонируем репозиторий
                checkout scm
            }
        }
         // Шаг 2: Запуск тестов
                stage('Run Tests') {
                    steps {
                        // Запуск тестов с флагами для CI-окружения
                        sh './gradlew test --no-daemon --stacktrace --continue'
                    }
                    post {
                        // Всегда публикуем отчеты, даже если тесты упали
                        always {
                            // JUnit отчет для Jenkins
                            junit 'build/test-results/test/**/*.xml'

                            // HTML отчет (требует plugin HTML Publisher)
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
//                  Запускаем сборку Gradle (предполагается, что используется оболочка Gradle Wrapper)
                 sh 'chmod +x gradlew'
                sh './gradlew clean build'
             }
         }
          post {
                 // Действия после выполнения пайплайна
                 always {
                     echo "Статус выполнения: ${currentBuild.currentResult}"
                     script {
                         // Очистка после сборки (опционально)
                         if (currentBuild.currentResult == 'SUCCESS') {
                             cleanWs()
                         }
                     }
                 }
                 failure {
                     echo 'Обнаружены ошибки в тестах!'
                     // mail to: 'team@example.com', subject: 'Тесты провалены', body: "См. детали: ${env.BUILD_URL}"
                 }
             }
    }
}