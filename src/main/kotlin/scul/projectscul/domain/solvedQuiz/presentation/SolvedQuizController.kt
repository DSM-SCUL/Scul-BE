package scul.projectscul.domain.solvedQuiz.presentation

import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.domain.solvedQuiz.service.GetLastQuizListService
import java.util.*

@RequestMapping("/scul/user")
@RestController
class SolvedQuizController (
    private val getLastQuizListService: GetLastQuizListService
){
    @GetMapping("/solved/{user-id}")
    fun getLastQuizList(
        @PathVariable("user-id") @NotNull userId: UUID
    ) {
        getLastQuizListService.execute(userId)
    }
}