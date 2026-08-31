#include <bits/stdc++.h>
using namespace std;
const int N = 900;
int n, m, r, c;
bitset<N> vis[26][N], ans[N];
char s[N][N], p[N][N];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; ++i) scanf("%s", s[i]), ans[i].set();
  for (int i = 0; i < 26; ++i) {
    for (int j = 0; j < n + 400; ++j) {
      for (int k = 0; k < m + 400; ++k) {
        vis[i][j][k] = s[j % n][k % m] == i + 'a';
      }
    }
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; ++i) scanf("%s", p[i]);
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j)
      if (p[i][j] != '?') {
        bitset<N>* b = vis[p[i][j] - 'a'];
        for (int x = 0; x < n; ++x) {
          ans[x] &= b[x + i] >> j;
        }
      }
  }
  for (int i = 0; i < n; ++i, putchar('\n'))
    for (int j = 0; j < m; ++j) printf("%d", (bool)ans[i][j]);
  return 0;
}
