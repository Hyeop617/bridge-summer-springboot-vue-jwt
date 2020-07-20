<template>
  <div class="signup">
    <form>
      <div>
        <label>아이디</label>
        <input type="text" v-model="user.id">
      </div>
      <div>
        <label>비밀번호</label>
        <input type="password" v-model="user.password">
      </div>
      <div>
        <label>비밀번호 확인</label>
        <input type="password" v-model="passwordCheck">
      </div>
      <div :class="checkPassword()">
        비밀번호를 확인하세요.
      </div>
      <div>
        <label>닉네임</label>
        <input type="text" v-model="user.nickname">
      </div>
      <div>
        <label>이메일</label>
        <input type="email" v-model="user.email">
      </div>
      {{this.message}}
      <button @click="signup()" type="button" class="btn btn-primary">가입</button>
    </form>
  </div>
</template>
<script>
  export default {
    methods:{
      signup(){
        var vm = this;
        this.$axios.post("/api/signup", this.user)
                .then(function (response) {
                  if(response.data === 'EXIST_ID'){
                    vm.message = "아이디 중복입니다."
                  }else if (response.data === 'EXIST_NICKNAME') {
                    vm.message = "닉네임 중복입니다."
                  }else{
                    vm.$router.push('/')
                  }
                  console.log(response);
                })
                .catch(function (error) {
                  console.log(error);
                })
      },
      checkPassword(){
        return{
          'd-none' : this.user.password === this.passwordCheck,
          'text-danger': true
        }
      }
    },
    data() {
      return {
        message : '',
        passwordCheck : '',
        user : {
          id: '',
          password : '',
          nickname : '',
          email :''
        }
      }
    }
  }

</script>
