#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, m;
  cin >> n >> m;
  unordered_set<int> Set;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    for (int j = 0; j < x; j++) {
      int y;
      cin >> y;
      Set.insert(y);
    }
  }
  if (Set.size() == m) {
    cout << "YES";
  } else {
    cout << "NO";
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  solve();
  return 0;
}
