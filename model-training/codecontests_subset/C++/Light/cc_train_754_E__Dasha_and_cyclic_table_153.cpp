#include <bits/stdc++.h>
using namespace std;
const int N = (int)404;
const int ALPHA = 26;
bitset<N> b[ALPHA][N];
char patt[N][N];
bitset<N> result[N];
bitset<N> getShifted(const bitset<N>& b, int len, int shift) {
  assert(0 <= shift && shift < len);
  return (b >> shift) | (b << (len - shift));
}
int main() {
  int n, m, r, c;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    static char str[N];
    scanf("%s", str);
    for (int j = 0; j < m; j++) {
      b[(int)(str[j] - 'a')][i][j] = true;
    }
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < n; i++) {
    result[i] = ~result[i];
  }
  for (int i = 0; i < r; i++) {
    scanf("%s", patt[i]);
    for (int j = 0; j < c; j++) {
      if (patt[i][j] == '?') continue;
      int c = patt[i][j] - 'a';
      int shiftByX = (((-i) % n) + n) % n;
      int shiftByY = (((j) % m) + m) % m;
      for (int x = 0; x < n; x++) {
        int nx = (x + shiftByX);
        if (nx >= n) nx -= n;
        result[nx] &= getShifted(b[c][x], m, shiftByY);
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      putchar(result[i][j] ? '1' : '0');
    }
    puts("");
  }
}
