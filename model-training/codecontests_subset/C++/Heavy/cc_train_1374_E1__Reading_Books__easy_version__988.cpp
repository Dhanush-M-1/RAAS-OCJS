#include <bits/stdc++.h>
using namespace std;
const int N = 4e5 + 10, mod = 1e9 + 7;
int bitc[N], bit[N];
int n;
void add(int i, int va) {
  for (; i < N; i += (i & -i)) {
    bit[i] += va;
    bitc[i] += (va < 0 ? -1 : 1);
  }
}
long long getprefones(int va) {
  int i = 0;
  int cur = 0;
  long long ret = 0;
  for (int j = 20; j >= 0; j--) {
    if (i + (1 << j) < N && bitc[i + (1 << j)] + cur <= va) {
      cur += bitc[i + (1 << j)];
      ret += bit[i + (1 << j)];
      i += (1 << j);
    }
  }
  if (cur < va) ret = 2e9 + 5;
  return ret;
}
int main() {
  int tc = 1;
  for (int cn = 1; cn <= tc; cn++) {
    int m, k;
    scanf("%d%d%d", &n, &m, &k);
    vector<vector<pair<int, int>>> v(4);
    vector<vector<int>> pref(4);
    vector<pair<int, int>> vec;
    for (int i = 1; i <= n; i++) {
      int t, a, b;
      scanf("%d%d%d", &t, &a, &b);
      int m = (a * 2) + b;
      v[m].push_back({t, i});
      vec.push_back({t, i});
    }
    sort(vec.begin(), vec.end());
    vector<int> id(n + 1);
    for (int i = 0; i < n; i++)
      add(i + 1, vec[i].first), id[vec[i].second] = i + 1;
    for (int i = 0; i < 4; i++) {
      sort(v[i].begin(), v[i].end());
      if (v[i].size()) pref[i].push_back(v[i][0].first);
      for (int j = 1; j < v[i].size(); j++)
        pref[i].push_back(pref[i][j - 1] + v[i][j].first);
    }
    for (auto x : v[3]) add(id[x.second], -x.first);
    long long ans = 2e9 + 10;
    int b = -1;
    for (int i = 0; i < k && i < v[1].size(); i++)
      add(id[v[1][i].second], -v[1][i].first);
    for (int i = 0; i < k && i < v[2].size(); i++)
      add(id[v[2][i].second], -v[2][i].first);
    int l = min(k, (int)v[1].size()) - 1;
    int r = min(k, (int)v[2].size()) - 1;
    if (2 * k <= m && l == k - 1 && r == k - 1) {
      ans = min(ans, pref[1][k - 1] + pref[2][k - 1] + getprefones(m - 2 * k));
    }
    for (int i = 0; i < v[3].size(); i++) {
      long long cur = pref[3][i];
      int need = k - i - 1;
      int h = i + 1 + 2 * max(0, need);
      if (h > m) continue;
      while (l >= need && l >= 0) {
        add(id[v[1][l].second], v[1][l].first);
        l--;
      }
      while (r >= need && r >= 0) {
        add(id[v[2][r].second], v[2][r].first);
        r--;
      }
      if ((int)v[1].size() < need || (int)v[2].size() < need) continue;
      if (l >= 0) cur += pref[1][l] + pref[2][r];
      cur += getprefones(m - h);
      if (cur < ans) {
        ans = cur;
        b = i;
      }
    }
    if (ans > 2e9)
      puts("-1");
    else {
      printf("%lld\n", ans);
      int need = k - b - 1;
      vector<bool> vis(n + 1, 0);
      for (int i = 0; i <= b; i++)
        printf("%d ", v[3][i].second), vis[v[3][i].second] = 1;
      for (int i = 0; i < v[3].size(); i++) vis[v[3][i].second] = 1;
      for (int i = 0; i < need; i++)
        printf("%d ", v[2][i].second), vis[v[2][i].second] = 1;
      for (int i = 0; i < need; i++)
        printf("%d ", v[1][i].second), vis[v[1][i].second] = 1;
      int h = b + 1;
      if (need > 0) h += 2 * need;
      for (int i = 0; i < n && h < m; i++) {
        if (vis[vec[i].second]) continue;
        printf("%d ", vec[i].second);
        h++;
      }
    }
  }
  return 0;
}
