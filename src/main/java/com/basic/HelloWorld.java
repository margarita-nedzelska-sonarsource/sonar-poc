package com.basic;

import java.sql.SQLException;

public class HelloWorld {

  private DataBaseQueryExecutor queryExecutor;

  void sayHello() {
    System.out.println("Hello World!");
  }

  void notCovered() {
    System.out.println("This method is not covered by unit tests");
  }

  public void howAreYou() {

    try {
      QueryResultItem[] queryResultItems =
          getQueryExecutor().executeSelect("tempFetchQry", "tableName", "testRepository");

      System.out.println("Total fetched queryResultItems : " + queryResultItems.length);
      for (QueryResultItem queryResultItem : queryResultItems) {
        System.out.println("fetched repo item = " + queryResultItem);
      }

    } catch (SQLException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public DataBaseQueryExecutor getQueryExecutor() {
    return queryExecutor;
  }

  public void setQueryExecutor(DataBaseQueryExecutor queryExecutor) {
    this.queryExecutor = queryExecutor;
  }
}
