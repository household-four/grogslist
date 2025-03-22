# Grogslist - Intergalactic Marketplace
Created by Christen Barringer and Faizan Azam for CSI 5324.

# Your task
Run the application. Visit http://localhost:8080/ to try out the app. Try submitting new products and refreshing the table.

Your task is to extend the existing Spring WebFlux application to allow clients to subscribe to product updates in real-time. Implement an endpoint using Sinks that updates the client as new products are added. 

Test your implementation by opening multiple browser windows. When a product is posted, all windows should receive a notification and reload the list of products.

Then, answer the following question: 

In the application you built, a new product is added using a POST /products request. After a successful request, the server could return a 201 Created response, and the client could simply reload the product list. Why might you instead implement a reactive stream endpoint like GET /products/stream that clients can subscribe to, even though the 201 response already confirms the product was added?