#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, x, y;
  cin >> n >> m;
  int hash[m];
  for (int i = 1; i <= m; i++) {
    hash[i] = 0;
  }
  vector<int> v[n];
  for (int i = 0; i < n; i++) {
    cin >> y;
    for (int j = 0; j < y; j++) {
      cin >> x;
      v[i].push_back(x);
      hash[x] = 1;
    }
  }
  int c = 0;
  for (int i = 1; i <= m; i++) {
    if (hash[i] == 1) {
      c++;
    }
  }
  if (c == m) {
    cout << "YES\n";
    return 0;
  }
  cout << "NO\n";
  return 0;
}
