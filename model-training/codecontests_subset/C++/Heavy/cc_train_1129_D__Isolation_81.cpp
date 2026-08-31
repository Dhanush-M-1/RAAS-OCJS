#include <bits/stdc++.h>
using namespace std;
const int MOD = 998244353;
const int MAXN = 100005;
const int S = 320;
const int MAXB = MAXN / S + 5;
int pool[MAXB][MAXN << 1], *t[MAXB], f[MAXB][S], tag[MAXB], sum[MAXB], dp[MAXN];
int a[MAXN], last[MAXN], pre[MAXN];
int n, k;
void init() {
  for (int i = 1; i <= n; i++) {
    pre[i] = last[a[i]];
    last[a[i]] = i;
  }
  for (int i = 0; i <= n / S; i++) t[i] = pool[i + 1];
  dp[0] = 1;
}
inline void add(int &a, int b) {
  a += b;
  if (a >= MOD) a -= MOD;
  if (a < 0) a += MOD;
}
void modify(int p, int v) {
  int id = p / S, x = p % S;
  add(t[id][f[id][x]], -dp[p - 1]);
  if (f[id][x] + tag[id] <= k) add(sum[id], -dp[p - 1]);
  f[id][x] += v;
  add(t[id][f[id][x]], dp[p - 1]);
  if (f[id][x] + tag[id] <= k) add(sum[id], dp[p - 1]);
}
void add(int l, int r, int v) {
  while (l <= r && l % S != 0) {
    modify(l, v);
    ++l;
  }
  while (l <= r && (r + 1) % S != 0) {
    modify(r, v);
    --r;
  }
  for (int i = l; i <= r; i += S) {
    if (v == 1)
      add(sum[i / S], -t[i / S][k - tag[i / S]]);
    else
      add(sum[i / S], t[i / S][k + 1 - tag[i / S]]);
    tag[i / S] += v;
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> k;
  for (int i = 1; i <= n; i++) cin >> a[i];
  init();
  for (int i = 1; i <= n; i++) {
    add(pre[i] + 1, i - 1, 1);
    if (pre[i] != 0) add(pre[pre[i]] + 1, pre[i], -1);
    add(sum[i / S], dp[i - 1]);
    add(t[i / S][1], dp[i - 1]);
    add(f[i / S][i % S], 1);
    for (int j = 0; j <= i / S; j++) add(dp[i], sum[j]);
  }
  cout << dp[n] << endl;
  return 0;
}
