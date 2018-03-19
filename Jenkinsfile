node {
   def commit_id
   stage('Preperation') {
     checkout scm
     sh "git rev-parse --short HEAD > .git/commit-id"
     commit-id= readFile('.git/commit-id').trim()
   }
   stage('test') {
     nodejs(nodeJSInstallationName: 'nodejs') {
       sh 'npm install --only=dev'
       sh 'npm test'
     }
   }
   stage ('docker bulid/push') {
     docker.withRegistry('https://index.docker.io/v1/','dockerhub') {
       def app = docker.build("wardvaiene/docker-nodejs-demo:${commit-id}",'.').push()
       }
     }
   }
   
