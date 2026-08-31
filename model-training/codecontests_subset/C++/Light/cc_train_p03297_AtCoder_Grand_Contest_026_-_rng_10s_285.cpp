#include <cstdio>
#include <algorithm>
#include <stdint.h>

int64_t gcd(int64_t a,int64_t b){
  return b?gcd(b,a%b):a;
}

bool solve(){
  int64_t A,B,C,D;
  scanf("%ld %ld %ld %ld",&A,&B,&C,&D);
  if(A<B||D<B){
    return false;
  }
  int64_t g=gcd(B,D);
  A%=g;
  A+=std::max<int64_t>(0,C-A+g)/g*g;
  return A>=B;
}

int main(){
  int64_t T;
  scanf("%ld",&T);
  while(T--){
    if(solve()){
      printf("Yes\n");
    }else{
      printf("No\n");
    }
  }
  return 0;
}
