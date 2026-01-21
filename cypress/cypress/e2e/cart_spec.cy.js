describe('Cart Test', () => {
  // --- PHẦN 1: TỰ ĐỘNG ĐĂNG NHẬP TRƯỚC MỖI BÀI TEST ---
  beforeEach(() => {
    cy.visit('https://www.saucedemo.com');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
    
    // Đảm bảo đã vào trang inventory trước khi test chạy tiếp
    cy.url().should('include', '/inventory.html');
  });

  // --- PHẦN 2: CÁC KỊCH BẢN KIỂM THỬ ---

  // Kịch bản: Thêm sản phẩm vào giỏ
  it('Should add a product to the cart', () => {
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');
  });

  // Kịch bản: Sắp xếp sản phẩm
  it('Should sort products by price low to high', () => {
    cy.get('.product_sort_container').select('lohi');
    cy.get('.inventory_item_price').first().should('contain', '7.99');
  });

  // --- BÀI TẬP VỀ NHÀ 1: Xóa sản phẩm khỏi giỏ hàng ---
  it('Should remove a product from the cart', () => {
    // 1. Thêm sản phẩm vào giỏ trước
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');
    
    // 2. Nhấn nút "Remove" (Sau khi thêm, nút Add đổi thành Remove)
    cy.contains('Remove').click();

    // 3. Xác minh giỏ hàng trống (Badge biến mất)
    cy.get('.shopping_cart_badge').should('not.exist');
  });

  // --- BÀI TẬP VỀ NHÀ 2: Quy trình thanh toán ---
  it('Should complete the checkout flow step one', () => {
    // 1. Thêm sản phẩm
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    
    // 2. Đi đến giỏ hàng
    cy.get('.shopping_cart_link').click();
    
    // 3. Nhấn Checkout
    cy.get('#checkout').click();
    
    // 4. Điền thông tin
    cy.get('#first-name').type('John');
    cy.get('#last-name').type('Doe');
    cy.get('#postal-code').type('12345');
    
    // 5. Nhấn Continue
    cy.get('#continue').click();
    
    // 6. Xác minh URL chuyển đến bước 2
    cy.url().should('include', '/checkout-step-two.html');
  });

}); // <--- DẤU NGOẶC QUAN TRỌNG NHẤT: Đóng lại describe