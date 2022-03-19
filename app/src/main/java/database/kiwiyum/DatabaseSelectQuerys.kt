package database.kiwiyum

import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.time.LocalDateTime


object DatabaseSelectQuerys {
    @JvmStatic
    fun selectRecentRecipes(number: Int): List<MutableList<String>> {
        var rs: ResultSet? = null
        try {
            var connection: Connection?
            connection = Database.connect()
            if (connection != null) {
                var stmt = connection.createStatement()
                var time = LocalDateTime.now().toString().dropLast(6)
                var query =
                    "SELECT TOP $number recipe_name, dateuploaded, author FROM dbo.recipes order by dateuploaded desc"
                rs = stmt.executeQuery(query)
            }
        } // Handle any errors that may have occurred.
        catch (e: SQLException) {
            println("Failed to insert recipe")
            e.printStackTrace()
            throw e
        }
        var recipeName = mutableListOf<String>()
        var authorName = mutableListOf<String>()
        var dateUploaded = mutableListOf<String>()
        if (rs != null) {
            while (rs.next()) {
                recipeName.add(rs.getString("recipe_name"))
                authorName.add(rs.getString("author"))
                dateUploaded.add(rs.getString("dateuploaded"))
            }
        }
        return listOf(recipeName, authorName, dateUploaded)
    }
}