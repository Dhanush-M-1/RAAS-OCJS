#include <bits/stdc++.h>
using namespace std;
const int N = 405;
bitset<N> b[26][N];
bitset<N> res[N];
char p[N][N];
bitset<N> cyclic_shift_right(const bitset<N> &b, int len, int shift) {
  return (b >> shift) | (b << (len - shift));
}
int main() {
  int n, m, r, c;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) {
    char s[N];
    scanf("%s", s);
    for (int j = 0; j < m; j++) {
      b[s[j] - 'a'][i][j] = true;
    }
  }
  scanf("%d %d", &r, &c);
  for (int i = 0; i < n; i++) res[i] = ~res[i];
  for (int i = 0; i < r; i++) {
    scanf("%s", p[i]);
    for (int j = 0; j < c; j++) {
      if (p[i][j] == '?') continue;
      int a = p[i][j] - 'a';
      int dx = (-i % n + n) % n, dy = (j % m + m) % m;
      for (int x = 0; x < n; x++) {
        int nx = (x + dx) % n;
        res[nx] &= cyclic_shift_right(b[a][x], m, dy);
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      putchar(res[i][j] ? '1' : '0');
    }
    puts("");
  }
  return 0;
}
