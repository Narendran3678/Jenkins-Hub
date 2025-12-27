def call() {
    node {
        bat '''
            java --version
            git --version
            mvn --version
        '''
    }
}