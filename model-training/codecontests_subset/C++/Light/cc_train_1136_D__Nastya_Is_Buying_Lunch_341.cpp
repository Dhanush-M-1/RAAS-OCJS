#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  vector<int> v[n + 1];
  int x, y;
  for (int i = 0; i < m; i++) {
    cin >> x >> y;
    v[x].push_back(y);
  }
  set<int> s;
  s.insert(a[n - 1]);
  int ans = 0;
  for (int i = n - 2; i >= 0; i--) {
    int cnt = 0;
    for (int j = 0; j < v[a[i]].size(); j++) {
      if (s.find(v[a[i]][j]) != s.end()) {
        cnt++;
      }
    }
    if (cnt == s.size()) {
      ans++;
    } else {
      s.insert(a[i]);
    }
  }
  cout << ans << endl;
}
