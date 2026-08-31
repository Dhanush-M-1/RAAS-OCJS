#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10,
          mon[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int n, m, x, y, z, a[3][13][32], mx, ans;
char s[N];
inline bool check(int y, int m, int d) {
  if (y < 2013 || y > 2015) return 0;
  if (m <= 0 || m > 12) return 0;
  if (d <= 0 || d > mon[m]) return 0;
  return 1;
}
int main() {
  scanf("%s", s);
  for (int i = 0; s[i + 9]; ++i)
    if (s[i] != '-' && s[i + 1] != '-' && s[i + 2] == '-' && s[i + 3] != '-' &&
        s[i + 4] != '-' && s[i + 5] == '-' && s[i + 6] != '-' &&
        s[i + 7] != '-' && s[i + 8] != '-' && s[i + 9] != '-') {
      x = (s[i] - 48) * 10 + s[i + 1] - 48;
      y = (s[i + 3] - 48) * 10 + s[i + 4] - 48;
      z = (s[i + 6] - 48) * 1000 + (s[i + 7] - 48) * 100 +
          (s[i + 8] - 48) * 10 + s[i + 9] - 48;
      if (check(z, y, x))
        if (++a[z - 2013][y][x] > mx) mx = a[z - 2013][y][x], ans = i;
    }
  for (int i = ans; i <= ans + 9; ++i) putchar(s[i]);
  return 0;
}
