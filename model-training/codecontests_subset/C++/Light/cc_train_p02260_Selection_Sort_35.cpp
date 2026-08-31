#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,mn,ans=0;
  int num[100];
  cin>>n;
  for(int i=0;i<n;i++){
    cin>>num[i];
  }
  for(int i=0;i<n;i++){
    mn=i;
    for(int j=i;j<n;j++){
      if(num[j]<num[mn]) mn=j;
    }
    swap(num[i],num[mn]);
    if(mn!=i) ans++;
  }
  for(int i=0;i<n;i++){
    if(i!=n-1) cout<<num[i]<<" ";
    else cout<<num[i];
  }
  cout<<endl;
  cout<<ans<<endl;
  return 0;
}

