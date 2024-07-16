package scul.projectscul.domain.quiz.presentation

import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import scul.projectscul.domain.quiz.presentation.request.SolveQuizRequest
import scul.projectscul.domain.quiz.presentation.response.GetQuizResponse
import scul.projectscul.domain.quiz.service.GetLastQuizListService
import scul.projectscul.domain.quiz.service.GetQuizService
import scul.projectscul.domain.quiz.service.SolveQuizService

@RequestMapping("/scul/user")
@RestController
class QuizController (
        private val getQuizService: GetQuizService,
        private val solveQuizService: SolveQuizService,
        private val getLastQuizListService: GetLastQuizListService
) {

    @GetMapping("/{quiz-id}")
    fun getQuiz(
            @PathVariable("quiz-id") @NotNull quizId: Long
    ) : GetQuizResponse {
        return getQuizService.execute(quizId)
    }

    @GetMapping("/solved/{user-id}")
    fun getLastQuizList(
        @PathVariable("user-id") @NotNull userId: Long
    ) {
        getLastQuizListService.execute(userId)
    }

    @GetMapping("solved/{quiz-id}")
    fun solveQuiz(
            @RequestBody request: SolveQuizRequest,
            @PathVariable("quiz-id") @NotNull quizId: Long
    ) {
        solveQuizService.execute(request, quizId)
    }
}
