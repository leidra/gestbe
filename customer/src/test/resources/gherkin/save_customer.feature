Feature: Rest endpoint which allows saving customers

    Scenario: Saving an non-existing customer
        Given a customer with id '8f50e1cc-bea6-4ba7-b7a1-a72049d87e36' that not exists
        When I send a PUT request to '/api/customers/8f50e1cc-bea6-4ba7-b7a1-a72049d87e36'
        And a request body content like:
        """
        {
            "name": "nuevo cliente"
        }
        """
        Then the server return a 204 status code
        And the customer is created
    Scenario: Saving an existing customer
        Given a customer with id '8f50e1cc-bea6-4ba7-b7a1-a72049d87e36' exists
        When I send a PUT request to '/api/customers/8f50e1cc-bea6-4ba7-b7a1-a72049d87e36'
        And a request body content like:
        """
        {
            "name": "cliente modificado"
        }
        """
        Then the server return a 204 status code
        And the customer is saved