#include <bits/stdc++.h>
using namespace std;
bitset<404> b[26][404];
bitset<404> ans[404];
char s[404];
bitset<404> Shift(const bitset<404>& b, int len, int shift) {
  return (b >> shift) | (b << (len - shift));
}
int main() {
  int n, m, r, c;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%s", s);
    for (int j = 0; j < m; j++) b[s[j] - 'a'][i][j] = 1;
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < n; i++) ans[i] = ~ans[i];
  for (int i = 0; i < r; i++) {
    scanf("%s", s);
    for (int j = 0; j < c; j++) {
      if (s[j] == '?') continue;
      int c = s[j] - 'a', X = (2333 * n - i) % n, Y = (2333 * m + j) % m;
      for (int x = 0; x < n; x++) {
        int nx = x + X;
        if (nx >= n) nx -= n;
        ans[nx] &= Shift(b[c][x], m, Y);
      }
    }
  }
  for (int i = 0; i < n; i++, puts(""))
    for (int j = 0; j < m; j++) putchar(ans[i][j] ? '1' : '0');
  return 0;
}
