#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,m;
  cin>>n>>m;
  vector<pair<int,int>> a(n),b(m);
  for(auto& x:a)cin>>x.first>>x.second;
  for(auto& x:b)cin>>x.first>>x.second;
  
  for(auto x:a){
    int idx=0;
    int dist=(1<<28);
    for(int i=0;i<m;++i){
      int t=abs(x.first-b[i].first)+abs(x.second-b[i].second);
      if(t<dist){
        dist = t;
        idx = i+1;
      }
    }
    cout<<idx<<endl;
  }
}