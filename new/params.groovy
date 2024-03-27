pipeline{
    agent any
    parameters {
        string{name: 'USER_NAME', description: 'Who is running the pipeline?' , defaultValue: 'admin'}
    }

    stages {
        steps {
            echo "$params.USER_NAME is running the pipeline"
        }
    }
}