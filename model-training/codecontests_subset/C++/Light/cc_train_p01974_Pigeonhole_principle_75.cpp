#include "bits/stdc++.h"
using namespace std;

int main(){
  int n;
  cin>>n;
  vector<int> a(n);
  for(int i=0;i<n;i++)cin>>a[i];
  sort(a.begin(),a.end());
  int ans=0;
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(i!=j){
        if(abs(a[i]-a[j])%(n-1)==0){
          cout<<a[i]<<" "<<a[j]<<endl;
          return 0;
        }
      }
    }
  }
  cout<<ans<<endl;
}

