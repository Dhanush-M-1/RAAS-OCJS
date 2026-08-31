#include<bits/stdc++.h>
using namespace std;

int n;

void dfs(string s,char a){
  if(s.size()==n){
    cout << s << endl;
    return;
  }
  for(char now='a';now<=a+1;++now){
    if(now<a){
      dfs(s+now,a);
    }else{
      dfs(s+now,now);
    }
  }
}

int main(){
  cin >> n;
  dfs("",'a'-1);
  return 0;
}
