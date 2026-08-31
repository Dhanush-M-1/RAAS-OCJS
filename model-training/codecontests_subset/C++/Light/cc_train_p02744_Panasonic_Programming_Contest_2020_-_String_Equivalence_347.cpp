#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int N;

//再帰DFSで全列挙
void dfs(string s, char mx) {
  if (s.length() == N) {
    cout << s << endl;
    return;
  }
  for (char c = 'a'; c <= mx+1; c++) {
    string res = s + c;
    dfs(res, max(mx, c));
  }
}

int main() {
  cin >> N;
  dfs("", 'a'-1);
  return 0;
}
