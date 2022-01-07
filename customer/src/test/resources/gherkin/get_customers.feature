Feature: Rest endpoint which allows retrieving customers data

    Scenario: Retrieving all customers
        Given a customer with id a26f508e-b442-4311-b604-1d0a82a98177 exists
        When I send a GET request to '/api/customers'
        Then the server return a 200 status code
        And a body content like
        """
        [{
            "id": "a26f508e-b442-4311-b604-1d0a82a98177",
            "name": "cliente1",
            "createdOn": "2022-01-05T19:24:00",
            "updatedOn": "2022-01-05T19:24:00"
        }]
        """
