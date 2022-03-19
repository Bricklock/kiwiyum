package database.kiwiyum

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {
    // Connect to kiwiyum database.
    @JvmStatic
    fun connect(): Connection? {
        var connection: Connection? = null
        val connectionUrl = ("jdbc:sqlserver://DESKTOP-F4IMSEP:1433;" //DESKTOP-F4IMSEP
                + "database=kiwiyum;"
                + "user=kiwiyum;"
                + "password=kiwiyum;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;")

        try {
            connection =  DriverManager.getConnection(connectionUrl)
            println("Connected to server")
        } // Handle any errors that may have occurred.
        catch (e: SQLException) {
            e.printStackTrace()
            println("Failed to connect to server")
        }
        return connection
    }

    fun disconnect(connection: Connection) {
        try {
            connection.close()
            println("Disconnected to server")
        } // Handle any errors that may have occurred.
        catch (e: SQLException) {
            e.printStackTrace()
            println("Failed to disconnect from server")
        }
    }
}