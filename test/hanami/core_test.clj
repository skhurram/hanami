(ns hanami.core-test
  (:require [clojure.test :refer :all]
            [hanami.core :refer :all]))

(deftest test-jdbc-uri
  (testing "mysql"
    (is (= (jdbc-uri "postgres://localhost/postgres")
           "jdbc:postgresql://localhost/postgres"))
    (is (= (jdbc-uri "postgres://foo:foo@heroku.com/hellodb")
           "jdbc:postgresql://heroku.com/hellodb?user=foo&password=foo"))
    (is (= (jdbc-uri "postgres://foo:foo@heroku.com:5432/hellodb")
           "jdbc:postgresql://heroku.com:5432/hellodb?user=foo&password=foo")))
  (testing "mysql"
    (is (= (jdbc-uri "mysql://localhost/mysql")
           "jdbc:mysql://localhost/mysql"))
    (is (= (jdbc-uri "mysql://foo:foo@heroku.com/hellodb")
           "jdbc:mysql://heroku.com/hellodb?user=foo&password=foo"))
    (is (= (jdbc-uri "mysql://foo:foo@heroku.com:5432/hellodb")
           "jdbc:mysql://heroku.com:5432/hellodb?user=foo&password=foo"))))
