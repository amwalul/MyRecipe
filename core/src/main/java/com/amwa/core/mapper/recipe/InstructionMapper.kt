package com.amwa.core.mapper.recipe

import com.amwa.core.data.source.local.entity.InstructionEntity
import com.amwa.core.data.source.remote.response.recipe.StepResponse
import com.amwa.core.domain.model.recipe.Instruction
import com.amwa.core.mapper.DomainMapper
import com.amwa.core.mapper.EntityMapper

object InstructionResponseMapper : EntityMapper<StepResponse, InstructionEntity>,
    DomainMapper<StepResponse, Instruction> {
    override fun mapToEntity(type: StepResponse) = with(type) {
        InstructionEntity(number, step)
    }

    override fun mapToDomain(type: StepResponse) = with(type) {
        Instruction(number, step)
    }
}

object InstructionEntityMapper : DomainMapper<InstructionEntity, Instruction> {
    override fun mapToDomain(type: InstructionEntity) = with(type) {
        Instruction(number, step)
    }
}

object InstructionDomainMapper : EntityMapper<Instruction, InstructionEntity> {
    override fun mapToEntity(type: Instruction) = with(type) {
        InstructionEntity(number, step)
    }
}