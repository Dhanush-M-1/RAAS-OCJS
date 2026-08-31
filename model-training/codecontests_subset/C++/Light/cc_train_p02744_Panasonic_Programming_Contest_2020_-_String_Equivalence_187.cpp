#include <bits/stdc++.h>
using namespace std;

int N;

void dfs(string s, char end){
  if(s.size()==N){
    cout<<s<<endl;
    return ;
  }
  for(char c='a';c<=end;c++){
    if(c!=end) dfs(s+c, end);
    else dfs(s+c, char(end+1));
  }
}

int main() {
cin>>N;

dfs("", 'a');
}
