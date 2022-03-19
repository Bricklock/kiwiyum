package database.kiwiyum

import org.junit.Test

class DatabaseInsertQuerysTest {

    @Test
    fun insertRecipe() {
        DatabaseInsertQuerys.insertRecipe("ChickenWinnerWinner", "nick")
    }
}