Feature: Rest endpoint which allows deleting customers

    Scenario: Removing an existing customer
        Given a customer with id '8f50e1cc-bea6-4ba7-b7a1-a72049d87e36' exists
        When I send a DELETE request to '/api/customers/8f50e1cc-bea6-4ba7-b7a1-a72049d87e36'
        Then the server return a 204 status code