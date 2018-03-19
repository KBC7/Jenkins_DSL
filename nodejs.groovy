job('NOdejs Example')
  scm {
      git ('git://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.gitSCM
           node / gitConfigName('DSL User')
      }
  }
  triggers {
      scm('H/5 * * * *')
  }
  wrappers {
      nodejs('nodejs') // Manage jenkins->Configure tool->NodeJS INstallation -->name
  }
  steps {
      shell('npm install')
  }
