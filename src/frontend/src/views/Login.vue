<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <form>
      <div>
        <label>아이디</label>
        <input type="text" v-model="user.id">
      </div>
      <div>
        <label>비밀번호</label>
        <input type="password" v-model="user.password">
      </div>
      {{message}}
      <button @click="login()" type="button" class="btn btn-primary">로그인</button>
    </form>
  </div>
</template>

<script>

export default {
  methods:{
    login(){
      var vm = this;
      this.$axios.post("/api/login", this.user)
              .then(function (response) {
                if(response.data === "ERR_PW"){
                  vm.message = "비밀번호 오류"
                }else if (response.data === "NOT_FOUND") {
                  vm.message = "해당하는 아이디가 없습니다."
                }else{
                  vm.message = "로그인 성공"
                }
              })
              .catch(function (error) {
                console.log(error);
              })
    }
  },
  data(){
    return {
      user : {
        id: '',
        password : ''
      },
      message : ''
    }
  }
}
</script>
