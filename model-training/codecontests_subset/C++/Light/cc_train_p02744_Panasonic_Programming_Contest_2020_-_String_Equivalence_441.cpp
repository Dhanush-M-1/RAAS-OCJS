#include<bits/stdc++.h>
using namespace std;
int N;

void dfs(string s, char mc){
  if(s.size()==N){
    cout << s << endl;
  }else{
    for(char c='a'; c<=mc; c++){
      if(c==mc){
        dfs(s+c, (char)(mc+1));
      }else{
        dfs(s+c, mc);
      }
    }
  }
}

int main(){
  cin >> N;
  dfs("",'a');
  return 0;
}