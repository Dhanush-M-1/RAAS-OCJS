#include<bits/stdc++.h>
using namespace std;
int main(){
  bool m[4][13]={};
  int n;
  cin>>n;
  for(int i=0;i<n;++i){
    int a;
    char c;
    cin>>c>>a;
    --a;
    if(c=='S') m[0][a]=1;
    else if(c=='H') m[1][a]=1;
    else if(c=='C') m[2][a]=1;
    else m[3][a]=1;
  }
  for(int i=0;i<13;++i) if(!m[0][i]) cout<<"S "<<i+1<<endl;
  for(int i=0;i<13;++i) if(!m[1][i]) cout<<"H "<<i+1<<endl;
  for(int i=0;i<13;++i) if(!m[2][i]) cout<<"C "<<i+1<<endl;
  for(int i=0;i<13;++i) if(!m[3][i]) cout<<"D "<<i+1<<endl;
}
