#include <bits/stdc++.h>
int e,n,c,k,i;
using namespace std;
int main() {
  cin>>e;
  while(e--){
    cin>>n;
    c=0;
    while(n>9){
      int m=0,b=1;
      for(c++,i=0;i<5;i++){
        b*=10;
        k=(n/b)*(n%b);
        if(k>m)m=k;
      }
      n=m;
    }
    cout<<c<<endl;
  }
}