pipeline {
    agent any
    parameters {
        string(name: 'STRING_PARAM', description: 'Enter a string', defaultValue: 'Default Value')
    }
    stages {
        stage('string_param') {
            steps {
                echo "${params.STRING_PARAM}"
            }
        }
    }
}