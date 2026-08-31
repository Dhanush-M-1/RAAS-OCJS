#include <bits/stdc++.h>
using namespace std;
const int N = 105;
int n, s;
struct Data {
  int res, van;
  friend bool operator<(Data x, Data y) { return x.van > y.van; }
} a[N];
int sum, p, f[N][N * N];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i].res), s += a[i].res;
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i].van);
  sort(a + 1, a + n + 1);
  for (int i = 1; i <= n; ++i) {
    sum += a[i].van;
    if (sum >= s) {
      p = i;
      printf("%d ", i);
      break;
    }
  }
  memset(f, -1, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; ++i)
    for (int j = s - a[i].res; j >= 0; --j)
      for (int k = i - 1; k >= 0; --k)
        if (~f[k][j])
          f[k + 1][j + a[i].res] =
              max(f[k + 1][j + a[i].res], f[k][j] + a[i].van);
  for (int i = s; i >= 0; --i)
    if (f[p][i] >= s) {
      printf("%d\n", s - i);
      return 0;
    }
}
