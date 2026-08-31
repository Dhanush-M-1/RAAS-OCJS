#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 1e5 + 10, md = 1e9 + 7;
vector<pair<long long, long long>> adj[MAXN], child[MAXN];
long long ls[MAXN], start[MAXN], finish[MAXN], h[MAXN], sum[4 * MAXN],
    sum2[4 * MAXN], lazy[4 * MAXN];
long long n, a1, a2, a3, cnt;
void rel(long long& a) {
  if (a >= md) a %= md;
}
void build(long long v, long long par) {
  ls[cnt] = v;
  start[v] = cnt++;
  for (auto i : adj[v])
    if (i.first != par) {
      h[i.first] = h[v] + i.second;
      rel(h[i.first]);
      child[v].push_back(i);
      build(i.first, v);
    }
  finish[v] = cnt;
}
void init(long long v, long long b, long long e) {
  if (e - b == 1) {
    sum[v] = h[ls[b]];
    sum2[v] = sum[v] * sum[v];
    rel(sum2[v]);
    return;
  }
  long long mid = (b + e) / 2;
  init(2 * v, b, mid);
  init(2 * v + 1, mid, e);
  sum[v] = sum[2 * v] + sum[2 * v + 1];
  sum2[v] = sum2[2 * v] + sum2[2 * v + 1];
  rel(sum[v]);
  rel(sum2[v]);
}
void shift(long long v, long long b, long long e) {
  long long mid = (b + e) / 2;
  sum2[2 * v] = sum2[2 * v] + lazy[v] * 2 * sum[2 * v] +
                ((lazy[v] * lazy[v]) % md) * (mid - b);
  sum[2 * v] = sum[2 * v] + (mid - b) * lazy[v];
  sum2[2 * v + 1] = sum2[2 * v + 1] + lazy[v] * 2 * sum[2 * v + 1] +
                    ((lazy[v] * lazy[v]) % md) * (e - mid);
  sum[2 * v + 1] = sum[2 * v + 1] + (e - mid) * lazy[v];
  lazy[2 * v] = lazy[2 * v] + lazy[v];
  lazy[2 * v + 1] = lazy[2 * v + 1] + lazy[v];
  rel(sum2[2 * v]);
  rel(sum[2 * v]);
  rel(sum2[2 * v + 1]);
  rel(sum[2 * v + 1]);
  rel(lazy[2 * v]);
  rel(lazy[2 * v + 1]);
  lazy[v] = 0;
}
void upd(long long v, long long b, long long e, long long l, long long r,
         long long val) {
  if (r <= b || e <= l) return;
  if (l <= b && e <= r) {
    sum2[v] = sum2[v] + sum[v] * 2 * val + ((val * val) % md) * (e - b);
    sum[v] = sum[v] + (e - b) * val;
    lazy[v] = lazy[v] + val;
    rel(sum2[v]);
    rel(sum[v]);
    rel(lazy[v]);
    return;
  }
  long long mid = (b + e) / 2;
  shift(v, b, e);
  upd(2 * v, b, mid, l, r, val);
  upd(2 * v + 1, mid, e, l, r, val);
  sum2[v] = sum2[2 * v] + sum2[2 * v + 1];
  sum[v] = sum[2 * v] + sum[2 * v + 1];
  rel(sum2[v]);
  rel(sum[v]);
}
long long find(long long v, long long b, long long e, long long l,
               long long r) {
  if (r <= b || e <= l) return 0;
  if (l <= b && e <= r) return sum2[v];
  long long mid = (b + e) / 2;
  shift(v, b, e);
  return (find(2 * v, b, mid, l, r) + find(2 * v + 1, mid, e, l, r)) % md;
}
long long res[MAXN];
vector<pair<long long, long long>> query[MAXN];
void dfs(long long v) {
  for (auto i : query[v]) {
    res[i.second] = find(1, 0, n, start[i.first], finish[i.first]) * 2 +
                    md * 10 - find(1, 0, n, 0, n);
    rel(res[i.second]);
  }
  for (auto i : child[v]) {
    upd(1, 0, n, start[i.first], finish[i.first], (md * 10 - i.second) % md);
    upd(1, 0, n, 0, start[i.first], i.second);
    upd(1, 0, n, finish[i.first], n, i.second);
    dfs(i.first);
    upd(1, 0, n, start[i.first], finish[i.first], i.second);
    upd(1, 0, n, 0, start[i.first], (md * 10 - i.second) % md);
    upd(1, 0, n, finish[i.first], n, (md * 10 - i.second) % md);
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (long long i = 1; i < n; ++i) {
    cin >> a1 >> a2 >> a3;
    adj[a1].push_back({a2, a3 % md});
    adj[a2].push_back({a1, a3 % md});
  }
  build(1, 0);
  init(1, 0, n);
  long long q;
  cin >> q;
  for (long long i = 0; i < q; ++i) {
    cin >> a1 >> a2;
    query[a1].push_back({a2, i});
  }
  dfs(1);
  for (long long i = 0; i < q; ++i) cout << res[i] << '\n';
  return 0;
}
