#include <bits/stdc++.h>
using namespace std;
struct seg {
  vector<long long> tree;
  int n;
  seg(int n) {
    tree = vector<long long>(n);
    for (int i = 0; i < n; i++) tree[i] = 0;
  }
  void update(int node, int l, int r, int x, int y) {
    if (l > r) return;
    if (x > r || x < l) return;
    if (l == x && r == x) {
      tree[node] += y;
      return;
    }
    update(2 * node + 1, l, (l + r) / 2, x, y);
    update(2 * node + 2, (l + r) / 2 + 1, r, x, y);
    tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
  }
  long long get(int node, int l, int r, int x, int y) {
    if (x > y) return 0;
    if (l > r) return 0;
    if (x > r || y < l) return 0;
    if (l >= x && r <= y) return tree[node];
    return get(2 * node + 1, l, (l + r) / 2, x, y) +
           get(2 * node + 2, (l + r) / 2 + 1, r, x, y);
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<long long> x(n), v(n);
  for (int i = 0; i < n; i++) {
    cin >> x[i];
  }
  set<int> D;
  vector<int> Z;
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    if (D.count(v[i]) == 0) Z.push_back(v[i]);
    D.insert(v[i]);
  }
  sort(Z.begin(), Z.end());
  map<int, int> dp;
  for (int i = 0; i < Z.size(); i++) {
    dp[Z[i]] = i;
  }
  for (int i = 0; i < n; i++) {
    v[i] = dp[v[i]];
  }
  vector<pair<int, int>> S;
  seg t1(3 * 2000000), t2(3 * 2000000);
  for (int i = 0; i < n; i++) {
    S.push_back(make_pair(x[i], v[i]));
  }
  sort(S.begin(), S.end());
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    long long x1 = t1.get(0, 0, 2000000 - 1, 0, S[i].second);
    long long x2 = t2.get(0, 0, 2000000 - 1, 0, S[i].second);
    ans += (S[i].first * x1 - x2);
    t1.update(0, 0, 2000000 - 1, S[i].second, 1);
    t2.update(0, 0, 2000000 - 1, S[i].second, S[i].first);
  }
  cout << ans << '\n';
  return 0;
}
