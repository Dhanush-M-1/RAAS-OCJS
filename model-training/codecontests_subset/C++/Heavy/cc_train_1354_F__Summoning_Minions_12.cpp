#include <bits/stdc++.h>
using namespace std;
template <typename T, typename S>
inline void chkmin(T &a, const S &b) {
  a = a < b ? a : b;
}
template <typename T, typename S>
inline void chkmax(T &a, const S &b) {
  a = a > b ? a : b;
}
const int MAXN = 80;
struct Data {
  int a, b, id;
} dat[MAXN];
int f[MAXN][MAXN], g[MAXN][MAXN], ans[MAXN], T, n, K;
bool cmp(const Data &a, const Data &b) { return a.b < b.b; }
int main() {
  for (scanf("%d", &T); T--;) {
    scanf("%d%d", &n, &K);
    for (int i = 1; i <= n; i++) {
      scanf("%d%d", &dat[i].a, &dat[i].b);
      dat[i].id = i;
    }
    sort(dat + 1, dat + 1 + n, cmp);
    memset(f, 0xc0, sizeof(f));
    f[0][0] = 0;
    memset(g, 0, sizeof(g));
    memset(ans, 0, sizeof(ans));
    for (int i = 1; i <= n; i++) {
      int a = dat[i].a, b = dat[i].b;
      for (int j = 1; j <= i && j <= K; j++) {
        int x = f[i - 1][j - 1] + a + b * (j - 1),
            y = f[i - 1][j] + b * (K - 1);
        f[i][j] = max(x, y);
        g[i][j] = x >= y ? 0 : 1;
      }
      f[i][0] = f[i - 1][0] + b * (K - 1);
      g[i][0] = 1;
    }
    for (int i = n, j = K; i > 0; i--) {
      if (g[i][j])
        ans[i] = 1;
      else
        --j;
    }
    printf("%d\n", n + n - K);
    int cnt = 0;
    for (int i = 1; i <= n; i++)
      if (!ans[i] && ++cnt < K) printf("%d ", dat[i].id);
    assert(cnt == K);
    for (int i = 1; i <= n; i++)
      if (ans[i]) printf("%d %d ", dat[i].id, -dat[i].id);
    for (int i = n; i > 0; i--)
      if (!ans[i]) {
        printf("%d\n", dat[i].id);
        break;
      }
  }
  return 0;
}
