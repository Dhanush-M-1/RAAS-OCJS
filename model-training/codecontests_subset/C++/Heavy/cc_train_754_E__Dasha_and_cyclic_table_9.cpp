#include <bits/stdc++.h>
using namespace std;
const int N = (int)404;
const int ALPHA = 26;
bitset<N> b[ALPHA][N];
char a[N][N];
bitset<N> ans[N];
bitset<N> get(const bitset<N>& b, int len, int shift) {
  assert(0 <= shift && shift < len);
  return (b >> shift) | (b << (len - shift));
}
int main() {
  int n, m, r, c;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    char str[N];
    scanf("%s", str);
    for (int j = 0; j < m; j++) {
      b[(int)(str[j] - 'a')][i][j] = true;
    }
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < n; i++) {
    ans[i] = ~ans[i];
  }
  for (int i = 0; i < r; i++) {
    scanf("%s", a[i]);
    for (int j = 0; j < c; j++) {
      if (a[i][j] == '?') continue;
      int c = a[i][j] - 'a', xx = (((-i) % n) + n) % n,
          yy = (((j) % m) + m) % m;
      for (int x = 0; x < n; x++) {
        int nx = (x + xx);
        if (nx >= n) nx -= n;
        ans[nx] &= get(b[c][x], m, yy);
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      putchar(ans[i][j] ? '1' : '0');
    }
    puts("");
  }
  return 0;
}
