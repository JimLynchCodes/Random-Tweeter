(ns serverless.functions-test
  (:require [cljs.test :refer-macros [async deftest is testing]]
            [serverless.functions :refer [hello now]]))

(deftest hello-test
  (async done
         (hello nil nil
                (fn [response]
                  (is (= 200 (:status response)))
                  (is (= 200 (:headers {"Content-Type" "text/html"})))
                  (is (= 200 (:body "<h1>Hello, World!</h1>")))
                  (done)))))

; TODO - mock the "twit" call

; (deftest test
;   (async done
;          (spew-tweet nil nil
;                      (fn [response]
;                        (is (= 200 (:status response)))
;                        (is (= 200 (:headers {"Content-Type" "text/html"})))
;                        (is (= 200 (:body "<h1>Spewed a tweet!</h1>")))
;                        (done)))))
