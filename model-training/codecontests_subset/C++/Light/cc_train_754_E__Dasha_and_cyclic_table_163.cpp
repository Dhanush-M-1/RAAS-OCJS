#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int N = 1e5 + 20;
const double eps = 1e-8;
int n, m;
int r, c;
char a[410][410];
char b[410][410];
bitset<410> ans[410];
bitset<410> G[28][410];
int main() {
  while (cin >> n >> m) {
    getchar();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char c = getchar();
        a[i][j] = c;
        ans[i][j] = G[c - 'a'][i][j] = 1;
      }
      getchar();
    }
    cin >> r >> c;
    getchar();
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        char t = getchar();
        if (t == '?') continue;
        for (int k = 0; k < n; k++) {
          ans[(k - i + 400 * n) % n] &=
              (G[t - 'a'][k] >> (j % m)) | (G[t - 'a'][k] << (m - j % m));
        }
      }
      getchar();
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) printf("%c", ans[i][j] ? '1' : '0');
      printf("\n");
    }
  }
  return 0;
}
