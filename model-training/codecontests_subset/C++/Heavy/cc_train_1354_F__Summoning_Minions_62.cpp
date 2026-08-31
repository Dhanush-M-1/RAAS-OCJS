#include <bits/stdc++.h>
const int inf = 0x3f3f3f3f, Inf = 0x7fffffff;
const long long INF = 0x7fffffffffffffff;
__inline__ __attribute__((always_inline)) unsigned int rnd() {
  static unsigned int seed = 416;
  return seed ^= seed >> 5, seed ^= seed << 17, seed ^= seed >> 13;
}
template <typename _Tp>
_Tp gcd(const _Tp &a, const _Tp &b) {
  return (!b) ? a : gcd(b, a % b);
}
template <typename _Tp>
__inline__ __attribute__((always_inline)) _Tp abs(const _Tp &a) {
  return a >= 0 ? a : -a;
}
template <typename _Tp>
__inline__ __attribute__((always_inline)) _Tp max(const _Tp &a, const _Tp &b) {
  return a < b ? b : a;
}
template <typename _Tp>
__inline__ __attribute__((always_inline)) _Tp min(const _Tp &a, const _Tp &b) {
  return a < b ? a : b;
}
template <typename _Tp>
__inline__ __attribute__((always_inline)) void chmax(_Tp &a, const _Tp &b) {
  (a < b) && (a = b);
}
template <typename _Tp>
__inline__ __attribute__((always_inline)) void chmin(_Tp &a, const _Tp &b) {
  (b < a) && (a = b);
}
template <typename _Tp>
__inline__ __attribute__((always_inline)) void read(_Tp &x) {
  char ch(getchar());
  bool f(false);
  while (ch < 48 || ch > 57) f |= ch == 45, ch = getchar();
  x = ch & 15, ch = getchar();
  while (ch >= 48 && ch <= 57)
    x = (((x << 2) + x) << 1) + (ch & 15), ch = getchar();
  if (f) x = -x;
}
template <typename _Tp, typename... Args>
__inline__ __attribute__((always_inline)) void read(_Tp &t, Args &...args) {
  read(t);
  read(args...);
}
__inline__ __attribute__((always_inline)) int read_str(char *s) {
  char ch(getchar());
  while (ch == ' ' || ch == '\r' || ch == '\n') ch = getchar();
  char *tar = s;
  *tar = ch, ch = getchar();
  while (ch != ' ' && ch != '\r' && ch != '\n' && ch != EOF)
    *(++tar) = ch, ch = getchar();
  return tar - s + 1;
}
const int N = 85;
struct node {
  long long a, b;
  int id;
  __inline__ __attribute__((always_inline)) bool operator<(
      const node &o) const {
    return b < o.b;
  }
} a[N];
long long dp[N][N];
bool opt[N][N];
bool used[N];
void MAIN() {
  memset(used, 0, sizeof(used));
  int n, k;
  read(n, k);
  for (int i = 1; i <= n; ++i) {
    read(a[i].a, a[i].b);
    a[i].id = i;
  }
  std::sort(a + 1, a + n + 1);
  if (k == n) {
    printf("%d\n", n);
    for (int i = 1; i <= n; ++i) printf("%d ", a[i].id);
    printf("\n");
    return;
  }
  auto solve = [&](int id) -> long long {
    memset(dp, -63, sizeof(dp));
    memset(opt, 0, sizeof(opt));
    dp[0][0] = 0;
    for (int i = 1; i <= n; ++i) {
      if (i == id) {
        for (int j = 0; j <= k; ++j) {
          dp[i][j] = dp[i - 1][j] + a[i].a + a[i].b * (k - 1);
          opt[i][j] = 0;
        }
        continue;
      }
      dp[i][0] = dp[i - 1][0] + (k - 1) * a[i].b;
      opt[i][0] = 0;
      for (int j = 1; j <= k; ++j) {
        dp[i][j] = dp[i - 1][j] + (k - 1) * a[i].b;
        opt[i][j] = 0;
        long long tmp = dp[i - 1][j - 1] + a[i].a + (j - 1) * a[i].b;
        if (tmp > dp[i][j]) {
          dp[i][j] = tmp;
          opt[i][j] = 1;
        }
      }
    }
    return dp[n][k - 1];
  };
  long long ans = 0;
  int pos = 0;
  for (int i = 1; i <= n; ++i) {
    long long tmp = solve(i);
    if (tmp > ans) {
      ans = tmp;
      pos = i;
    }
  }
  solve(pos);
  fprintf(stderr, "%lld %d\n", ans, pos);
  pos = a[pos].id;
  std::vector<int> v;
  int cur = n, cnt = k - 1;
  while (cur) {
    if (opt[cur][cnt]) {
      --cnt;
      v.push_back(a[cur].id);
      used[a[cur].id] = true;
    }
    --cur;
  }
  std::reverse(v.begin(), v.end());
  std::vector<int> res;
  for (auto it : v) res.push_back(it);
  for (int i = 1; i <= n; ++i) {
    if (!used[i] && i != pos) {
      res.push_back(i);
      res.push_back(-i);
    }
  }
  res.push_back(pos);
  printf("%d\n", ((int)res.size()));
  for (auto it : res) printf("%d ", it);
  printf("\n");
}
int main() {
  int _;
  read(_);
  while (_--) MAIN();
  return 0;
}
