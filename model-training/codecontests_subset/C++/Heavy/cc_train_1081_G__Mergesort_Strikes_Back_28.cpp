#include <bits/stdc++.h>
using namespace std;
long long P;
long long inv[500005], s[500005];
int n, m;
int len[2], cnt[2];
void add(long long &x, long long y) {
  x += y;
  if (x >= P) x -= P;
  if (x < 0) x += P;
}
void init() {
  inv[0] = inv[1] = 1;
  for (int i = 2; i <= n + m; i++) inv[i] = (P - P / i) * inv[P % i] % P;
  for (int i = 1; i <= n + m; i++) s[i] = (s[i - 1] + inv[i]) % P;
}
long long calc(long long l1, long long l2) {
  long long ans = l1 * l2 % P * inv[2] % P;
  for (int i = 1; i <= l1; i++) add(ans, P - (s[i + l2] - s[i]) % P);
  return ans;
}
long long sum(long long x) { return x * (x - 1) / 2 % P; }
void dfs(int l, int r, int h) {
  if (h <= 1 || l == r) {
    if (!len[0] || r - l + 1 == len[0])
      len[0] = r - l + 1, cnt[0]++;
    else if (!len[1] || r - l + 1 == len[1])
      len[1] = r - l + 1, cnt[1]++;
    return;
  }
  int mid = (l + r) >> 1;
  dfs(l, mid, h - 1), dfs(mid + 1, r, h - 1);
}
int main() {
  cin >> n >> m >> P;
  init();
  dfs(1, n, m);
  long long ans = 0;
  for (int i = 0; i <= 1; i++) {
    add(ans, sum(len[i]) * inv[2] % P * cnt[i] % P);
    add(ans, sum(cnt[i]) * calc(len[i], len[i]) % P);
  }
  add(ans, cnt[0] * cnt[1] % P * calc(len[0], len[1]) % P);
  cout << ans << endl;
  return 0;
}
