#include <bits/stdc++.h>
using namespace std;
const int maxn = 405;
char S[maxn][maxn];
bitset<maxn> B[27][maxn], R[maxn];
int n, m, r, c;
bitset<maxn> Shifted(const bitset<maxn> &b, int len, int shift) {
  return ((b >> shift) | (b << (len - shift)));
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; ++i) {
    scanf("%s", S[i]);
    for (int j = 0; j < m; ++j) B[S[i][j] - 'a'][i][j] = 1;
  }
  for (int i = 0; i < n; ++i) R[i] = ~R[i];
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; ++i) scanf("%s", S[i]);
  for (int i = 0; i < r; ++i)
    for (int j = 0; j < c; ++j) {
      if (S[i][j] == '?') continue;
      int ch = S[i][j] - 'a';
      int shiftByX = ((-i) % n + n) % n;
      int shiftByY = ((+j) % m + m) % m;
      for (int x = 0; x < n; ++x) {
        int nx = (x + shiftByX);
        if (nx >= n) nx -= n;
        R[nx] &= Shifted(B[ch][x], m, shiftByY);
      }
    }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j)
      if (R[i][j])
        putchar('1');
      else
        putchar('0');
    putchar('\n');
  }
  return 0;
}
