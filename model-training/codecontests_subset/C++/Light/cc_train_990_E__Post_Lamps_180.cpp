#include <bits/stdc++.h>
const long long maxn = 1000010;
bool impossible[maxn];
long long cnt[maxn];
int main() {
  std::ios_base::sync_with_stdio(0);
  std::cin.tie(0);
  std::cout.tie(0);
  long long n, m, k;
  std::cin >> n >> m >> k;
  for (long long i = 1, tmp; i <= m; i++) {
    std::cin >> tmp;
    impossible[tmp] = 1;
  }
  if (impossible[0]) {
    std::cout << "-1\n";
    return 0;
  }
  long long base = 0;
  for (long long i = 1; i <= n; i++)
    if (impossible[i - 1])
      base = std::max(cnt[i] = cnt[i - 1] + 1, base);
    else
      cnt[i] = 0;
  long long ans = 0x3f3f3f3f3f3f3f3f;
  for (long long i = 1, val; i <= k; i++) {
    std::cin >> val;
    if (i <= base) continue;
    long long tmp = 0;
    for (long long j = 1; j <= n; j += i, ++tmp)
      if (impossible[j - 1]) j -= cnt[j];
    ans = std::min(tmp * val, ans);
  }
  if (ans == 0x3f3f3f3f3f3f3f3f)
    std::cout << "-1\n";
  else
    std::cout << ans << "\n";
}
