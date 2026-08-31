#include <bits/stdc++.h>
using namespace std;

long long gcd(long long A,long long B)
{
  return B==0?A:gcd(B,A%B);
}

int main()
{
  int T;
  scanf("%d",&T);
  while(T--){
    long long A,B,C,D;
    scanf("%lld%lld%lld%lld",&A,&B,&C,&D);
    bool ans;
    if(D<B||A<B){
      ans=0;
    }
    else{
      long long g=gcd(D,B);
      long long E=A%B+(B-A%B-1)/g*g;
      ans=(E<=C);
    }
    puts(ans?"Yes":"No");
  }
  return 0;
}

