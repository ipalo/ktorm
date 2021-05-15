
plugins {
    id("ktorm.module-conventions")
    id("ktorm.tuples-generation")
}

dependencies {
    compileOnly("org.slf4j:slf4j-api:1.7.25")
    compileOnly("commons-logging:commons-logging:1.2")
    compileOnly("com.google.android:android:1.5_r4")
    compileOnly("org.springframework:spring-jdbc:5.0.10.RELEASE")
    compileOnly("org.springframework:spring-tx:5.0.10.RELEASE")
    compileOnly("org.postgresql:postgresql:42.2.5")
    testImplementation("com.h2database:h2:1.4.197")
}

configurations {
    val testOutput by creating
    testOutput.extendsFrom(configurations["testImplementation"])
}

task<Jar>("testJar") {
    dependsOn("testClasses")
    from(sourceSets.test.map { it.output })
    archiveClassifier.set("test")
}

artifacts {
    add("testOutput", "testJar")
}