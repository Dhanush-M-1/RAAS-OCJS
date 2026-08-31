#include <bits/stdc++.h>
using namespace std;

int main(){
  long long int i,n,m,fib[100002],kotae=1;
  fib[0]=0;
  fib[1]=1;
  for(i=2;i<100002;i++){
    fib[i]=(fib[i-1]+fib[i-2])%1000000007;
  }
  cin>>n>>m;
  int a[m+1];
  a[0]=-1;
  for(i=1;i<m+1;i++){
    cin>>a[i];
    kotae=(kotae*(fib[a[i]-a[i-1]-1]))%1000000007;
  }
  kotae*=fib[n-a[m]];
  cout<<kotae%1000000007;
}