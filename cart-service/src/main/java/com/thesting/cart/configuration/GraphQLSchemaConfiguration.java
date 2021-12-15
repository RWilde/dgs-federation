package com.thesting.cart.configuration;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsRuntimeWiring;
import com.thesting.cart.directive.evaluator.SecuredDirectiveWiring;
import com.thesting.cart.scalar.CustomScalars;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GraphQLSchemaConfiguration {
//    @DgsComponent
//    public class SecuredDirectiveRegistration {
//
//        private SecuredDirectiveWiring securedDirectiveWiring;
//
//        public SecuredDirectiveRegistration(SecuredDirectiveWiring securedDirectiveWiring) {
//            this.securedDirectiveWiring = securedDirectiveWiring;
//        }
//
//        @DgsRuntimeWiring
//        public RuntimeWiring.Builder addSecuredDirective(RuntimeWiring.Builder builder) {
//            return builder.directive(SecuredDirectiveWiring.SECURED_DIRECTIVE, securedDirectiveWiring);
//        }
//
//    }

    @DgsComponent
    public class ScalarsRegistration {
        @DgsRuntimeWiring
        public RuntimeWiring.Builder addCustomScalars(RuntimeWiring.Builder builder) {
            return builder.scalar(CustomScalars.UUID);

        }
    }


}
