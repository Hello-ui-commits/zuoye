var app = new Vue({
    el: '#app',
    data: {
        email: '',
        buttonEnabled:true,
    },
    methods: {
        handleFindBackPwdClick() {
            console.log('find back pwd click');
            this.buttonEnabled =false;
            this.getPwdResetCode();
            
            setInterval(function(){
                console.log('count down');
                app.counter--;
            },1000);
            this.getPwdResetCode();
        },
        getPwdResetCode() {
            axios.get('/customer/getPwdResetCode', {
                params: {
                    email: this.email
                    
                }
            })
                .then(function (response) {
                    console.log(response);
                    alert('重置码已发送到邮箱');
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})