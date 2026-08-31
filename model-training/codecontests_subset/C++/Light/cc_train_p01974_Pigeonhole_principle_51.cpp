#include<bits/stdc++.h>
using namespace std;
using Int = long long;
//INSERT ABOVE HERE
signed main(){
  Int n;
  cin>>n;
  vector<Int> a(n);
  for(Int i=0;i<n;i++) cin>>a[i];
  for(Int i=0;i<n;i++){
    for(Int j=0;j<i;j++){
      if(abs(a[i]-a[j])%(n-1)==0){
	cout<<a[i]<<" "<<a[j]<<endl;
	return 0;
      }
    }
  }
  return 0;
}

