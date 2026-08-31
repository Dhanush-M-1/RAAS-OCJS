#include <bits/stdc++.h>
using namespace std;
int a, b, c, d, e, f, g, h, i, j, k;
int len;
int T;
bool F[26][12];
char w[26];
pair<int, int> qq[26][12];
pair<int, int> GG[26][12];
int an[26][12];
void Get_An(int x, int y) {
  int ii, jj, kk;
  if (x == 0) return;
  kk = 0;
  for (ii = 1; ii <= GG[x][y].first; ii++) an[x - 1][++kk] = 4;
  for (ii = 1; ii <= GG[x][y].second; ii++) an[x - 1][++kk] = 7;
  Get_An(qq[x][y].first, qq[x][y].second);
}
void Work() {
  memset(F, false, sizeof(F));
  for (i = 1; i <= len / 2; i++) swap(w[i], w[len + 1 - i]);
  F[1][0] = true;
  for (i = 1; i <= len; i++)
    for (j = 0; j <= 9; j++)
      if (F[i][j]) {
        for (c = 0; c <= 6; c++)
          for (d = 6 - c; d >= 0; d--) {
            e = j + c * 4 + d * 7;
            if (e % 10 == w[i] - '0' && F[i + 1][e / 10] == false) {
              F[i + 1][e / 10] = true;
              qq[i + 1][e / 10] = make_pair(i, j);
              GG[i + 1][e / 10] = make_pair(c, d);
            }
          }
      }
  if (F[len + 1][0]) {
    memset(an, 0, sizeof(an));
    Get_An(len + 1, 0);
    for (i = 1; i <= 6; i++) {
      k = len;
      while (k > 1 && an[k][i] == 0) k--;
      for (j = k; j >= 1; j--) printf("%d", an[j][i]);
      cout << " ";
    }
    cout << endl;
  } else
    cout << -1 << endl;
}
int main() {
  cin >> T;
  while (T--) {
    scanf("%s", w + 1);
    len = strlen(w + 1);
    Work();
  }
  return 0;
}
