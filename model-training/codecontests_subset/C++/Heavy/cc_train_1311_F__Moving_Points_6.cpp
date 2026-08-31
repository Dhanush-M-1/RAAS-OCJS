#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
using namespace std;
const long long MOD = 1e+9 + 7;
const long long INF = 0x7f7f7f7f7f7f7f7f;
const int INFi = 0x7f7f7f7f;
const long long MAXN = 2e+5 + 8;
vector<long long> adj[MAXN];
long long visit[MAXN] = {};
int dx8[] = {0, 1, 1, 1, 0, -1, -1, -1}, dy8[] = {1, 1, 0, -1, -1, -1, 0, 1};
int dx4[] = {0, 1, 0, -1}, dy4[] = {1, 0, -1, 0};
int t = 1;
long long n;
pair<long long, long long> seg[4 * MAXN + 8];
vector<pair<long long, long long> > arr;
vector<long long> v;
void build(long long n, long long st, long long en) {
  if (st == en) {
    seg[n] = arr[st];
    return;
  }
  long long mid = (st + en) / 2;
  build(2 * n, st, mid);
  build(2 * n + 1, mid + 1, en);
  seg[n].first = seg[2 * n].first + seg[2 * n + 1].first;
  seg[n].second = seg[2 * n].second + seg[2 * n + 1].second;
}
void update(long long n, long long st, long long en, long long pos,
            long long val1, long long val2) {
  if (st == en) {
    seg[n].first += val1;
    seg[n].second += val2;
    return;
  }
  long long mid = (st + en) / 2;
  if (pos <= mid)
    update(2 * n, st, mid, pos, val1, val2);
  else
    update(2 * n + 1, mid + 1, en, pos, val1, val2);
  seg[n].first = seg[2 * n].first + seg[2 * n + 1].first;
  seg[n].second = seg[2 * n].second + seg[2 * n + 1].second;
}
pair<long long, long long> query(long long n, long long st, long long en,
                                 long long l, long long r) {
  if (l <= st && en <= r) return seg[n];
  if (st > r || en < l) return {0, 0};
  long long mid = (st + en) / 2;
  pair<long long, long long> lq = query(2 * n, st, mid, l, r);
  pair<long long, long long> rq = query(2 * n + 1, mid + 1, en, l, r);
  pair<long long, long long> res;
  res.first = lq.first + rq.first;
  res.second = lq.second + rq.second;
  return res;
}
long long ans = 0;
void MAIN() {
  cin >> n;
  arr = vector<pair<long long, long long> >(n + 1, {0, 0});
  v = vector<long long>(n + 1, 0);
  for (long long i = (1); i <= n; i++) cin >> arr[i].first;
  for (long long i = (1); i <= n; i++) cin >> arr[i].second;
  for (long long i = (1); i <= n; i++) v[i] = arr[i].second;
  sort(1 + (arr).begin(), (arr).end());
  sort(1 + (v).begin(), (v).end());
  for (auto [x, sp] : arr) {
    if (x == 0) continue;
    long long pos = lower_bound(1 + (v).begin(), (v).end(), sp) - v.begin();
    ans += (query(1, 1, n, 1, pos).first * x) - (query(1, 1, n, 1, pos).second);
    update(1, 1, n, pos, 1, x);
  }
  cout << ans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout << fixed;
  cout << setprecision(10);
  ;
  mt19937 rnd(chrono::steady_clock::now().time_since_epoch().count());
  ;
  while (t--) {
    MAIN();
  }
}
