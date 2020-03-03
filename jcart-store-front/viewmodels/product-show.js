var app = new Vue({
    el: '#app',
    data: {
        productId: '',
        productCode: '',
        productName: '',
        price: '',
        discount: '',
        description: '',
        stockQuantity: '',
        mainPicUrl: '',
        otherPicUrls: [],
        quantity: 1,
        myShoppingCart: []
    },
    computed: {
        otherPicUrlsJson() {
            return this.otherPicUrls.toString();
        }
    },
    mounted() {
        console.log('view mounted');

        var myShoppingCartJson = localStorage['myShoppingCart'];
        this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson) : [];

        var url = new URL(location.href);
        this.productId = url.searchParams.get("productId");
        if (!this.productId) {
            alert('productId is null');
            return;
        }

        this.getProductById();

    },
    methods: {
        handleAddToCartClick() {
            console.log('add to cart click');
            var newProduct = {
                productId: 1235,
                productCode: "pc001",
                productName: "uMac",
                mainPicUrl: "Jttp://bbb.jpg",
                unitPrice: 8999.99,
                quantity: 1,
                totalPrice: 8999.99
            };
            this.myShoppingCart.push(newProduct);
            localStorage['myShoppingCartJson'] = JSON.stringify(this.myShoppingCart);
            this.$message.success("加入购物车成功");
        },
        getProductById() {
            axios.get('/product/getById', {
                params: {
                    productId: this.productId
                }
            })
                .then(function (response) {
                    console.log(response);
                    var product = response.data;
                    app.productId = product.productId;
                    app.productCode = product.productCode;
                    app.productName = product.productName;
                    app.price = product.price;
                    app.discount = product.discount;
                    app.mainPicUrl = product.mainPicUrl;
                    app.otherPicUrls = product.otherPicUrls;
                    app.description = product.description;
                    app.stockQuantity = product.stockQuantity;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})