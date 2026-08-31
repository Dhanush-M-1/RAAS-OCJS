#include <bits/stdc++.h>
int q, sum[320][2 * 320], tot[320];
int dp[100009], last[100009], last2[100009], v[100009];
inline void add(int &a, int b) {
  a += b;
  if (a >= 998244353) a -= 998244353;
}
inline void update(int t) {
  memset(sum[t], 0, sizeof sum[t]);
  int cnt = 0;
  for (int i = t * q + q; i > t * q; i--) {
    cnt += v[i];
    add(sum[t][cnt + q], dp[i - 1]);
  }
  tot[t] = cnt;
  for (int i = 1; i <= 2 * q; i++) add(sum[t][i], sum[t][i - 1]);
}
int main() {
  int n, k;
  fscanf(stdin, "%d%d", &n, &k);
  dp[0] = 1;
  q = sqrt(n);
  for (int i = 1; i <= n; i++) {
    int x;
    fscanf(stdin, "%d", &x);
    v[i] = 1;
    if (last2[x]) {
      v[last2[x]] = 0;
      if ((last2[x] - 1) / q < (i - 1) / q) update((last2[x] - 1) / q);
    }
    if (last[x]) {
      v[last[x]] = -1;
      if ((last[x] - 1) / q < (i - 1) / q) update((last[x] - 1) / q);
    }
    last2[x] = last[x];
    last[x] = i;
    int cnt = 0, lim = (i - 1) / q * q;
    for (int j = i; j > lim; j--) {
      cnt += v[j];
      if (cnt <= k) add(dp[i], dp[j - 1]);
    }
    for (int p = (i - 1) / q - 1; p >= 0; p--) {
      if (k - cnt >= -q) {
        if (k - cnt <= q)
          add(dp[i], sum[p][k - cnt + q]);
        else
          add(dp[i], sum[p][2 * q]);
      }
      cnt += tot[p];
    }
    if (i % q == 0) update((i - 1) / q);
  }
  fprintf(stdout, "%d\n", dp[n]);
  fclose(stdin);
  fclose(stdout);
  return 0;
}
