#include<bits/stdc++.h>
using namespace std;

long long gcd(long long x,long long y){
  return y==0?x:gcd(y,x%y);
}

int main(){
  //freopen("aa.in","r",stdin);
  int _;scanf("%d",&_);
  for(;_--;){
    long long A,B,C,D;
    scanf("%lld%lld%lld%lld",&A,&B,&C,&D);
    if(A<B||D<B){puts("No");continue;}
    if(C>=B-1){puts("Yes");continue;}
    long long G=gcd(B,D);
    A%=G;
    if(-G+A>=C-B+1)puts("No");
    //if(A==0&&-G>=C-B+1||A&&A>=C-B+1)puts("No");
    else puts("Yes");
  }
  return 0;
}