### Prerequisites
1. VSCode or Netbeans
2. Jar File
3. Xampp or Workbench

### Links
* [Visual Studio Code](https://code.visualstudio.com/)
* [Netbeans](https://netbeans.apache.org/front/main/download/nb21/)
* [MySQL JDBC Connector](https://dev.mysql.com/downloads/connector/j/)
* [XAMPP](https://www.apachefriends.org/)
* [MySQL Workbench](https://dev.mysql.com/downloads/installer/)


### Connection
- to connect to the database

- Commonly used methods
    - createStatement() - Object for sending SQL statements to the database.
    - close() - Closes the database connection.
    <!-- - commit() - Commits the current transaction.
    - rollback() - Rolls back the current transaction. -->


### Statement
- to execute SQL queries

- Commonly used methods
    - executeQuery(String sql) - Executes an SQL query and returns a ResultSet object.
    - executeUpdate(String sql) - Executes an SQL statement (INSERT, UPDATE, or DELETE)
    - close() - Closes the Statement object.


### ResultSet
- to get the result of the executed SQL query

- Commonly used methods
    - next() - Moves the cursor to the next row.
    - getString(String columnLabel) - Retrieves the string value
    - getInt(String columnLabel) - Retrieves the integer value
    - close() - Releases this ResultSet object's database and JDBC resources immediately.