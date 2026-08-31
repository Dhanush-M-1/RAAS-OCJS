#include <bits/stdc++.h>
using namespace std;
inline void read(int &x) {
  int v = 0, f = 1;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-')
    f = -1;
  else
    v = (c & 15);
  while (isdigit(c = getchar())) v = (v << 1) + (v << 3) + (c & 15);
  x = v * f;
}
inline void read(long long &x) {
  long long v = 0ll, f = 1ll;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-')
    f = -1;
  else
    v = (c & 15);
  while (isdigit(c = getchar())) v = (v << 1) + (v << 3) + (c & 15);
  x = v * f;
}
inline void readc(char &x) {
  char c;
  while (((c = getchar()) == ' ') || c == '\n')
    ;
  x = c;
}
const int mod = 998244353;
int n, m, i, j, blk, bel[100005], a[100005], dp[100005], lst[100005],
    cnt[100005], pos[100005];
int sum[455][100005], ans[455], tag[455];
void upd(int x, int y) {
  int t = bel[x];
  sum[t][cnt[x]] = (sum[t][cnt[x]] - dp[x] + mod) % mod;
  if (cnt[x] + tag[t] <= m) ans[t] = (ans[t] - dp[x] + mod) % mod;
  cnt[x] += y;
  sum[t][cnt[x]] = (sum[t][cnt[x]] + dp[x]) % mod;
  if (cnt[x] + tag[t] <= m) ans[t] = (ans[t] + dp[x]) % mod;
}
void update(int l, int r, int x) {
  if (l > r) return;
  int i;
  if (bel[l] == bel[r]) {
    for ((i) = (l); (i) <= (r); (i)++) upd(i, x);
    return;
  }
  while (bel[l] == bel[l + 1]) {
    upd(l, x);
    l++;
  }
  while (bel[r] == bel[r - 1]) {
    upd(r, x);
    r--;
  }
  upd(l, x);
  l++;
  upd(r, x);
  r--;
  for ((i) = (bel[l]); (i) <= (bel[r]); (i)++) {
    if (x > 0 && m - tag[i] >= 0) {
      ans[i] = (ans[i] - sum[i][m - tag[i]] + mod) % mod;
    }
    tag[i] += x;
    if (x < 0 && m - tag[i] >= 0) {
      ans[i] = (ans[i] + sum[i][m - tag[i]]) % mod;
    }
  }
}
int main() {
  read(n);
  read(m);
  blk = sqrt(n);
  bel[0] = 1;
  for (((i)) = (1); ((i)) <= ((n)); ((i))++) {
    read(a[i]);
    bel[i] = i / blk + 1;
  }
  dp[0] = sum[1][0] = ans[1] = 1;
  for (((i)) = (1); ((i)) <= ((n)); ((i))++) {
    lst[i] = pos[a[i]];
    update(lst[lst[i]], lst[i] - 1, -1);
    update(lst[i], i - 1, 1);
    for (j = i - 1; j >= 0 && bel[j] == bel[i]; j--) {
      if (cnt[j] + tag[bel[j]] <= m) {
        dp[i] = (dp[i] + dp[j]) % mod;
      }
    }
    for (j = bel[i] - 1; j; j--) {
      dp[i] = (dp[i] + ans[j]) % mod;
    }
    sum[bel[i]][0] = (sum[bel[i]][0] + dp[i]) % mod;
    if (tag[bel[i]] <= m) {
      ans[bel[i]] = (ans[bel[i]] + dp[i]) % mod;
    }
    pos[a[i]] = i;
  }
  cout << dp[n] << endl;
  return 0;
}
