def call() {
    node {
        bat '''
        cd %projectName%
        mvn clean install -DskipTests=true versions:set -DnewVersion='%version%' versions:update-child-modules
        '''
    }
}