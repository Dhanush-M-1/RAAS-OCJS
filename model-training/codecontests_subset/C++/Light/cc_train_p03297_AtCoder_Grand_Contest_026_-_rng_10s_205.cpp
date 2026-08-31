#include<cstdio>
#include<algorithm>
using namespace std;
typedef long long LL;
int _test;
LL A,B,C,D;
LL gcd(LL a,LL b){ return b?gcd(b,a%b):a; }
int main(){
  scanf("%d",&_test);
  while(_test--){
    scanf("%lld%lld%lld%lld",&A,&B,&C,&D);
    if(A>C) A=(A-C-1)%B+C+1;
    if(A<B||D<B) puts("No"); else{
      A%=B; D%=B; LL d=gcd(B,D);
      if((C-A)/d<(B-A-1)/d) puts("No"); else puts("Yes");
    }
  }
  return 0;
}
