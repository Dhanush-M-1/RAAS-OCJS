#include <bits/stdc++.h>
using namespace std;
char n[30];
int D[30][10], T[30][10], sol[10][33];
int c[] = {0, 4, 7};
int main() {
  int tests;
  scanf("%d\n", &tests);
  while (tests--) {
    memset(n, 0, sizeof(n));
    scanf("%s", n + 1);
    int l = strlen(n + 1);
    memset(D, 0, sizeof(D));
    memset(T, 0, sizeof(T));
    memset(sol, 0, sizeof(sol));
    D[l + 1][0] = 1;
    for (int i = l + 1; i >= 2; --i) {
      for (int j = 0; j < 10; ++j) {
        if (!D[i][j]) continue;
        int p = 0;
        for (int a1 = 0; a1 < 3; ++a1) {
          for (int a2 = a1; a2 < 3; ++a2) {
            for (int a3 = a2; a3 < 3; ++a3) {
              for (int a4 = a3; a4 < 3; ++a4) {
                for (int a5 = a4; a5 < 3; ++a5) {
                  for (int a6 = a5; a6 < 3; ++a6) {
                    ++p;
                    int s = c[a1] + c[a2] + c[a3] + c[a4] + c[a5] + c[a6];
                    s += j;
                    int cat = s / 10;
                    int rest = s - cat * 10;
                    if (rest == n[i - 1] - '0') {
                      D[i - 1][cat] = p;
                      T[i - 1][cat] = j;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (!D[1][0]) {
      printf("%d\n", -1);
      continue;
    }
    int cat = 0;
    for (int i = 1; i <= l; ++i) {
      int p = D[i][cat];
      for (int a1 = 0; a1 < 3 && p; ++a1) {
        for (int a2 = a1; a2 < 3 && p; ++a2) {
          for (int a3 = a2; a3 < 3 && p; ++a3) {
            for (int a4 = a3; a4 < 3 && p; ++a4) {
              for (int a5 = a4; a5 < 3 && p; ++a5) {
                for (int a6 = a5; a6 < 3 && p; ++a6) {
                  --p;
                  if (!p) {
                    sol[1][i] = c[a1], sol[2][i] = c[a2], sol[3][i] = c[a3];
                    sol[4][i] = c[a4], sol[5][i] = c[a5], sol[6][i] = c[a6];
                  }
                }
              }
            }
          }
        }
      }
      cat = T[i][cat];
    }
    for (int i = 1; i <= 6; ++i) {
      int x = 1;
      while (x < l && sol[i][x] == 0) ++x;
      for (int j = x; j <= l; ++j) {
        printf("%d", sol[i][j]);
      }
      printf(" ");
    }
    printf("\n");
  }
  return 0;
}
