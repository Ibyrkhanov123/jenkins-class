pipeline{

    agent any

    stages{
        stage('stage1') {
            steps{
                echo 'checking webhook connection'
                echo 'checking new file from GitHub repo'
            }
        }
        stage('stage2') {
            steps{
                echo 'checking for webhook work'
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
            dir("${workspace_tmp}"){
                deleteDir()
            }
        }
    }
}