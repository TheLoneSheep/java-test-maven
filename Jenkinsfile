def gv


pipeline {

  agent any
  parameters { //parametrize your build
    //string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
  }
  tools {
    maven 'maven-3.8' //access build tools in your project. So in this one, you can use maven commands later in the file
  }

  stages {
    stage("init") {
        steps {
            script {
                gv = load "script.groovy"
            }
        }
    }
    stage("build") {
      steps {
        script {
            gv.buildApp()
        }
        //echo "building the application..."
//         echo "building version ${NEW_VERSION}"
      }
    
    }
    
    stage("test") {
      when {
        expression {
            params.executeTests // == true
        }
      }
      steps {
        script {
            gv.testApp()
            }
      }
    
    }
    
    stage("deploy") {
      input {
        message "Select the environment to deploy to"
        ok "Done"
        parameters {
            choice(name: 'ENV', choices: ['dev', 'test', 'prod'], description: '')

        }
      }
      steps {
        script {
          gv.deployApp()
          echo "deploying to ${ENV}"
        }
//         echo "deploying the application..."
//         echo "deploying version ${params.VERSION}"
//         withCredentials([
//             usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
//         ]) {
//             sh "some script ${USER} ${PWD}"
//         }
      }
    }
  }

}
