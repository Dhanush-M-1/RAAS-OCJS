#include<bits/stdc++.h>

using namespace std;

int main( ){
  int n,i,j;
  string s;
  unordered_map<string,int> m;
  cin>>n;
  for(i=0;i<n;i++){
    cin>>s;
    m[s]++;
  }
  string p[4]={"AC","WA","TLE","RE"};
  for(i=0;i<4;i++){
    cout<<p[i]<<" "<<"x"<<" "<<m[p[i]]<<endl;
  }
  return 0;
}