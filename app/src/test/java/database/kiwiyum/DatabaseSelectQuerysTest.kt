package database.kiwiyum

import org.junit.Test
import java.util.*

class DatabaseSelectQuerysTest {

    @Test
    fun selectMostRecentRecipe() {
        var data = DatabaseSelectQuerys.selectRecentRecipes(1)
        val predicate: (MutableList<String>) -> Boolean = { it.size == 1 }

        assert(data.all(predicate))
    }

    @Test
    fun selectNRecipes() {
        var n = Random().nextInt(5)
        var data = DatabaseSelectQuerys.selectRecentRecipes(n)
        val predicate: (MutableList<String>) -> Boolean = { it.size == n }

        assert(data.all(predicate))
    }
}