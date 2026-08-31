#include <bits/stdc++.h>
using namespace std;
inline int in() {
  int x;
  scanf("%d", &x);
  return x;
}
const long double EPS = 1e-12;
const int INF = 1e9 + 10;
const long long LINF = 1000ll * 1000 * 1000 * 1000 * 1000 * 1000 + 100;
const int MN = 1e5 + 10;
const int MOD = 1e9 + 7;
int n, q;
vector<pair<int, int> > adj[MN], qr[MN];
int ans[MN];
long long mul[4 * MN], seg[4 * MN], lz[4 * MN];
int Time, st[MN], ft[MN];
long long d_tmp[MN];
int rev[MN];
void input() {
  scanf("%d", &n);
  for (int i = 0; i < n - 1; ++i) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    --a, --b;
    adj[a].push_back(pair<int, int>(b, c)),
        adj[b].push_back(pair<int, int>(a, c));
  }
  scanf("%d", &q);
  for (int i = 0; i < q; ++i) {
    int u, v;
    scanf("%d%d", &u, &v);
    --u, --v;
    qr[u].push_back(pair<int, int>(v, i));
  }
}
void dfs_prep(int s, int pr, long long cur) {
  st[s] = Time++;
  rev[st[s]] = s;
  d_tmp[s] = cur;
  for (int i = 0; i < ((int)(adj[s]).size()); ++i) {
    int v = adj[s][i].first;
    if (v == pr) continue;
    dfs_prep(v, s, (cur + adj[s][i].second) % MOD);
  }
  ft[s] = Time;
}
void change(int segnum, int val, int left, int right) {
  int t = right - left + 1, mid = (left + right) >> 1;
  mul[segnum] = (1ll * mul[segnum] +
                 ((1ll * val * val) % MOD * (1ll * t * (t - 1) / 2)) % MOD) %
                MOD;
  mul[segnum] =
      (1ll * mul[segnum] + ((seg[segnum] * (t - 1)) % MOD * val) % MOD) % MOD;
  if (mul[segnum] < 0) mul[segnum] += MOD;
  seg[segnum] = (1ll * seg[segnum] + 1ll * val * t) % MOD;
  if (seg[segnum] < 0) seg[segnum] += MOD;
}
void shift(int segnum, int left, int right) {
  int mid = (left + right) >> 1;
  change(2 * segnum, lz[segnum], left, mid);
  change(2 * segnum + 1, lz[segnum], mid + 1, right);
  lz[2 * segnum] += lz[segnum], lz[2 * segnum + 1] += lz[segnum];
  lz[2 * segnum] %= MOD, lz[2 * segnum + 1] %= MOD, lz[segnum] = 0;
}
void build(int segnum, int left, int right) {
  if (left == right) {
    seg[segnum] = d_tmp[rev[left]];
    return;
  }
  int mid = (left + right) >> 1;
  build(2 * segnum, left, mid), build(2 * segnum + 1, mid + 1, right);
  seg[segnum] = (seg[2 * segnum] + seg[2 * segnum + 1]) % MOD;
  mul[segnum] = (mul[2 * segnum] + mul[2 * segnum + 1]) % MOD;
  mul[segnum] = (mul[segnum] + seg[2 * segnum] * seg[2 * segnum + 1]) % MOD;
}
void upd(int segnum, int left, int right, int l, int r, int val) {
  if (r < left || right < l) return;
  if (l <= left && right <= r) {
    change(segnum, val, left, right);
    lz[segnum] = (lz[segnum] + val) % MOD;
    return;
  }
  shift(segnum, left, right);
  int mid = (left + right) >> 1;
  upd(2 * segnum, left, mid, l, r, val),
      upd(2 * segnum + 1, mid + 1, right, l, r, val);
  seg[segnum] = (seg[2 * segnum] + seg[2 * segnum + 1]) % MOD;
  mul[segnum] = (mul[2 * segnum] + mul[2 * segnum + 1]) % MOD;
  mul[segnum] =
      (mul[segnum] + (seg[2 * segnum] * seg[2 * segnum + 1]) % MOD) % MOD;
}
long long get(int segnum, int left, int right, int l, int r) {
  if (r < left || right < l) return 0;
  if (l <= left && right <= r)
    return ((seg[segnum] * seg[segnum]) % MOD - (2ll * mul[segnum]) % MOD +
            MOD) %
           MOD;
  int mid = (left + right) >> 1;
  shift(segnum, left, right);
  return (get(2 * segnum, left, mid, l, r) +
          get(2 * segnum + 1, mid + 1, right, l, r)) %
         MOD;
}
void dfs(int s, int pr, int c) {
  for (int i = 0; i < ((int)(qr[s]).size()); ++i) {
    int v = qr[s][i].first;
    long long val1 = get(1, 0, n - 1, st[v], ft[v] - 1);
    long long val2 = get(1, 0, n - 1, 0, n - 1);
    ans[qr[s][i].second] = (2ll * val1 - val2 + MOD) % MOD;
  }
  for (int i = 0; i < ((int)(adj[s]).size()); ++i) {
    int v = adj[s][i].first, w = adj[s][i].second;
    if (v == pr) continue;
    upd(1, 0, n - 1, 0, n - 1, w);
    upd(1, 0, n - 1, st[v], ft[v] - 1, -2 * w);
    dfs(v, s, w);
  }
  if (pr != -1) {
    upd(1, 0, n - 1, 0, n - 1, -c);
    upd(1, 0, n - 1, st[s], ft[s] - 1, 2 * c);
  }
}
int main() {
  ios_base ::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  input();
  dfs_prep(0, -1, 0);
  build(1, 0, n - 1);
  dfs(0, -1, 0);
  for (int i = 0; i < q; ++i) printf("%d\n", ans[i]);
  return 0;
}
