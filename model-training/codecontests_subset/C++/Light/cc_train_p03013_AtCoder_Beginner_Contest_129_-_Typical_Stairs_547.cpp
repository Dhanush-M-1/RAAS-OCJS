#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,m;
  cin>>n>>m;
  vector<bool> b(n+1,0);
  for(int i=0;i<m;i++){
    int a;
    cin>>a;
    b.at(a)=1;
  }
  vector<int> c(n+1);
  c[0]=1;
  c[1]=(b.at(1)?0:1);
  for(int i=2;i<=n;i++)
    c[i]=(b.at(i)?0:(c[i-2]+c[i-1])%1000000007);
  cout<<c.at(n)<<endl;
}