#include <bits/stdc++.h>
using namespace std;
const int N = 100;
inline int Read(int &r) {
  int b = 1, c = getchar();
  r = 0;
  while (c < '0' || '9' < c) b = c == '-' ? -1 : b, c = getchar();
  while ('0' <= c && c <= '9')
    r = (r << 1) + (r << 3) + (c ^ '0'), c = getchar();
  return r *= b;
}
int n, m, ndel, cas, tra[N][N], rem[N], del[N];
long long f[N][N];
struct DATA {
  int key, add, id;
  DATA() {}
  DATA(const int &_key, const int &_add, const int &_id)
      : key(_key), add(_add), id(_id) {}
  inline friend bool operator<(const DATA &A, const DATA &B) {
    return A.add < B.add;
  }
} da[N];
int main() {
  Read(cas);
  while (cas--) {
    Read(n), Read(m);
    for (int i = 1, key, add; i <= n; i++) {
      Read(key), Read(add);
      da[i] = DATA(key, add, i);
    }
    sort(da + 1, da + 1 + n);
    memset(f, -0x3f, sizeof f);
    f[0][0] = 0;
    for (int i = 1; i <= n; i++)
      for (int j = 0; j <= i && j <= m; j++) {
        f[i][j] = f[i - 1][j] + 1ll * (m - 1) * da[i].add;
        tra[i][j] = 0;
        long long tmp = f[i - 1][j - 1] + (j - 1ll) * da[i].add + da[i].key;
        if (j && f[i][j] <= tmp) f[i][j] = tmp, tra[i][j] = 1;
      }
    ndel = 0;
    for (int i = n, j = m; i; j -= tra[i][j], i--)
      if (tra[i][j])
        rem[j] = da[i].id;
      else
        del[++ndel] = da[i].id;
    printf("%d\n", m + 2 * ndel);
    bool first = true;
    for (int i = 1; i < m; i++) {
      if (first)
        first = false;
      else
        putchar(' ');
      printf("%d", rem[i]);
    }
    for (int i = 1; i <= ndel; i++) {
      if (first)
        first = false;
      else
        putchar(' ');
      printf("%d -%d", del[i], del[i]);
    }
    if (first)
      first = false;
    else
      putchar(' ');
    printf("%d\n", rem[m]);
  }
  return 0;
}
