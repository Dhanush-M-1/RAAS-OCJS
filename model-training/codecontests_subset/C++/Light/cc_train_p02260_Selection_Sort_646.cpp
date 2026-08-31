#include <bits/stdc++.h>
using namespace std;

signed main(){
  int n;cin>>n;
  vector<int> v(n);
  for(int i=0;i<n;i++)cin>>v[i];
  int ans=0;
  for(int i=0;i<n;i++){
    int minj=i;
    for(int j=i;j<n;j++){
      if(v[j]<v[minj]){
        minj=j;
      }
    }
    if(v[i]!=v[minj])swap(v[i],v[minj]),ans++;
  }
  for(int i=0;i<n;i++){
    if(i)cout<<" ";
    cout<<v[i];
  }
  cout<<endl<<ans<<endl;
}

