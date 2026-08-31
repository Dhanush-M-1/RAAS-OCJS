#include<bits/stdc++.h>
using namespace std;

int foo(int x, int n){
  if(x < 10) return 0;
  int ma = 0, temp;
  for(int i = 10;x/i; i*=10)
    ma = max((x/i)*(x%i),ma);//cout<<ma<<" "<<n<<" "<<x<<endl;
  temp = foo(ma, n+1)+1;
  if(temp == -1 || ma == x) return -1;
  else return temp;
}

int main(){
  int Q, N;
  cin>>Q;
  for(int i = 0; i < Q; i++){
    cin>>N;
    cout<<foo(N,0)<<endl;
  }
  
  return 0;
}
