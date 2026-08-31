#include <bits/stdc++.h>
using namespace std;
int TC;
long long N;
bool used[100];
int P[100][7];
char D[100];
int L;
bool Chk[20][20];
long long Res[20][20][7];
void init() {
  memset(Chk, 0, sizeof Chk);
  memset(Res, 0, sizeof Chk);
}
void solve() {
  int i, j, k;
  int f, s;
  init();
  for (i = 0; i <= D[1]; i++)
    if (used[i]) {
      Chk[1][D[1] - i] = 1;
      for (j = 0; j < 6; j++) Res[1][D[1] - i][j] = P[i][j];
    }
  for (i = 2; i <= L; i++)
    for (j = 0; j < 50; j++)
      if (used[j]) {
        for (k = 0; k < 10; k++)
          if (Chk[i - 1][k]) {
            int val = 10 * k + D[i] - j;
            if (0 <= val && val < 10) {
              Chk[i][val] = 1;
              for (int x = 0; x < 6; x++)
                Res[i][val][x] = Res[i - 1][k][x] * 10 + P[j][x];
            }
          }
      }
  if (!Chk[L][0]) {
    puts("-1");
  } else {
    for (i = 0; i < 6; i++)
      printf("%I64d%c", Res[L][0][i], (i == 5) ? '\n' : ' ');
    long long sum = 0;
    for (i = 0; i < 6; i++) sum += Res[L][0][i];
    assert(sum == N);
  }
}
int main() {
  int i, j, k;
  int f, z;
  for (z = 0; z <= 6; z++)
    for (f = 0; f <= 6 - z; f++) {
      int s = 6 - (z + f);
      int a = 4 * f + 7 * s;
      used[a] = 1;
      for (i = 0; i < z; i++) P[a][i] = 0;
      for (i = z; i < z + f; i++) P[a][i] = 4;
      for (i = z + f; i < 6; i++) P[a][i] = 7;
    }
  scanf("%d", &TC);
  while (TC--) {
    scanf("%s", D + 1);
    sscanf(D + 1, "%I64d", &N);
    L = strlen(D + 1);
    for (i = 1; i <= L; i++) D[i] -= '0';
    solve();
  }
  return 0;
}
