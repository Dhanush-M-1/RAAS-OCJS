#include <bits/stdc++.h>
using namespace std;
const int Mod = 998244353;
int add(int a, int b) { return a + b >= Mod ? a + b - Mod : a + b; }
void Add(int &a, int b) { a = add(a, b); }
int dec(int a, int b) { return a - b < 0 ? a - b + Mod : a - b; }
void Dec(int &a, int b) { a = dec(a, b); }
const int N = 1e5 + 50, M = 300, A = 1e5;
int n, k, S, ct, a[N], pre[N], blk[N], dp[N];
int b[N], t[M], bin[M][N + A], sm[M], L[N], R[N];
void ins(int u, int vl) {
  int p = blk[u];
  Add(sm[p], vl);
  Add(bin[p][b[u] - t[p] + A], vl);
}
void mdf(int i, int lp, int v) {
  if (b[i] + t[lp] <= k) Dec(sm[lp], dp[i - 1]);
  Dec(bin[lp][b[i] + A], dp[i - 1]);
  b[i] += v;
  if (b[i] + t[lp] <= k) Add(sm[lp], dp[i - 1]);
  Add(bin[lp][b[i] + A], dp[i - 1]);
}
void add(int l, int r, int v) {
  if (l > r) return;
  int lp = blk[l], rp = blk[r];
  if (blk[l] == blk[r]) {
    for (int i = l; i <= r; i++) mdf(i, lp, v);
    return;
  }
  for (int i = l; i <= R[lp]; i++) mdf(i, lp, v);
  for (int i = L[rp]; i <= r; i++) mdf(i, rp, v);
  for (int i = lp + 1; i < rp; i++) {
    if (v > 0)
      Dec(sm[i], bin[i][k - t[i] + A]);
    else
      Add(sm[i], bin[i][k - t[i] + 1 + A]);
    t[i] += v;
  }
}
int qry(int p) {
  int ans = 0, c = 0;
  for (; c <= ct && R[c] <= p; c++) Add(ans, sm[c]);
  if (c > ct) return ans;
  for (int i = L[c]; i <= p; i++)
    if (b[i] + t[c] <= k) Add(ans, dp[i - 1]);
  return ans;
}
int main() {
  scanf("%d%d", &n, &k);
  S = 350;
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  static int ls[N];
  for (int i = 1; i <= n; i++) pre[i] = ls[a[i]], ls[a[i]] = i;
  for (int i = 1; i <= n; i++) blk[i] = (i - 1) / S + 1;
  for (int i = 1; i <= n; i += S) L[++ct] = i, R[ct] = i + S - 1;
  R[ct] = n;
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    ins(i, dp[i - 1]);
    add(pre[i] + 1, i, 1);
    add(pre[pre[i]] + 1, pre[i], -1);
    dp[i] = qry(i);
  }
  cout << dp[n];
  return 0;
}
