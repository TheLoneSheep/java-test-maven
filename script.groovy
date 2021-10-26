def buildApp() {
    echo 'building the application...'
}

def testApp() {
    echo 'testing the application...'
    echo 'executing pipeline for branch ${BRANCH_NAME}'
}

def deployApp() {
    echo 'deploying the application...'
    echo "deploying version ${params.VERSION}"
}

return this