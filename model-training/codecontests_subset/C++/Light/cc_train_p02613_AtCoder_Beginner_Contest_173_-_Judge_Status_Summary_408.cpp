#include<bits/stdc++.h>
using namespace std;
using ll = long long;
int main(){
  int n;
  cin>>n;
  map<string,int> x;
  for(int i=0;i<n;i++){
    string s;
    cin>>s;
    x[s]++;
  }
  for(string s:{"AC","WA","TLE","RE"}){
    cout<<s<<" x "<<x[s]<<endl;
  }
}