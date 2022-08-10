folderName = 'myjobs'

folder(folderName) {
    description('My Jobs')
}

job = freeStyleJob("$folderName/test-job")
job.with {
    description('<em style="color: red;">GENERATED JOB - MANUAL CHANGES WILL BE OVERWRITTEN</em>')
    wrappers {
        colorizeOutput()
    }
}

job.with {
    logRotator {
        numToKeep(30)
    }
}

job.with {
    steps {
        shell 'echo test'
    }
}
