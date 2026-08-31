#include <bits/stdc++.h>
using namespace std;
void print(string S,int N,char m){
  if(N==0)cout<<S<<endl;
  else for(char a='a';a-m<=1;a++)print(S+a,N-1,max(a,m));
}
int main(){
  int N;cin>>N;string S="a";
  print(S,N-1,'a');
}
