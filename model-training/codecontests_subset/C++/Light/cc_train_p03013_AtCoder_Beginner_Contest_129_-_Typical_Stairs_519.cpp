#include <bits/stdc++.h>
using namespace std;
 
int main() {
  int n,m,k,i;
  cin>>n>>m;
  vector<int> vec(n+1); 
  for( i=0; i<n+1; i++){
    vec.at(i)=1;
  }
  for ( i = 0; i < m; i++) {
    cin>>k;
    vec.at(k)=0;
    
  }
  for(i=2; i<n+1; i++){
    if(vec.at(i)==0){
    }
    else{
      vec.at(i)=(vec.at(i-1)+vec.at(i-2))%1000000007;
    }
  }
  cout<<vec.at(n);
}