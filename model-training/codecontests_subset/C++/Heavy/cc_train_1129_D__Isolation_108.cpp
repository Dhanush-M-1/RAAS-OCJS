#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
const int S = 330;
const int mod = 998244353;
int n, k, a[N], pre[N], last[N];
int s[N / S + 5][N], val[N / S + 5], f[N], dp[N], inblock[N], ans;
void add(int &x, int y) {
  x += y;
  if (x >= mod) x -= mod;
  if (x < 0) x += mod;
}
void ins(int u, int v) {
  if (f[u] + val[inblock[u]] <= k) add(ans, -dp[u - 1]);
  add(s[inblock[u]][f[u]], -dp[u - 1]);
  f[u] += v;
  if (f[u] + val[inblock[u]] <= k) add(ans, dp[u - 1]);
  add(s[inblock[u]][f[u]], dp[u - 1]);
}
void update(int L, int R, int v) {
  if (L > R) return;
  if (inblock[L] + 1 >= inblock[R])
    for (int i = L; i <= R; i++) ins(i, v);
  else {
    for (int i = L; i <= inblock[L] * S; i++) ins(i, v);
    for (int i = (inblock[R] - 1) * S + 1; i <= R; i++) ins(i, v);
    for (int i = inblock[L] + 1; i < inblock[R]; i++) {
      if (v == 1)
        add(ans, mod - s[i][k - val[i]]);
      else
        add(ans, s[i][k + 1 - val[i]]);
      val[i] += v;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    pre[i] = last[a[i]];
    last[a[i]] = i;
  }
  for (int i = 1; i <= n; i++) inblock[i] = (i - 1) / S + 1;
  dp[0] = 1;
  add(ans, 1);
  add(s[inblock[1]][f[1]], 1);
  for (int i = 1; i <= n; i++) {
    update(pre[i] + 1, i, 1);
    update(pre[pre[i]] + 1, pre[i], -1);
    dp[i] = ans;
    add(ans, dp[i]);
    add(s[inblock[i + 1]][f[i + 1]], dp[i]);
  }
  cout << dp[n];
}
