#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
int x[maxn], y[maxn];
unordered_set<int> row[maxn], col[maxn];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i];
    row[x[i]].insert(y[i]);
    col[y[i]].insert(x[i]);
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    if (row[x[i]].size() < col[y[i]].size()) {
      for (int u : row[x[i]]) {
        if ((u > y[i]) && (x[i] + u - y[i] < maxn - 5) &&
            (row[x[i] + u - y[i]].find(y[i]) != row[x[i]].end()) &&
            (row[x[i] + u - y[i]].find(u) != row[x[i]].end()))
          ans++;
      }
    } else {
      for (int u : col[y[i]]) {
        if ((u > x[i]) && (y[i] + u - x[i] < maxn - 5) &&
            (col[y[i] + u - x[i]].find(x[i]) != col[y[i]].end()) &&
            (col[y[i] + u - x[i]].find(u) != col[y[i]].end()))
          ans++;
      }
    }
  }
  cout << ans;
  return 0;
}
