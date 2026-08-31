#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3fll;
const int N = 1e4 + 10;
const int M = 3e6 + 10;
const int maxn = 1e6 + 10;
const int mod = 1000173169;
const double eps = 1e-10;
const double pi = acos(-1.0);
struct Tree {
  int num[N << 2], sum[N << 2];
  void add(int rt, int l, int r, int p) {
    num[rt]++;
    sum[rt] += p;
    if (l == r) return;
    int mid = ((l + r) >> 1);
    if (p <= mid)
      add(rt << 1, l, mid, p);
    else
      add(rt << 1 | 1, mid + 1, r, p);
  }
  int getPos(int rt, int l, int r, int& val) {
    if (l == r) return l;
    int mid = ((l + r) >> 1);
    if (num[rt << 1] >= val)
      return getPos(rt << 1, l, mid, val);
    else {
      val -= num[rt << 1];
      return getPos(rt << 1 | 1, mid + 1, r, val);
    }
  }
  int getSum(int rt, int l, int r, int pos) {
    if (r <= pos) return sum[rt];
    int mid = ((l + r) >> 1);
    int res = 0;
    if (l <= pos) res = getSum(rt << 1, l, mid, pos);
    if (mid < pos) res += getSum(rt << 1 | 1, mid + 1, r, pos);
    return res;
  }
} seg;
int n, m, k;
vector<int> id;
vector<pair<int, int> > a[3], b, p, res;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  int mx = 1e4;
  for (int i = 1; i <= n; i++) {
    int t, x, y;
    cin >> t >> x >> y;
    x = x << 1 | y;
    if (x == 3)
      b.emplace_back(t, i);
    else if (x)
      a[x].emplace_back(t, i);
    else {
      seg.add(1, 1, mx, t);
      res.emplace_back(t, i);
    }
  }
  sort(a[1].begin(), a[1].end());
  sort(a[2].begin(), a[2].end());
  sort(b.begin(), b.end());
  int cnt1 = 0, cnt2 = 0;
  int t1 = min(min(((int)a[1].size()), ((int)a[2].size())), k);
  int cur = 0;
  for (int i = 0; i < t1; i++) {
    cur += a[1][i].first + a[2][i].first;
    p.emplace_back(a[1][i].first, a[2][i].first);
    cnt1++;
    cnt2 += 2;
  }
  for (int i = t1; i < max(((int)a[1].size()), ((int)a[2].size())); i++) {
    if (i < ((int)a[1].size()))
      seg.add(1, 1, mx, a[1][i].first), res.push_back(a[1][i]);
    if (i < ((int)a[2].size()))
      seg.add(1, 1, mx, a[2][i].first), res.push_back(a[2][i]);
  }
  for (int i = k; i < ((int)b.size()); i++) {
    seg.add(1, 1, mx, b[i].first);
    res.push_back(b[i]);
  }
  int P = -1;
  long long ans = INF;
  int t2 = min(((int)b.size()), k);
  for (int i = 0; i <= t2; i++) {
    if (cnt1 == k && cnt2 <= m) {
      long long res = INF;
      if (cnt2 == m)
        res = cur;
      else if (cnt2 + seg.num[1] >= m) {
        int val = m - cnt2;
        int pos = seg.getPos(1, 1, mx, val);
        res = pos * val + cur;
        if (pos > 1) res += seg.getSum(1, 1, mx, pos - 1);
      }
      if (ans > res) {
        ans = res;
        P = i;
      }
    }
    if (i < t2) {
      if (cnt1 < k) {
        cur += b[i].first;
        cnt1++;
        cnt2++;
      } else if (!p.empty()) {
        pair<int, int> t = p.back();
        p.pop_back();
        cur -= t.first + t.second;
        seg.add(1, 1, mx, t.first);
        seg.add(1, 1, mx, t.second);
        cur += b[i].first;
        cnt2--;
      }
    }
  }
  if (ans == INF)
    cout << "-1\n";
  else {
    cout << ans << '\n';
    for (int i = 0; i < P; i++) id.push_back(b[i].second);
    for (int i = 0; i < t1; i++) {
      if (P + i + 1 <= k) {
        id.push_back(a[1][i].second);
        id.push_back(a[2][i].second);
      } else {
        res.push_back(a[1][i]);
        res.push_back(a[2][i]);
      }
    }
    sort(res.begin(), res.end());
    for (int i = 0; i < ((int)res.size()); i++) {
      if (((int)id.size()) == m) break;
      id.push_back(res[i].second);
    }
    for (int v : id) cout << v << ' ';
    cout << '\n';
    assert(((int)id.size()) == m);
  }
  return 0;
}
