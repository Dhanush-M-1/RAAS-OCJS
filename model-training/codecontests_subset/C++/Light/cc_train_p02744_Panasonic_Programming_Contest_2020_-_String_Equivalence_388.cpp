#include<bits/stdc++.h>
using namespace std;
int n;
void dfs(string s,char c){
  if(s.length()==n) cout<<s<<endl;
  else for(char d='a'; d<=c; ++d) dfs(s+d,(c==d? (char)(c+1):c));
}
int main(void){
  cin>>n;
  dfs("",'a');
  return 0;
}