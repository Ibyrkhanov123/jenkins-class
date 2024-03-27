pipeline{
    agent any
    parameters {
        booleanParam(name: 'DEPLOY_PROD', description: 'iS it deploying to PROD')
    }

    stages {
        stage('check'){
            steps {
                sh "echo DEPLOY_PROD: ${params.DEPLOY_PROD}" 
            }
        }
    }
}