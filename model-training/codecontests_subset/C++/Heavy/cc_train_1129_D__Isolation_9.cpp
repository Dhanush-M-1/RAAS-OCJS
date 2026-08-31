#include <bits/stdc++.h>
const int N = 1e5 + 5, M = N / 183 + 3;
int bel[N], f[N], g[N], tag[M], s[M][183 + 3 << 1];
inline int read() {
  int now = 0;
  register char c = getchar();
  for (; !isdigit(c); c = getchar())
    ;
  for (; isdigit(c); now = now * 10 + c - 48, c = getchar())
    ;
  return now;
}
void Update(int p, int v) {
  int *s = ::s[bel[p]];
  for (int i = 183; i <= 183 << 1; ++i)
    (s[i] += v) >= 998244353 && (s[i] -= 998244353);
}
void Modify(int p, int v) {
  int bel = ::bel[p], *s = ::s[bel];
  tag[bel] += v;
  for (int i = bel * 183 + 1; i <= p; ++i) {
    if (v == 1)
      (s[g[i] + 183] += 998244353 - f[i - 1]) >= 998244353 &&
          (s[g[i] + 183] -= 998244353);
    else
      (s[g[i] - 1 + 183] += f[i - 1]) >= 998244353 &&
          (s[g[i] - 1 + 183] -= 998244353),
          (s[g[i] - 2 + 183] += f[i - 1]) >= 998244353 &&
              (s[g[i] - 2 + 183] -= 998244353);
    g[i] += v;
  }
}
int Query(int p, int K) {
  int bel = ::bel[p], sum = tag[bel];
  long long res = 0;
  for (int i = bel * 183 + 1; i <= p; ++i) g[i] <= K && (res += f[i - 1]);
  while (bel--) {
    assert(sum >= 0);
    if (std::abs(sum - K) <= 183)
      res += s[bel][K - sum + 183];
    else if (sum < K)
      res += s[bel][183 << 1];
    sum += tag[bel];
  }
  return res % 998244353;
}
int main() {
  static int las[N], pre[N];
  int n = read(), K = read();
  for (int i = 1; i <= n; ++i) bel[i] = (i - 1) / 183;
  f[0] = 1;
  for (int i = 1; i <= n; ++i) {
    int a = read();
    las[i] = pre[a], pre[a] = i;
    Update(i, f[i - 1]), Modify(i, 1);
    if (las[i]) {
      Modify(las[i], -2);
      if (las[las[i]]) Modify(las[las[i]], 1);
    }
    f[i] = Query(i, K);
  }
  printf("%d\n", f[n]);
  return 0;
}
