pipeline {
    agent any
    parameters {
        choice(name: "APPLY_DESTROY", description: "Select apply or destroy", choices: ['Apply', 'Destroy'])
    }
    stages {
        stage('tf-version') {
            steps {
                echo "Running Tf-Version"
                sh "terraform -v"
            }
        }
        stage('tf-init') {
            steps {
                dir("app-infra") {
                    echo "Running Tf-init"
                    sh "terraform init"
                }
            }
        }
        stage('tf-validate') {
            steps {
                dir("app-infra") {
                    echo "running Tf-Validate"
                    sh "terraform validate"
                }
            }
        }
        stage('tf-plan') {
            steps {
                dir("app-infra") {
                    echo "running Tf-plan"
                    sh "terraform plan"
                }
            }
        }
        stage('tf-apply') {
            steps {
                dir("app-infra") {
                    echo "running Tf-apply/destroy"
                    script {
                        if (params.APPLY_DESTROY == 'Apply') {
                            sh "terraform apply --auto-approve"
                        } else {
                            sh "terraform destroy --auto-approve"
                        }
                    }
                }
            }
        }
    }
    post {
        success {
            echo "The pipeline ran successfully"
        }
        failure {
            echo "The pipeline failed :("
        }
        always {
            cleanWs()
        }
    }
}
