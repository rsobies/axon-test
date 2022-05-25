//package rsobies.psd.common
//
//import org.axonframework.commandhandling.CommandHandler
//import org.axonframework.eventsourcing.EventSourcingRepository
//import org.axonframework.eventsourcing.eventstore.EventStore
//import org.axonframework.modelling.command.AggregateIdentifier
//import org.axonframework.modelling.command.Repository
//import org.axonframework.spring.stereotype.Aggregate
//import org.springframework.context.annotation.Configuration
//import org.springframework.stereotype.Component
//import java.util.*
//
//data class Cmd(val id: UUID)
//
//@Component
//class MyComponent
//
//@Aggregate
//class MyAggr() {
//    @AggregateIdentifier
//    final var id: UUID = UUID.randomUUID()
//
//    @CommandHandler
//    constructor(
//            cmd: Cmd,
//
//            myComponent: MyComponent
//    ) : this() {
//
//    }
//}
//
//@Configuration
//class MyConfig {
//
//    //@Bean
//    fun createRepository(eventStore: EventStore?): Repository<MyAggr>? {
//        println("-----------------------repository")
//        val kk = EventSourcingRepository.builder(
//            MyAggr::class.java
//        ).eventStore(eventStore).build<EventSourcingRepository<MyAggr>>()
//        println("-----------------------repository1111111111111111")
//        return kk
//    }
//}