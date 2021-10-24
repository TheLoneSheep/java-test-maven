
pipeline {

  agent any
  parameters { //parametrize your build
    //string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
  }
  tools {
    maven-3.8 'Maven' //access build tools in your project. So in this one, you can use maven commands later in the file
  }

  stages {
    
    stage("build") {
      steps {
        echo "building the application..."
        echo "building version ${NEW_VERSION}"
      }
    
    }
    
    stage("test") {
      when {
        expression {
            params.executeTests // == true
        }
      }
      steps {
        echo "testing the application..."
      }
    
    }
    
    stage("deploy") {
      steps {
        echo "deploying the application..."
        echo "deploying version ${params.VERSION}"
//         withCredentials([
//             usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
//         ]) {
//             sh "some script ${USER} ${PWD}"
//         }
      }
    }
  }

}
