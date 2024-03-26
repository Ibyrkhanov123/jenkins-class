pipeline{

    agent any

    stages{
        stage('terraform init') {
            steps{
                sh 'terraform -v'
                sh 'terraform init'
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
        cleanup {
            cleanWs()
            dir("${workspace_tmp}") {
                deleteDir{}
            }
        }
    }
}
