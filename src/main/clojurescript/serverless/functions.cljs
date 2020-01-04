(ns serverless.functions
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.nodejs :as nodejs]
            [twit :as twit]
            [cljs.core.async :refer [put! chan <!]]))

(nodejs/enable-util-print!)
(defonce moment (nodejs/require "moment"))

(defn hello [event ctx cb]
  (println ctx)
  (cb nil (clj->js
           {:statusCode 200
            :headers    {"Content-Type" "text/html"}
            :body       "<h1>Hello, World!</h1>"})))


(defn now [event ctx cb]
  (println ctx)
  (cb nil (clj->js
           {:statusCode 200
            :headers    {"Content-Type" "text/html"}
            :body       (str "<h1>" (.format (moment.) "LLLL") "</h1>")})))

(defn loadTweets []
  [{:status "This is my first tweet from #ClojureScript :)"}])

(defn sendTweet [randomTweet event]
  (let [tweetChannel (chan)
        Twitter (new twit (clj->js (:creds (:body event))))]
    (.post Twitter "status/update" (clj->js {:status (:status randomTweet)})
           (fn [err data]
               ; TODO - put in better eerror handling!
             (put! tweetChannel [data err])))))

        ; TODO - get a random one, not just the first one!
(defn tweet [event ctx cb]
  (println ctx)
  (println "Spewing Tweet!")
  (let [tweets (loadTweets)
        randomTweet (first (loadTweets))]

    (let [randomTweet {:status "ok then"}])
    (println tweets)
    (go
      (<! (sendTweet randomTweet event))
      (println (str "successfully send tweet!"))
      (cb nil (clj->js
               {:statusCode 200
                :headers    {"Content-Type" "text/html"}
                :body       (str "<h1>Another swell tweet! " (:status randomTweet) " at " ((.format (moment.) "LLLL")))})))))

(set! (.-exports js/module) #js
                             {:hello hello
                              :now now
                              :tweet tweet
                              })