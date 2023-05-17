
# Rewards Program API

This API provides endpoints to manage transactions and calculate reward points for customers in a rewards program.

## Base URL



`http://localhost:8080`

## Endpoints

### Create Transaction

-   **Endpoint:** `/transactions`
-   **Method:** POST
-   **Description:** Create a new transaction.
-   **Request Body:**


`{
"customerId": "123456",
"amount": 120.0
}`

-   **Response:**

`{
"id": "abc123",
"customerId": "123456",
"amount": 120.0,
"timestamp": "2023-05-17T10:30:00Z"
}`

### Get Monthly Rewards

-   **Endpoint:** `/rewards/monthly/{customerId}`

-   **Method:** GET

-   **Description:** Get the reward points earned by a customer for each month.

-   **Path Parameters:**

    -   `customerId`: The ID of the customer.
-   **Response:**



`{
"customerId": "123456",
"rewards": [
{
"month": "2023-05",
"points": 90
},
{
"month": "2023-04",
"points": 150
}
]
}`

### Get Total Rewards

-   **Endpoint:** `/rewards/total/{customerId}`

-   **Method:** GET

-   **Description:** Get the total reward points earned by a customer.

-   **Path Parameters:**

    -   `customerId`: The ID of the customer.
-   **Response:**



`{
"customerId": "123456",
"totalPoints": 240
}`

## Error Handling

In case of errors, the API will return an appropriate HTTP status code along with an error message in the response body.

Example Error Response:


`{
"status": 400,
"message": "Invalid request. Customer ID is required."
}`

## Conclusion

This API allows you to create transactions, retrieve monthly rewards, and calculate total rewards for customers in the rewards program. Use the provided endpoints to interact with the API and manage reward points for customers.

Please refer to the individual endpoint descriptions for more information on the request and response formats.

Note: Replace the base URL (`http://localhost:8080`) with the appropriate URL of your deployed application.