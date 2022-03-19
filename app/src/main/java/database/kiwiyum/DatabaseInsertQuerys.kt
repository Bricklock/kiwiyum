package database.kiwiyum

import java.sql.Connection
import java.sql.SQLException
import java.time.LocalDateTime


object DatabaseInsertQuerys {
    @JvmStatic
    fun insertRecipe(recipe_name: String, author: String){
        try {
            var connection: Connection?
            connection = Database.connect()
            if (connection != null) {
                var stmt = connection.createStatement()
                var time = LocalDateTime.now().toString().dropLast(6)
                var query = "INSERT INTO recipes (recipe_name, author, dateuploaded) " +
                            "VALUES ($recipe_name, $author, '$time');"
                stmt.executeQuery(query)
            }
        } // Handle any errors that may have occurred.
        catch (e: SQLException) {
            e.printStackTrace()
            println("Failed to insert recipe")
        }
    }

}