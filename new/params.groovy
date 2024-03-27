pipeline{
    agent any
    parameters {
        string(name: 'USER_NAME', description: 'Who is running the pipeline?' , defaultValue: 'admin', trim: true)
    }

    stages {
        stage('stage1'){
            steps {
                echo "$params.USER_NAME is running the pipeline"
                echo "${params.USER_NAME} is running the pipeline"
            }
        }
    }
}