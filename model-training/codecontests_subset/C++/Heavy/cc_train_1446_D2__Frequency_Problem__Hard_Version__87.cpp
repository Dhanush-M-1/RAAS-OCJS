#include <bits/stdc++.h>
using namespace std;
const long long M = 1e6;
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
long long binpow(long long a, long long b) {
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = res * a % M;
    a = a * a % M;
    b >>= 1;
  }
  return res;
}
void solve() {
  int n;
  cin >> n;
  vector<int> a(n);
  {
    for (auto& _re : a) cin >> _re;
  };
  vector<int> pos[200200];
  for (int i = 0; i < n; i++) {
    pos[a[i]].emplace_back(i);
  }
  int mx = 0;
  for (int i = 0; i <= 200000; i++) {
    if (pos[i].size() > pos[mx].size()) mx = i;
  }
  vector<int> id(n), ps(n);
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] == mx) {
      cnt++;
    }
    id[i] = cnt - 1;
    ps[i] = cnt;
  }
  int ans = 0;
  const int sq = 450;
  vector<int> q(2 * n + 5);
  for (int v = 0; v <= 200000; v++) {
    if (pos[v].size() == 0 or v == mx) continue;
    if (pos[v].size() == pos[mx].size()) {
      ans = n;
      break;
    }
    if (pos[v].size() >= sq) {
      vector<int> p(2 * n + 5);
      int d = 0;
      for (int i = 1; i <= n; i++) {
        if (a[i - 1] == mx) d++;
        if (a[i - 1] == v) d--;
        if (p[d + n] or d == 0) {
          ans = max(ans, i - p[d + n]);
        } else
          p[d + n] = i;
      }
      continue;
    }
    int k = pos[v].size();
    for (int i : pos[v]) {
      int d = 0;
      int li = 0;
      int lb = max(id[i] - k - 3, 0);
      int rb = min((int)pos[mx].size() - 1, id[i] + k + 3);
      vector<int> used;
      auto relax = [&](int x, int pt, int idx) {
        d += x;
        while (idx - 1 >= 0 && pos[v][idx - 1] >= pt) idx--;
        while (idx < pos[v].size() && pos[v][idx] <= pt) idx++;
        int rmost =
            min((id[pt] + 1 < pos[mx].size() ? pos[mx][id[pt] + 1] - 1 : n - 1),
                (idx < pos[v].size() ? pos[v][idx] - 1 : n - 1));
        if (q[d + n] or d == 0) {
          ans = max(ans, (rmost + 1) - q[d + n]);
        } else {
          q[d + n] = pt + 1;
          used.emplace_back(d + n);
        }
      };
      if (lb != 0)
        while (pos[v][li] < pos[mx][lb]) li++;
      q[n] = min(pos[mx][lb], pos[v][li]);
      if (id[q[n] - (q[n] == pos[mx][lb])] == -1) {
        q[n] = 0;
      }
      for (int j = lb; j <= rb; j++) {
        while (li < pos[v].size() && pos[v][li] < pos[mx][j]) {
          relax(-1, pos[v][li], li);
          li++;
        }
        relax(1, pos[mx][j], li);
      }
      if (rb == pos[mx].size() - 1) {
        while (li < pos[v].size()) {
          relax(-1, pos[v][li], li);
          li++;
        }
      }
      for (int x : used) {
        q[x] = 0;
      }
    }
  }
  cout << ans << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
}
