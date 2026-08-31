#include <bits/stdc++.h>
using namespace std;

void dfs(string s, char mx,int N){
  if(s.size() == N) cout << s << endl;
  else{
    for(char c = 'a'; c<=mx; c++) dfs(s+c,(c==mx)?(char)(mx+1):mx, N);
  }
}

int main(){
  int N; cin >> N;
  dfs("",'a',N);
}