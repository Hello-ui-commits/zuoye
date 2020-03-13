var app = new Vue({
    el: '#app',
    data: {
        pageInfo: '',
        pageNum: 1,
        actions: [
            { value: 0, label: '退货' },
            { value: 1, label: '换货' },
            { value: 2, label: '修理' }
        ],
        returnId:'',
        orderId:'',
        customerName:'',
        productCode:'',
        productName:'',
        selectedStatus:'',
    },
    mounted() {
        console.log('view mounted');
        this.searchReturn();
    },
    methods: {
        handlePageChange(val) {
            console.log('page changed', val);
            this.pageNum = val;
            this.searchReturn();
        },
        handleClearClick() {
            console.log('clear click');
            this.returnId = '';
            this.orderId = '';
            this.customerName = '';
            this.productCode = '';
            this.productName = '';
            this.selectedStatus='';
        },
        searchReturn() {
            axios.get('/return/search', {
                params: {
                    pageNum: this.pageNum,
                    returnId:this.returnId,
                    orderId:this.orderId,
                    customerName:this.customerName,
                    productCode:this.productCode,
                    productName:this.productName,
                    status:this.selectedStatus,
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})