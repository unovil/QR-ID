package com.unovil.tardyscan.domain.usecase

import com.unovil.tardyscan.domain.model.AllowedUser

interface VerifyAllowedUserUseCase : UseCase<VerifyAllowedUserUseCase.Input, VerifyAllowedUserUseCase.Output> {
    class Input(val allowedUser: AllowedUser)

    sealed class Output {
        object Success : Output()
        open class Failure : Output() {
            object AlreadyRegistered : Failure()
            object NotFound : Failure()
            object Conflict : Failure()
        }
    }
}