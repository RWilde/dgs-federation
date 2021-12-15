const { ApolloServer } = require("apollo-server");
const { ApolloGateway, RemoteGraphQLDataSource } = require("@apollo/gateway");

class AuthenticatedDataSource extends RemoteGraphQLDataSource {
    willSendRequest({ request, context }) {
        // Pass the user's id from the context to each subgraph
        // as a header called `user-id`
        request.http.headers.set('token', context.token);
    }
}

const gateway = new ApolloGateway({
    serviceList: [
        // This entire `serviceList` is optional when running in managed federation
        // mode, using Apollo Graph Manager as the source of truth.  In production,
        // using a single source of truth to compose a schema is recommended and
        // prevents composition failures at runtime using schema validation using
        // real usage-based metrics.
        { name: "Carts", url: "http://localhost:5002/graphql" },
        { name: "Products", url: "http://localhost:5004/graphql" },
        { name: "Users", url: "http://localhost:5005/graphql" },

    ],
    buildService({ name, url }) {
        return new AuthenticatedDataSource({ url });
    },
    // Experimental: Enabling this enables the query plan view in Playground.
    __exposeQueryPlanExperimental: false,
});

(async () => {
    const server = new ApolloServer({
        gateway,

        // Apollo Graph Manager (previously known as Apollo Engine)
        // When enabled and an `ENGINE_API_KEY` is set in the environment,
        // provides metrics, schema management and trace reporting.
        engine: false,

        // Subscriptions are unsupported but planned for a future Gateway version.
        subscriptions: false,

        context: ({ req }) => {
            // Get the user token from the headers
            const token = req.headers.token || '';

            // Add the user ID to the context
            return { token };
        },
    });

    server.listen().then(({ url }) => {
        console.log(`🚀 Server ready at ${url}`);
    });
})();