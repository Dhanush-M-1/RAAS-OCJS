#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, x, y;
  set<int> s;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    for (int j = 1; j <= x; j++) {
      cin >> y;
      s.insert(y);
    }
  }
  if (s.size() == m) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }
  return 0;
}
