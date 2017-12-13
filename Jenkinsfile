pipeline {
  agent none
  stages {
    stage('error') {
      steps {
        retry(count: 1) {
          sleep 1
        }
        
      }
    }
  }
}