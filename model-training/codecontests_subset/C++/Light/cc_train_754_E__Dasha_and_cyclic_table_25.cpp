#include <bits/stdc++.h>
using namespace std;
const int N = 402;
int n, m, r, c;
char a[N][N], b[N][N];
bitset<N> first[26][N], ans[N];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i <= n - 1; ++i)
    for (int j = 0; j <= m - 1; ++j) {
      scanf(" %c", &a[i][j]);
      first[a[i][j] - 'a'][i][j] = 1;
    }
  scanf("%d%d", &r, &c);
  for (int i = 0; i <= r - 1; ++i)
    for (int j = 0; j <= c - 1; ++j) scanf(" %c", &b[i][j]);
  for (int i = 0; i <= n - 1; ++i) ans[i].set();
  for (int i = 0; i <= r - 1; ++i)
    for (int j = 0; j <= c - 1; ++j)
      if (b[i][j] != '?')
        for (int x = 0; x <= n - 1; ++x)
          ans[((x - i) % n + n) % n] &=
              (first[b[i][j] - 'a'][x] >> (j % m)) |
              (first[b[i][j] - 'a'][x] << (m - j % m));
  for (int i = 0; i <= n - 1; ++i) {
    for (int j = 0; j <= m - 1; ++j) printf("%d", ans[i][j] & 1);
    puts("");
  }
}
