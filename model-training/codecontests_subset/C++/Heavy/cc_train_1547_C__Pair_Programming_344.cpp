#include <bits/stdc++.h>
using namespace std;

int main(){
  int t;
  cin>>t;
  while(t--){
    int k,n,m;
    cin>>k>>n>>m;
    vector<int>a(n);
    for(int i{0};i<n;i++){
      cin>>a[i];
    }
    vector<int>b(m);
    for(int i{0};i<m;i++){
      cin>>b[i];
    }
    vector<int>v(m+n);
    int i{0},j{0},p{0};
    while(i<n && j<m){
      if(a[i]>=b[j]){
        v[p++]=(b[j]);
        j++;
      }else{
        v[p++]=(a[i]);
        i++;
      }
    }
    while(i<n){
      v[p++]=(a[i]);
      i++;
    }
    while(j<m){
      v[p++]=(b[j]);
      j++;
    }
    bool ans = true;
    
    for(auto i:v){
      if(i==0){
        k++;
      }
      else if(i>k){
        ans = false;
      }
    }
    if(ans == true){
      for(auto i:v){
        cout<<i<<" ";
      }
      cout<<endl;
    }
    else if(ans == false){
      cout<<-1<<endl;
    }
  }
  return 0;
}