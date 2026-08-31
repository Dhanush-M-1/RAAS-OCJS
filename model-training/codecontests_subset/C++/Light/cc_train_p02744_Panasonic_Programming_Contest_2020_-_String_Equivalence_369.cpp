#include <bits/stdc++.h>
using namespace std;

void dfs(int n, int c = 1, string acc = "a") {
  if (acc.size() == n) {
    cout << acc << endl;
    return;
  }
  int nc = max(c, acc.back() - 'a' + 1);
  for (int i = 0; i <= nc; ++i)
    dfs(n, nc, acc + char('a' + i));
}

int main() {
  int n;
  cin >> n;

  dfs(n);
}