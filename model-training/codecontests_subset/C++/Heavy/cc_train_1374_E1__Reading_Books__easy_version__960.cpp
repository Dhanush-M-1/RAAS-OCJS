#include <bits/stdc++.h>
using namespace std;
const int inf = 1 << 30;
const double pi = acos(-1);
const double eps = 1e-9;
const int mod = 1e9 + 7;
const int mf[] = {0, 0, 1, -1}, mc[] = {1, -1, 0, 0};
const int N = 1005;
mt19937 rng(
    (unsigned int)chrono::steady_clock::now().time_since_epoch().count());
template <typename T>
static T randint(T lo, T hi) {
  return uniform_int_distribution<T>(lo, hi)(rng);
}
template <typename T>
static T randreal(T lo, T hi) {
  return uniform_real_distribution<T>(lo, hi)(rng);
}
void nop() {
  cout << -1 << '\n';
  exit(0);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  rng.seed(time(0));
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<int, int>> a(1, {0, 0}), b(1, {0, 0}), c(1, {0, 0}), d(1, {0, 0});
  for (int i = 1; i <= n; i++) {
    int ti, ai, bi;
    cin >> ti >> ai >> bi;
    if (ai == 1 && bi == 0) a.push_back({ti, i});
    if (ai == 0 && bi == 1) b.push_back({ti, i});
    if (ai == 1 && bi == 1) c.push_back({ti, i});
    if (ai == 0 && bi == 0) d.push_back({ti, i});
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  sort(d.begin(), d.end());
  vector<int> ta(a.size()), tb(b.size()), tc(c.size()), td(d.size());
  int sa = a.size() - 1, sb = b.size() - 1, sc = c.size() - 1,
      sd = d.size() - 1;
  for (int i = 1; i <= sa; i++) ta[i] = ta[i - 1] + a[i].first;
  for (int i = 1; i <= sb; i++) tb[i] = tb[i - 1] + b[i].first;
  for (int i = 1; i <= sc; i++) tc[i] = tc[i - 1] + c[i].first;
  for (int i = 1; i <= sd; i++) td[i] = td[i - 1] + d[i].first;
  int ans = -1, ita, itb, itc, itd;
  for (int fix = 0; fix <= sc && fix <= m; fix++) {
    if (sa < k - fix || sb < k - fix) continue;
    int s = tc[fix] + (((k - fix) >= 0) ? ta[k - fix] + tb[k - fix] : 0);
    int t = fix + max(0, (k - fix) * 2);
    if (t > m) continue;
    if (t == m) {
      if (ans == -1 || ans > s) {
        ans = s;
        ita = max(0, k - fix);
        itb = max(0, k - fix);
        itc = fix;
        itd = 0;
      }
      continue;
    }
    int ra = ((k - fix) >= 0) ? k - fix : 0;
    int rb = ((k - fix) >= 0) ? k - fix : 0;
    if (sa - ra + sb - rb + sd < m - t) continue;
    int lo = min({a[ra].first, b[ra].first}), hi = 10000;
    if (sd > 0) lo = min(lo, d[1].first);
    while (lo < hi) {
      int mid = (lo + hi) >> 1;
      int upa =
          upper_bound(a.begin(), a.end(), make_pair(mid, inf)) - a.begin() - 1;
      int upb =
          upper_bound(b.begin(), b.end(), make_pair(mid, inf)) - b.begin() - 1;
      int upd =
          upper_bound(d.begin(), d.end(), make_pair(mid, inf)) - d.begin() - 1;
      if (max(0, upa - ra) + max(0, upb - rb) + upd >= m - t)
        hi = mid;
      else
        lo = mid + 1;
    }
    int upa =
        upper_bound(a.begin(), a.end(), make_pair(lo - 1, inf)) - a.begin() - 1;
    int upb =
        upper_bound(b.begin(), b.end(), make_pair(lo - 1, inf)) - b.begin() - 1;
    int upd =
        upper_bound(d.begin(), d.end(), make_pair(lo - 1, inf)) - d.begin() - 1;
    s += max(0, ta[upa] - ta[ra]) + max(0, tb[upb] - tb[rb]) + td[upd];
    t += max(0, upa - ra) + max(0, upb - rb) + upd;
    s += max(0, (m - t) * lo);
    if (ans == -1 || ans > s) {
      ans = s;
      ita = max(ra, upa);
      itb = max(rb, upb);
      itc = fix;
      itd = upd;
    }
  }
  cout << ans << '\n';
  if (ans != -1) {
    vector<int> g;
    multiset<pair<int, int>> ms;
    for (int i = 1; i <= sa; i++)
      if (i <= ita)
        g.push_back(a[i].second);
      else
        ms.insert(a[i]);
    for (int i = 1; i <= sb; i++)
      if (i <= itb)
        g.push_back(b[i].second);
      else
        ms.insert(b[i]);
    for (int i = 1; i <= sc; i++)
      if (i <= itc)
        g.push_back(c[i].second);
      else
        ms.insert(c[i]);
    for (int i = 1; i <= sd; i++)
      if (i <= itd)
        g.push_back(d[i].second);
      else
        ms.insert(d[i]);
    while ((int)g.size() < m) {
      g.push_back(ms.begin()->second);
      ms.erase(ms.begin());
    }
    for (int i = 0; i < m; i++) cout << g[i] << " \n"[i == m - 1];
  }
  return 0;
}
