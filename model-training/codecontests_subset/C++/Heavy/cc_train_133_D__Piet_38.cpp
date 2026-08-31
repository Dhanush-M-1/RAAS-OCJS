#include <bits/stdc++.h>
using namespace std;
long long n, m, k, d[5][2][100][100];
char a[100][100];
bool was[100][100];
string s;
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> s;
    m = s.length();
    for (int j = 0; j < m; j++) a[i][j] = s[j];
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      if (!was[i][j]) {
        int ii = i, jj = j;
        while (ii < n && a[ii][j] == a[i][j]) ii++;
        ii--;
        while (jj < m && a[i][jj] == a[i][j]) jj++;
        jj--;
        for (int g = i; g <= ii; g++)
          for (int h = j; h <= jj; h++) {
            was[g][h] = true;
            d[1][0][g][h] = ii * 100 + jj;
            d[1][1][g][h] = i * 100 + jj;
            d[2][0][g][h] = ii * 100 + j;
            d[2][1][g][h] = ii * 100 + jj;
            d[3][0][g][h] = i * 100 + j;
            d[3][1][g][h] = ii * 100 + j;
            d[4][0][g][h] = i * 100 + jj;
            d[4][1][g][h] = i * 100 + j;
          }
      }
  int in = 0, jn = 0, cp = 1, dp = 1, iin, jjn;
  while (k) {
    bool flag = false;
    k--;
    iin = in, jjn = jn;
    in = d[dp][cp][iin][jjn] / 100;
    jn = d[dp][cp][iin][jjn] % 100;
    if (dp == 1 && jn < m - 1 && a[in][jn + 1] != '0')
      jn++, flag = true;
    else if (dp == 2 && in < n - 1 && a[in + 1][jn] != '0')
      in++, flag = true;
    else if (dp == 3 && jn > 0 && a[in][jn - 1] != '0')
      jn--, flag = true;
    else if (dp == 4 && in > 0 && a[in - 1][jn] != '0')
      in--, flag = true;
    if (!flag)
      if (cp == 1)
        cp = 0;
      else
        cp = 1, dp = dp % 4 + 1;
  }
  cout << a[in][jn];
  return 0;
}
