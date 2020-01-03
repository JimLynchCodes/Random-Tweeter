
# Random Tweeter

Randomly tweets a Twitter tweet from a pool of potential tweets.

# Usage

Switch to node vX.X
```
nvm use
```

# Packaged As A Lambda Function
This project uses the serverless project template, so the project is build to be dployed as a lambda function. However, you can still just always run it locally if you wish. 


## To Run Locally, Simulating A Deployed Lambda Running
```
sls offline start
```

Then you can call the endpoint at http://localhost:8000/tweet


## To Run Locally Once And Then Exit The Process
```
sls invoke
```

# Twitter Credentials

When you POST to the send `tweet` endpoint, send in your Twitter credentials like this:
```
{   
  "creds": {     
    "consumer_key": "XXXXXXXXXXXXXXX",     
    "consumer_secret": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",     
    "access_token": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",     
    "access_token_secret": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"   
  } 
}
```

# Configuring The Tweet Pool
The "tweetpool.json" file can be modified to change the content of the tweets in the tweet pool.



================================

# Uses Serverless AWS Clojurescript Gradle Template

This project compiles **Clojurescript** to a [NodeJS](https://nodejs.org/en/) module using the [Gradle Clojure Plugin](https://gradle-clojure.github.io/gradle-clojure/index.html).

### NodeJS Support

Rudimentary support for loading/using **NodeJS** modules is provided.

See [functions.cljs](./src/main/clojurescript/serverless/functions.cljs) as an example.

To include **NodeJS** dependencies, modify [build.gradle](./build.gradle) and add the module to the `closurescript .. npmDeps` section.

### Prerequisites

- Create an [Amazon Web Services](https://aws.amazon.com) account
- Install and set-up [Serverless Framework CLI](https://serverless.com)
- Install [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- Install [NPM](https://www.npmjs.com/get-npm)
- Install [Clojure](https://clojure.org/guides/getting_started)
- Install [Gradle](https://gradle.org/install/)

### Build and Deploy

- To build, run `./gradlew clean build`
- To deploy, run `serverless deploy`

### Using the Repl in IntelliJ Cursive IDE

This project contains a [script](./scripts/node_repl.clj) the must be initialized in order to use the **Repl** in **IntelliJ**.

![](http://share.rowellbelen.com/5WvFH2+)


## From Scratch Guide
If you would like to recreate this project from scratch you can follow the below documented steps.

This project was scaffodled with the serverless aws-clojurescript-gradle template!
```
sls create --template aws-clojurescript-gradle
```

Installed "twit" javascript twitter library
```
npm i twit
```

Added "serverless-offline" as a plugin in `serverless.yml`:
```
plugins:
  - serverless-offline
```
