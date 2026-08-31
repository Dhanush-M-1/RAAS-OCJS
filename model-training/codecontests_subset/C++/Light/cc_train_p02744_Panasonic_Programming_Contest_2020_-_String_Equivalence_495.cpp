#include <bits/stdc++.h>
using namespace std;

void dfs(int n, char c = 'a', string acc = "a") {
  if (acc.size() == n) {
    cout << acc << endl;
    return;
  }
  int nc = c > acc.back() ? c : c + 1;
  for (char c = 'a'; c <= nc; ++c)
    dfs(n, nc, acc + c);
}

int main() {
  int n;
  cin >> n;

  dfs(n);
}