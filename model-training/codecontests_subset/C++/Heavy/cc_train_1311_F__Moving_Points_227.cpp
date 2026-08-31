#include <bits/stdc++.h>
using namespace std;
long long int g[800010][2];
void up(int l, int r, int n, int x, int i, long long int val) {
  if (l == r) {
    g[n][i] = val;
  } else {
    int mid = (l + r) / 2;
    if (x <= mid && x >= l)
      up(l, mid, 2 * n, x, i, val);
    else
      up(mid + 1, r, 2 * n + 1, x, i, val);
    g[n][i] = g[2 * n][i] + g[2 * n + 1][i];
  }
  return;
}
long long int q(int l, int r, int n, int st, int en, int i) {
  if (en == 0) return 0;
  if (st <= l && r <= en) {
    return g[n][i];
  } else if (r < st || en < l)
    return 0;
  else {
    int mid = (l + r) / 2;
    return (q(l, mid, 2 * n, st, en, i) + q(mid + 1, r, 2 * n + 1, st, en, i));
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  vector<pair<long long int, long long int> > v(n);
  vector<int> x(n);
  map<int, int> m;
  for (int i = 0; i < n; i++) {
    cin >> v[i].second;
    x[i] = v[i].second;
  }
  for (int i = 0; i < n; i++) cin >> v[i].first;
  sort(x.begin(), x.end());
  for (int i = 0; i < x.size(); i++) {
    m[x[i]] = i + 1;
  }
  sort(v.begin(), v.end());
  long long int ans = 0;
  for (int i = 0; i < n; i++) {
    long long int z = q(1, n, 1, 1, m[v[i].second], 0);
    long long int z1 = q(1, n, 1, 1, m[v[i].second], 1);
    ans += (v[i].second * z1 - z);
    up(1, n, 1, m[v[i].second], 0, v[i].second);
    up(1, n, 1, m[v[i].second], 1, 1);
  }
  cout << ans;
  return 0;
}
