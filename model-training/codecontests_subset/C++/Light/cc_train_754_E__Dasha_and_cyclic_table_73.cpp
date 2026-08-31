#include <bits/stdc++.h>
using namespace std;
const long long inf = 1LL << 61;
const long long mod = 1000000007;
const int maxn = 404;
bitset<maxn> cb[30][maxn];
bitset<maxn> ans[maxn];
bitset<maxn> shift(bitset<maxn> b, int len, int sh);
int main() {
  std::ios::sync_with_stdio(false);
  int i = 0, j = 0, k = 0;
  int n, m, c, r;
  scanf("%d%d", &n, &m);
  getchar();
  for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++) {
      char ch = getchar();
      cb[ch - 'a'][i][j] = true;
    }
    getchar();
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++) {
      ans[i][j] = true;
    }
  }
  scanf("%d%d", &r, &c);
  getchar();
  for (i = 0; i < r; i++) {
    for (j = 0; j < c; j++) {
      char ch = getchar();
      if (ch == '?') continue;
      int shiftx = ((-i) % n + n) % n;
      int shifty = j % m;
      for (k = 0; k < n; k++) {
        int nk = k + shiftx;
        if (nk >= n) nk -= n;
        ans[nk] &= shift(cb[ch - 'a'][k], m, shifty);
      }
    }
    getchar();
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++) {
      printf("%d", ans[i][j] ? 1 : 0);
    }
    puts("");
  }
  return 0;
}
bitset<maxn> shift(bitset<maxn> b, int len, int sh) {
  return (b >> sh) | (b << (len - sh));
}
