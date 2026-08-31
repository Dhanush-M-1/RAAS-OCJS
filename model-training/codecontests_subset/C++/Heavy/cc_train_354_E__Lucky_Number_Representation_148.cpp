#include <bits/stdc++.h>
using namespace std;
long long tg, ans[22];
int state[22][22], fa_inc[22][22], fa_n4[22][22], fa_n7[22][22];
int t, cs = 0, dg[22];
int main() {
  scanf("%d", &t);
  for (cs = 1; cs <= t; ++cs) {
    scanf("%I64d", &tg);
    for (int i = 0; i < 19; ++i) dg[i] = tg % 10, tg /= 10;
    state[0][0] = cs;
    for (int i = 0; i < 19; ++i) {
      for (int j = 0; j < 10; ++j) {
        if (state[i][j] != cs) continue;
        for (int n4 = 0; n4 <= 6; ++n4) {
          for (int n7 = 0; n7 + n4 <= 6; ++n7) {
            int nj = (j + n4 * 4 + n7 * 7);
            if (nj % 10 == dg[i]) {
              state[i + 1][nj / 10] = cs;
              fa_inc[i + 1][nj / 10] = j;
              fa_n4[i + 1][nj / 10] = n4;
              fa_n7[i + 1][nj / 10] = n7;
            }
          }
        }
      }
    }
    if (state[19][0] == cs) {
      for (int i = 0; i < 6; ++i) ans[i] = 0;
      for (int i = 19, j = 0; i > 0; --i) {
        int n4 = fa_n4[i][j], n7 = fa_n7[i][j];
        for (int pos = 0; pos < 6; ++pos) {
          ans[pos] *= 10;
          if (pos < n4)
            ans[pos] += 4;
          else if (pos < n4 + n7)
            ans[pos] += 7;
        }
        j = fa_inc[i][j];
      }
      for (int i = 0; i < 5; ++i) printf("%I64d ", ans[i]);
      printf("%I64d\n", ans[5]);
    } else
      puts("-1");
  }
  return 0;
}
