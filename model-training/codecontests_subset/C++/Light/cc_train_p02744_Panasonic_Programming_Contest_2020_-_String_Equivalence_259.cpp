#include <bits/stdc++.h>
using namespace std;

void dfs(int n, string s, char c) {
  if (n == 0) {
    cout << s << "\n";
  } else {
    for (char next = 'a'; next <= c; next++) {
      dfs(n - 1, s + next, max(c, (char) (next + 1)));
    }
  }
}

int main() {
  int n;
  cin >> n;
  dfs(n, "", 'a');
}
