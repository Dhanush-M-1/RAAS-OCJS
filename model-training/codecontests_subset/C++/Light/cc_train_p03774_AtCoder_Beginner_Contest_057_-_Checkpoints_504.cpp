#include<iostream>
#include<vector>
using namespace std;
int main(){
  int n,m;
  cin>>n>>m;
  vector<int> a(n),b(n),c(m),d(m);
  for(int i=0;i<n;++i){
    cin>>a[i]>>b[i];
  }
  for(int i=0;i<m;++i){
    cin>>c[i]>>d[i];
  }
  int val=0;
  for(int i=0;i<n;++i){
    int ans=1000000000;
    for(int j=0;j<m;++j){
      int dis=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(ans>dis){
        val=j+1; 
        ans=dis;
      }
    }
    cout<<val<<endl;
  }
}