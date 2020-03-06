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
        selectdPatMethod: ''
    },
    mounted() {
        console.log('view mounted');
        this.getMyAddress();
    },
    methods: {
        getMyAddress() {
            axios.get('/address/getCustomerAddress')
                .then(function (response) {
                    console.log(response);
                    app.myAddress = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });

        }
    }
})