#include<bits/stdc++.h>
using namespace std;
int n;
void dfs(string s, char now) {
  if(s.size()==n) {
    cout<<s<<endl;
    return;
  }
  for(char i='a';i<now;i++) {
    dfs(s+i,now);
  }
  dfs(s+now,now+1);
}
 
int main() {
  cin>>n;
  dfs("",'a');
}