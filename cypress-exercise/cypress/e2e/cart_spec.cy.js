describe('Cart Test', () => {
    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
    });

    it('Should add a product to the cart', () => {
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        cy.get('.shopping_cart_badge').should('have.text', '1');
    });

    it('Should sort products by price low to high', () => {
        cy.get('.product_sort_container').select('lohi');
        cy.get('.inventory_item_price').first().should('have.text', '$7.99');
    });

    // Homework: Remove product from cart
    it('Should remove a product from the cart', () => {
        // Add product first
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        cy.get('.shopping_cart_badge').should('have.text', '1');

        // Remove product (Click the same button which now says REMOVE)
        cy.get('.inventory_item').first().find('.btn_inventory').click();

        // Check badge is gone
        cy.get('.shopping_cart_badge').should('not.exist');
    });
});
