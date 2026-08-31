#include <bits/stdc++.h>
using namespace std;
int main(){
  int n,k[1005];
cin>>n;
for(int i=0;i<n;++i){cin>>k[i];}
for(int i=0;i<n;++i){
  for(int j=i+1;j<n;++j){
  if(abs(k[i]-k[j])%(n-1)==0){
   cout<<k[i]<<" "<<k[j]<<endl;
return 0;
}
}
}
}
