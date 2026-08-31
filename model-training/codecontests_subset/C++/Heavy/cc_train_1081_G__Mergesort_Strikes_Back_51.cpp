#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int n, k, P;
vector<int> pos;
int cnt[N];
void solve(int l, int r, int k) {
  if (k <= 1 || l == r) {
    if (cnt[r - l + 1] == 0) pos.emplace_back(r - l + 1);
    cnt[r - l + 1]++;
    return;
  }
  int mid = (l + r) / 2;
  solve(l, mid, k - 1);
  solve(mid + 1, r, k - 1);
  return;
}
long long inv[N], sinv[N];
void init(int n = 100000) {
  inv[1] = 1;
  for (int i = 2; i <= n; i++) inv[i] = (P - P / i) * inv[P % i] % P;
  sinv[0] = 0;
  for (int i = 1; i <= n; i++) sinv[i] = (sinv[i - 1] + inv[i]) % P;
  return;
}
long long calc(int x, int y) {
  long long ans = 0;
  for (int i = 1; i <= x; i++) {
    long long res = inv[2] * y % P;
    res = (res - (sinv[i + y] - sinv[i] + P) % P + P) % P;
    ans = (ans + res) % P;
  }
  return ans;
}
int main() {
  scanf("%d%d%d", &n, &k, &P);
  init();
  solve(1, n, k);
  int len = pos.size();
  long long ans = 0;
  for (int i = 0; i < len; i++)
    ans =
        (ans + 1LL * pos[i] * (pos[i] - 1) % P * inv[4] % P * cnt[pos[i]] % P) %
        P;
  for (int i = 0; i < len; i++)
    for (int j = i + 1; j < len; j++)
      ans =
          (ans + calc(pos[i], pos[j]) * cnt[pos[i]] % P * cnt[pos[j]] % P) % P;
  for (int i = 0; i < len; i++)
    ans = (ans + calc(pos[i], pos[i]) * cnt[pos[i]] % P * (cnt[pos[i]] - 1) %
                     P * inv[2] % P) %
          P;
  printf("%lld", ans);
  return 0;
}
