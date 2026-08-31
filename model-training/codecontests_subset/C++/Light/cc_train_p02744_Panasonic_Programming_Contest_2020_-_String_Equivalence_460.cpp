#include <bits/stdc++.h>
using namespace std;

int n;
void dfs(string s, int mx){
  if(s.size() == n) cout << s << endl;
  else{
    for(int i = 0; i <= mx; i++){
      char c = 'a' + i;
      if(i == mx) dfs(s + c, mx + 1);
      else dfs(s + c, mx);
    }
  }
}
  
int main() {
  cin >> n;
  dfs("", 0);
}