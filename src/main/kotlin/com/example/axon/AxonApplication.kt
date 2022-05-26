package com.example.axon

import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.Repository
import org.axonframework.modelling.command.TargetAggregateIdentifier
import org.axonframework.spring.stereotype.Aggregate
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.util.*

@SpringBootApplication
class AxonApplication

fun main(args: Array<String>) {
	runApplication<AxonApplication>(*args)

}

data class Cmd(@TargetAggregateIdentifier val id: UUID)

@Component
class MyComponent

@Aggregate
class MyAggr() {
	@AggregateIdentifier
	final var id: UUID = UUID.randomUUID()

	@CommandHandler
	constructor(
			cmd: Cmd,
			myComponent: MyComponent
	) : this() {

	}
}

@Configuration
class MyConfig {

	@Bean
	fun createRepository(eventStore: EventStore): Repository<MyAggr> {
		println("-----------------------repository")
		val result = EventSourcingRepository
			.builder(MyAggr::class.java)
			.eventStore(eventStore)
			.build<EventSourcingRepository<MyAggr>>()
		println("-----------------------repository1111111111111111")
		return result
	}
}
