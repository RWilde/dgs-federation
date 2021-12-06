package com.thesting.cart;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.internal.DefaultDgsGraphQLContextBuilder;
import com.netflix.graphql.dgs.internal.DefaultDgsQueryExecutor;
import com.netflix.graphql.dgs.internal.DgsSchemaProvider;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.instrumentation.ChainedInstrumentation;
import graphql.execution.preparsed.PreparsedDocumentProvider;
import graphql.schema.GraphQLSchema;
import graphql.schema.visibility.GraphqlFieldVisibility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.ResourceHint;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.nativex.hint.TypeHints;

import java.util.Optional;


@SpringBootApplication
@ConfigurationPropertiesScan

//@NativeHint(resources = {
@ResourceHint(patterns = "resources/schema/schema.graphqls")
//})
@TypeHints({
        @TypeHint(types = DataFetcherExceptionHandler.class, typeNames = "graphql.execution.DataFetcherExceptionHandler"),
        @TypeHint(types = Environment.class, typeNames = "org.springframework.core.env.Environment"),
        @TypeHint(types = ApplicationContext.class, typeNames = "org.springframework.context.ApplicationContext"),
        @TypeHint(types = DefaultDgsQueryExecutor.class, typeNames = "com.netflix.graphql.dgs.internal.DefaultDgsQueryExecutor$ReloadSchemaIndicator"),
        @TypeHint(types = GraphqlFieldVisibility.class, typeNames = "graphql.schema.visibility.GraphqlFieldVisibility"),
        @TypeHint(types = Optional.class, typeNames = "java.util.Optional"),
        @TypeHint(types = ChainedInstrumentation.class, typeNames = "graphql.execution.instrumentation.ChainedInstrumentation"),
        @TypeHint(types = GraphQLSchema.class, typeNames = "graphql.schema.GraphQLSchema"),
        @TypeHint(types = DgsSchemaProvider.class, typeNames = "com.netflix.graphql.dgs.internal.DgsSchemaProvider"),
        @TypeHint(types = DefaultDgsGraphQLContextBuilder.class, typeNames = "com.netflix.graphql.dgs.internal.DefaultDgsGraphQLContextBuilder"),
        @TypeHint(types = PreparsedDocumentProvider.class, typeNames = "graphql.execution.preparsed.PreparsedDocumentProvider"),
        @TypeHint(types = DgsQueryExecutor.class, typeNames = "com.netflix.graphql.dgs.DgsQueryExecutor")
})
@NativeHint
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}



