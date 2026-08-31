#include<iostream>
#include<algorithm>
using namespace std;

const int MAX=1000000;

int func_num(int n){
  
  int count=0;

  while(1){
    int x=0;
    if(0<=n&&n<=9) break;
    for(int i=10;i<=MAX;i*=10){
      if(n/i==0) break;
      x=max(x,(n/i)*(n%i));
    }
    n=x;
    count++;
  }
  return count;
}

int main(){
  int Q,N;
  int ans;
  
  cin>>Q;
  for(int i=0;i<Q;i++){
    cin>>N;
    ans=func_num(N);
    cout<<ans<<endl;
  }
  
  return 0;
}