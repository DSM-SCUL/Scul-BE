package scul.projectscul.domain.user.presentation.request

import jakarta.persistence.Column
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDate
import java.time.LocalDateTime

data class SignUpRequest(

        @field:NotBlank
        @field:Size(min = 2, max = 10)
        val name: String,

        @field:NotBlank
        @field:Size(min = 8, max = 50)
        val email: String,

        @field:NotBlank
        val birth: LocalDate,

        @Column(nullable = true)
        val profileImage: String = "https://kangsunbucket.s3.ap-northeast-2.amazonaws.com/bacaf410-b7d5-45ab-b5ea-1023144223cf%7C%7Cpng-transparent-user-defult-avatar.png"
)
