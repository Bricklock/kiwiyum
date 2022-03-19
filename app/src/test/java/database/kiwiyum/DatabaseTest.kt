package database.kiwiyum

import org.junit.Test

class DatabaseTest {

    @Test
    fun connectTest() {
        assert(Database.connect() != null)
    }

    @Test
    fun disconnectTest() {
        var con = Database.connect()
        if (con != null) {
            Database.disconnect(con)
        }
    }
}