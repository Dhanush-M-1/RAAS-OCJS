#include<bits/stdc++.h>
using namespace std;
int main(){
  int N;
  cin>>N;
  map<string,int> A;
  while(N--){
    string S;
    cin>>S;
    A[S]++;
  }
  vector<string> S={"AC","WA","TLE","RE"};
  for(string s:S)
    cout<<s<<" x "<<A[s]<<endl;
}