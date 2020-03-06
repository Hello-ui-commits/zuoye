var app = new Vue({
    el: '#app',
    data: {
        myAddress: [],
        shipMethods: [
            { value: 0, label: 'EMS' },
            { value: 1, label: '顺丰' },
            { value: 2, label: '申通' },
            { value: 3, label: '圆通' },
            { value: 4, label: '京东' }
        ],
        payMethods: [
            { value: 1, label: '货到付款' },
            { value: 2, label: '信用卡' },
            { value: 3, label: '借记卡' },
            { value: 4, label: '微信' },
            { value: 5, label: '支付宝' }
        ],
        selectdShipAddressdId: '',
        selectShipMethod: '',
        selectedInvoiceAddredssId: '',
        selectdPayMethod: '',
        myShoppingCart:[],
        shipPrice:5.0,
        comment:''
    },
    computed:{
        totalPrice() {
            var subTotalPrice=this.myShoppingCart.map(p=>{
                return p.unitPrice * p.discount *p.quantity;
            });
            var totalPrice = subTotalPrice.reduce((a,b) =>a+b,0);
            var totalPriceStr = totalPrice.toFixed(2);
            totalPrice = parseFloat(totalPriceStr);
            return  totalPrice;
        },
        payPrice(){
            return this.totalPrice+this.shipPrice;
        },
        orderProducts(){
            var orderProducts =this.myShoppingCart.map(p=>{
                var orderProduct = '';
                orderProduct.productId=p.productId;
                orderProduct.quantity =p.quantity;
                return orderProduct;
            });
            return orderProducts;
        }
    },
    mounted() {
        console.log('view mounted');
        this.getMyAddress();
        
        var myShoppingCartJson = localStorage['myShoppingCartJson'];
        this.myShoppingCart = myShoppingCartJson? JSON.parse(myShoppingCartJson):[];
    },
    methods: {
        handleConfirmOrder(){
            console.log('confirm order click');
            this.checkoutOrder();
        },
        getMyAddress() {
            axios.get('/address/getCustomerAddress')
                .then(function (response) {
                    console.log(response);
                    app.myAddress = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });

        },
        checkoutOrder(){
            axios.post('/order/checkout', {
                shipMethod: this.selectShipMethod,
                shipAddressId: this.selectdShipAddressdId,
                payMethod: this.selectdPayMethod,
                invoiceAddressId: this.selectedInvoiceAddredssId,
                comment: this.comment,
                orderProducts: this.orderProducts
              })
              .then(function (response) {
                console.log(response);
                alert("下单成功")
              })
              .catch(function (error) {
                console.log(error);
                alert("下单失败")
              });
        }
        
    }
})