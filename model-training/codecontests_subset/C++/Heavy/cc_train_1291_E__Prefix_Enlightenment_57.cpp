#include <bits/stdc++.h>
using namespace std;
const int inf = (int)1e9 + 5;
const int N = 600010;
class DSU {
 public:
  int p[N], cost[N];
  int n;
  int ans = 0;
  DSU(int _n) : n(_n) {
    for (int i = 0; i < n; i++) {
      cost[2 * i + 1] = 1;
      cost[2 * i] = 0;
    }
    cost[2 * n] = inf;
    cost[2 * n + 1] = 0;
    for (int i = 0; i < 2 * n + 2; i++) {
      p[i] = i;
    }
  }
  int find(int x) { return (x == p[x] ? x : (p[x] = find(p[x]))); }
  void unite(int x, int y, bool same) {
    assert(0 <= 2 * x && 2 * x + 1 < 2 * n + 2);
    assert(0 <= 2 * y && 2 * y + 1 < 2 * n + 2);
    int x_true = find(2 * x + 1), y_true = find(2 * y + 1);
    int x_false = find(2 * x), y_false = find(2 * y);
    if (same) {
      if (x_true != y_true) {
        assert(x_false != y_false);
        ans -= min(cost[x_true], cost[x_false]);
        ans -= min(cost[y_true], cost[y_false]);
        cost[y_true] += cost[x_true];
        cost[y_false] += cost[x_false];
        p[x_true] = y_true;
        p[x_false] = y_false;
        ans += min(cost[y_true], cost[y_false]);
      } else {
        return;
      }
    } else {
      if (x_true != y_false) {
        assert(x_false != y_true);
        ans -= min(cost[x_true], cost[x_false]);
        ans -= min(cost[y_true], cost[y_false]);
        cost[y_true] += cost[x_false];
        cost[y_false] += cost[x_true];
        p[x_true] = y_false;
        p[x_false] = y_true;
        ans += min(cost[y_true], cost[y_false]);
      } else {
        return;
      }
    }
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  string s;
  cin >> s;
  vector<vector<int>> has(n);
  for (int i = 0; i < k; i++) {
    int size;
    cin >> size;
    while (size--) {
      int x;
      cin >> x;
      --x;
      has[x].push_back(i);
    }
  }
  DSU dsu(k);
  int dummy = k;
  for (int i = 0; i < n; i++) {
    if ((int)has[i].size() == 2) {
      dsu.unite(has[i][0], has[i][1], s[i] == '1');
    } else if ((int)has[i].size() == 1) {
      dsu.unite(has[i].back(), dummy, s[i] == '0');
    } else {
      assert(s[i] == '1');
    }
    cout << dsu.ans << '\n';
  }
  return 0;
}
