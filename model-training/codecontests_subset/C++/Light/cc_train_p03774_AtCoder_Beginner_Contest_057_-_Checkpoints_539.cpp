#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,m,i,j,k,x,y,l,z;
  cin>>n>>m;
  vector<pair<int,int>> a(n),c(m);
  for(i=0;i<n;i++){
    cin>>x>>y;
    a.at(i)=make_pair(x,y);
  }
  for(i=0;i<m;i++){
    cin>>x>>y;
    c.at(i)=make_pair(x,y);
  }
  for(i=0;i<n;i++){
    l=4e8;
    for(j=0;j<m;j++){
      z=abs(a.at(i).first-c.at(j).first)+abs(a.at(i).second-c.at(j).second);
      if(z<l){
        k=j+1;
        l=z;
      }
    }
    cout<<k<<endl;
  }
}