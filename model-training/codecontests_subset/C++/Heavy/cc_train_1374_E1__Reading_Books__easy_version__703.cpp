#include <bits/stdc++.h>
const int N = (int)5e5 + 7;
const int inf = (int)1e9 + 7;
const int mod = (int)1e9 + 7;
const long long linf = (long long)1e18 + 7;
const int dx[] = {-1, 0, 1, 0, 1, -1, -1, 1};
const int dy[] = {0, 1, 0, -1, 1, -1, 1, -1};
using namespace std;
int n, k, need;
long long p1[N], p2[N];
struct tree {
  int cnt[N << 2];
  long long t[N << 2];
  void upd(int p, int x, int v = 1, int tl = 1, int tr = N) {
    if (tl == tr) {
      cnt[v] += x;
      t[v] = (long long)cnt[v] * tl;
      return;
    }
    int tm = tl + tr >> 1;
    if (p <= tm)
      upd(p, x, v << 1, tl, tm);
    else
      upd(p, x, v << 1 | 1, tm + 1, tr);
    cnt[v] = cnt[v << 1] + cnt[v << 1 | 1];
    t[v] = t[v << 1] + t[v << 1 | 1];
  }
  long long get(int k, int v = 1, int tl = 1, int tr = N) {
    if (tl == tr) {
      return k * tl;
    }
    int tm = tl + tr >> 1;
    if (cnt[v << 1] >= k) return get(k, v << 1, tl, tm);
    return get(k - cnt[v << 1], v << 1 | 1, tm + 1, tr) + t[v << 1];
  }
} t;
void solve() {
  cin >> n >> need >> k;
  vector<pair<int, int>> l, m, r, free;
  for (int i = (1); i <= (n); i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a && b)
      m.push_back({t, i});
    else if (a)
      l.push_back({t, i});
    else if (b)
      r.push_back({t, i});
    else
      free.push_back({t, i});
  }
  sort(m.begin(), m.end());
  sort(l.begin(), l.end());
  sort(r.begin(), r.end());
  sort(free.begin(), free.end());
  int can1 = min((int)l.size(), (int)r.size()), can2 = (int)m.size();
  for (int i = (can1 + 1); i <= ((int)l.size()); i++) {
    t.upd(l[i - 1].first, 1);
  }
  for (int i = (can1 + 1); i <= ((int)r.size()); i++) {
    t.upd(r[i - 1].first, 1);
  }
  for (int i = (1); i <= (can1); i++) {
    p1[i] = p1[i - 1] + (l[i - 1].first + r[i - 1].first);
    t.upd(l[i - 1].first, 1);
    t.upd(r[i - 1].first, 1);
  }
  for (int i = (1); i <= (can2); i++) {
    p2[i] = p2[i - 1] + (m[i - 1].first);
    t.upd(m[i - 1].first, 1);
  }
  for (auto it : free) {
    t.upd(it.first, 1);
  }
  long long mn = linf;
  int opt = -1, ptr = 0;
  for (int i = (0); i <= (can1); i++) {
    int x = i, y = k - x;
    if (i) {
      t.upd(l[i - 1].first, -1);
      t.upd(r[i - 1].first, -1);
    }
    while (ptr < min(y, can2)) {
      ++ptr;
      t.upd(m[ptr - 1].first, -1);
    }
    if (y <= can2 && 2 * x + y <= need) {
      long long extra = t.get(need - 2 * x - y);
      long long sum = p1[x] + p2[y] + extra;
      if (mn > sum) {
        mn = sum;
        opt = i;
      }
    }
  }
  if (mn == linf) {
    cout << -1 << '\n';
    return;
  }
  vector<int> ans;
  int x = opt, y = k - x;
  for (int i = (1); i <= (x); i++)
    ans.push_back(l[i - 1].second), ans.push_back(r[i - 1].second);
  for (int i = (1); i <= (y); i++) ans.push_back(m[i - 1].second);
  multiset<pair<int, int>> extra;
  for (int i = (x + 1); i <= ((int)l.size()); i++) {
    extra.insert(l[i - 1]);
  }
  for (int i = (x + 1); i <= ((int)r.size()); i++) {
    extra.insert(r[i - 1]);
  }
  for (int i = (y + 1); i <= (can2); i++) {
    extra.insert(m[i - 1]);
  }
  for (auto it : free) extra.insert(it);
  int ost = need - 2 * x - y;
  while (ost--) {
    ans.push_back(extra.begin()->second);
    extra.erase(extra.begin());
  }
  cout << mn << '\n';
  for (auto it : ans) {
    cout << it << ' ';
  }
}
int main() {
  ios_base ::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
  exit(0);
}
