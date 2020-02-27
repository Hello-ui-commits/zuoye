var app = new Vue({
    el: '#app',
    data: {
        productCode: '',
        productName: '',
        price: '',
        discount: '',
        stockQuantity: '',
        rewordPoints: '',
        sortOrder: '',
        description: '',
        selectedStatus:'',
        otherPicUrls:[],
        statuses:[{
            value: '选项1',
            label: '下架'
          }, {
            value: '选项2',
            label: '上架'
          }, {
            value: '选项3',
            label: '待审核'
          }],
          value:'',
    },
    
    methods:{
        handleCreateClick(){
            console.log('create click');
            this.createProduct;
        },
        handleUploadClick(){
            console.log('upload main pic click');
           
        },
        uploadImage(){
            var fromDate=new FormData();
            fromDate.append("image",this.selectImage);
            axion.post('/image/upload',forData{

            })
        },
        createProduct(){
            axios.post('/product/create',{
                productCode:this.productCode,
                productName:this.productName,
                price:this.price,
                discount:this.discount,
                stockQuantity:this.stockQuantity,
                status:this.selectedStatus,
                mainPicUrl:this.mainPicUrl,
                rewordPoints:this.rewordPoints,
                sortOrder:this.sortOrder,
                description:this.description,
                otherPicUrls:this.otherPicUrls,
            })
                .then(function(response){
                    console.log(response);
                    alert('创建成功')
                })
                .catch(function(error){
                    console.log(error);
                });
        }
    },

})