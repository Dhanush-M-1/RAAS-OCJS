#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, m, a1, b1;
  cin >> n;
  vector<int> a(n);
  priority_queue<pair<int, int>> y;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    y.push({a[i], -i});
  }
  vector<vector<int>> e(n);
  for (int i = 0; i < n; i++) {
    auto we = y.top();
    y.pop();
    if (i > 0) e[i] = e[i - 1];
    e[i].push_back(-we.second);
    sort(e[i].begin(), e[i].end());
  }
  cin >> m;
  for (int i = 0; i < m; i++) {
    cin >> a1 >> b1;
    cout << a[e[a1 - 1][b1 - 1]] << endl;
  }
  return 0;
}
