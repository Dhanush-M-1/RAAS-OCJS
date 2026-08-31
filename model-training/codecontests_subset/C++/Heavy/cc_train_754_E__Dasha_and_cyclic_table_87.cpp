#include <bits/stdc++.h>
using namespace std;
int n, m, nn, mm, i, j, d, cc, dd, dda, ddb, da, db, dt;
unsigned long long ans[405][7], xx[26][405][7], one[65][65];
char x[405];
int main() {
  memset(ans, -1, sizeof(ans));
  for (int a = (0); a < (64); a++)
    one[0][a + 1] = one[0][a] + (((unsigned long long)1) << a);
  for (int a = (1); a < (65); a++)
    for (int b = (0); b < (65); b++) one[a][b] = one[0][b] << a;
  scanf("%d%d", &n, &m);
  for (int a = (0); a < (n); a++) {
    scanf("%s", x);
    i = j = 0;
    for (int b = (0); b < (m); b++) {
      xx[x[b] - 'a'][a][i] |= (((unsigned long long)1) << j);
      if (++j == 64) i++, j = 0;
    }
  }
  scanf("%d%d", &nn, &mm);
  for (int a = (0); a < (nn); a++) {
    scanf("%s", x);
    for (int b = (0); b < (mm); b++)
      if (x[b] != '?') {
        x[b] -= 'a';
        cc = n - a % n;
        if (cc == n) cc = 0;
        for (int c = (0); c < (n); c++) {
          d = da = db = 0;
          dd = m - b % m;
          if (dd == m) dd = 0;
          dda = dd / 64;
          ddb = dd % 64;
          while (d != m) {
            if (ddb > db)
              dt = 64 - ddb;
            else
              dt = 64 - db;
            if (dd + dt > m) dt = m - dd;
            if (d + dt > m) dt = m - d;
            if (ddb < db)
              ans[cc][dda] &=
                  ((xx[x[b]][c][da] >> (db - ddb)) | (~one[ddb][dt]));
            else if (ddb > db)
              ans[cc][dda] &=
                  ((xx[x[b]][c][da] << (ddb - db)) | (~one[ddb][dt]));
            else
              ans[cc][dda] &= (xx[x[b]][c][da] | (~one[ddb][dt]));
            dd += dt, d += dt;
            if ((db += dt) == 64) da++, db = 0;
            if ((ddb += dt) == 64) dda++, ddb = 0;
            if (dd == m) dd = dda = ddb = 0;
          }
          if (++cc == n) cc = 0;
        }
      }
  }
  for (int a = (0); a < (n); a++) {
    i = j = 0;
    for (int b = (0); b < (m); b++) {
      printf((ans[a][i] & (((unsigned long long)1) << j)) ? "1" : "0");
      if (++j == 64) i++, j = 0;
    }
    printf("\n");
  }
  return 0;
}
