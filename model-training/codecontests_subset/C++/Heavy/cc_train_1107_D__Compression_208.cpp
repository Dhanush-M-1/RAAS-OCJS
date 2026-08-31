#include <bits/stdc++.h>
using namespace std;
int n, mp[5250][5250], cnt, ans = 2e9, f[5250][5250], fac[5250];
char s[5250];
void pt_mp() {
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) printf("%d", mp[i][j]);
    puts("");
  }
}
int S(int x, int y, int xx, int yy) {
  return f[xx][yy] + f[x - 1][y - 1] - f[x - 1][yy] - f[xx][y - 1];
}
bool check(int x) {
  for (int i = 1; i <= n; i += x) {
    for (int j = 1; j <= n; j += x) {
      int tmp = S(i, j, i + x - 1, j + x - 1);
      if (!(!tmp || tmp == x * x)) return 0;
    }
  }
  return 1;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++)
    if (n % i == 0) fac[++cnt] = i;
  for (int i = 1; i <= n; i++) {
    scanf("%s", s);
    int cnt = 0;
    for (int j = 0, x; j < strlen(s); j++) {
      if (s[j] >= '0' && s[j] <= '9')
        x = s[j] - '0';
      else
        x = s[j] - 'A' + 10;
      for (int k = 3; k >= 0; k--) {
        cnt++;
        if ((1 << k) & x) mp[i][cnt] = 1;
      }
    }
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      f[i][j] = f[i][j - 1] + f[i - 1][j] - f[i - 1][j - 1] + mp[i][j];
  for (int i = cnt; i; i--) {
    if (check(fac[i])) {
      printf("%d", fac[i]);
      return 0;
    }
  }
}
