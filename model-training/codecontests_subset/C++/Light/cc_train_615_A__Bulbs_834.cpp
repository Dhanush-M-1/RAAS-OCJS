#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<bool> l(m, false);
  for (int i = 0; i < n; ++i) {
    int x, y;
    cin >> x;
    for (int j = 0; j < x; ++j) {
      cin >> y;
      l[y - 1] = true;
    }
  }
  bool ans = true;
  for (int i = 0; i < m; ++i) {
    if (l[i] == false) {
      ans = false;
      break;
    }
  }
  cout << (ans ? "YES" : "NO");
  cin.get();
  cin.get();
  return 0;
}
