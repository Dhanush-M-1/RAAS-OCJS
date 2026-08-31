#include <bits/stdc++.h>
using namespace std;
const int p = 998244353;
int n, k, a[100102], dp[100102], pre[100102], ap[100102];
int blk, lx[320], rx[320], bel[100102], cn, cnt[100102], laz[320];
int sum[320][100102 << 1], sdp[320];
inline void clr(int x) {
  for (int i = lx[x]; i <= rx[x]; i++) sum[x][cnt[i] + n] = 0;
  sdp[x] = 0;
}
inline void love(int x) {
  for (int i = lx[x]; i <= rx[x]; i++) cnt[i] += laz[x];
  laz[x] = 0;
  for (int i = lx[x]; i <= rx[x]; i++) (sum[x][cnt[i] + n] += dp[i]) %= p;
  for (int i = lx[x]; i <= rx[x]; i++)
    if (cnt[i] <= k) sdp[x] = (sdp[x] + dp[i]) % p;
}
inline void chng(int l, int r, int x) {
  if (l > r) return;
  if (bel[l] == bel[r]) {
    clr(bel[l]);
    for (int i = l; i <= r; i++) cnt[i] += x;
    love(bel[l]);
    return;
  }
  clr(bel[l]);
  for (int i = l; i <= rx[bel[l]]; i++) cnt[i] += x;
  love(bel[l]);
  clr(bel[r]);
  for (int i = lx[bel[r]]; i <= r; i++) cnt[i] += x;
  love(bel[r]);
  for (int i = bel[l] + 1; i < bel[r]; i++) {
    if (x == 1) {
      sdp[i] = (sdp[i] - sum[i][k - laz[i] + n] + p) % p;
      laz[i]++;
    } else {
      laz[i]--;
      sdp[i] = (sdp[i] + sum[i][k - laz[i] + n]) % p;
    }
  }
}
inline int ask(int l, int r) {
  if (bel[l] == bel[r]) {
    int ans = 0;
    for (int i = l; i <= r; i++)
      if (cnt[i] + laz[bel[l]] <= k) ans = (ans + dp[i]) % p;
    return ans;
  }
  int ans = 0;
  for (int i = l; i <= rx[bel[l]]; i++)
    if (cnt[i] + laz[bel[i]] <= k) ans = (ans + dp[i]) % p;
  for (int i = lx[bel[r]]; i <= r; i++)
    if (cnt[i] + laz[bel[i]] <= k) ans = (ans + dp[i]) % p;
  for (int i = bel[l] + 1; i < bel[r]; i++) ans = (ans + sdp[i]) % p;
  return ans;
}
int main() {
  scanf("%d%d", &n, &k);
  blk = sqrt(n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= n; i++) pre[i] = ap[a[i]], ap[a[i]] = i;
  for (int i = 0; i <= n; i++) {
    int j = i;
    while (j <= n && (i / blk) == (j / blk)) j++;
    j--;
    lx[cn] = i, rx[cn] = j;
    for (int ii = i; ii <= j; ii++) bel[ii] = cn;
    cn++;
    i = j;
  }
  dp[0] = 1;
  for (int i = 0; i < cn; i++) love(i);
  for (int i = 1; i <= n; i++) {
    chng(pre[i], i - 1, 1);
    chng(pre[pre[i]], pre[i] - 1, -1);
    clr(bel[i]);
    dp[i] = ask(0, i - 1);
    love(bel[i]);
  }
  printf("%d\n", dp[n]);
}
