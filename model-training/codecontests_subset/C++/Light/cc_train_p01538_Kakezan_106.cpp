#include<iostream>
using namespace std;
int main(){
  int q,n;
  cin>>q;
  while(q--){
    cin>>n;
    int c=0;
    while(n/10&&c<1000000){
      c++;
      int a=-1;
      for(int i=10;i<n;i*=10)a=max(a,(n/i)*(n%i));
      n=a;
    }
    if(c==1000000)cout<<-1<<endl;
    else cout<<c<<endl;
  }
  return 0;
}