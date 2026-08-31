#include <bits/stdc++.h>
using namespace std;
const int D[3] = {0, 4, 7};
int dt[20][5][6];
char dat[32];
int precalc[729][6], tt;
int presum[729];
int main() {
  for (int a = 0; a < 3; a++)
    for (int b = a; b < 3; b++)
      for (int c = b; c < 3; c++)
        for (int d = c; d < 3; d++)
          for (int e = d; e < 3; e++)
            for (int f = e; f < 3; f++)
              precalc[tt][0] = D[a], precalc[tt][1] = D[b],
              precalc[tt][2] = D[c], precalc[tt][3] = D[d],
              precalc[tt][4] = D[e], precalc[tt][5] = D[f], tt++;
  for (int i = 0; i < tt; i++)
    presum[i] = accumulate(precalc[i], precalc[i] + 6, 0);
  int t;
  scanf("%d", &t);
  while (t-- > 0) {
    scanf("%s", dat);
    int n = strlen(dat);
    memset(dt, -1, sizeof(dt));
    for (int i = 0; i < 6; i++) dt[0][0][i] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= 4; j++) {
        if (dt[i][j][0] == -1) continue;
        int newval = j * 10 + dat[i] - '0';
        for (int state = 0; state < tt; state++) {
          int curval = newval - presum[state];
          if (curval >= 0 && curval <= 4) {
            memcpy(dt[i + 1][curval], precalc[state], sizeof(*precalc));
          }
        }
      }
    }
    if (dt[n][0][0] == -1) {
      printf("-1\n");
      continue;
    }
    int rem = 0;
    vector<char> ans[6];
    for (int i = n; i > 0; i--) {
      int *curdt = dt[i][rem];
      for (int k = 0; k < 6; k++) {
        ans[k].push_back(curdt[k] + '0');
        rem += curdt[k];
      }
      rem -= dat[i - 1] - '0';
      rem /= 10;
    }
    for (int i = 0; i < 6; i++) {
      bool notzero = false;
      for (int j = 0; j < ans[i].size(); j++) {
        char curc = ans[i].rbegin()[j];
        if (curc != '0') notzero = true;
        if (notzero) printf("%c", curc);
      }
      if (!notzero) printf("0");
      printf(i == 5 ? "\n" : " ");
    }
  }
  return 0;
}
