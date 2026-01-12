describe('Checkout Test', () => {
    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
    });

    it('Should complete the checkout process', () => {
        // Add product to cart
        cy.get('.inventory_item').first().find('.btn_inventory').click();

        // Go to Cart
        cy.get('.shopping_cart_link').click();
        cy.url().should('include', '/cart.html');

        // Click Checkout
        cy.get('#checkout').click();
        cy.url().should('include', '/checkout-step-one.html');

        // Fill Information
        cy.get('#first-name').type('John');
        cy.get('#last-name').type('Doe');
        cy.get('#postal-code').type('12345');

        // Click Continue
        cy.get('#continue').click();

        // Verify redirection to Checkout Step Two
        cy.url().should('include', '/checkout-step-two.html');
    });
});
