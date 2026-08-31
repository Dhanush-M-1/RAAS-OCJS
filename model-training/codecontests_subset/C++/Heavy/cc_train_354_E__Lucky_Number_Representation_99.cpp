#include <bits/stdc++.h>
using namespace std;
int qi[20], si[20];
long long x;
int ok, mx;
void dfs(long long x, int k) {
  if (x == 0) {
    ok = 1;
    mx = k - 1;
    return;
  }
  int u = x % 10;
  for (int i = 0; i <= 6; i++)
    for (int j = 0; j <= 6 - i; j++) {
      int tmp = i * 4 + j * 7;
      if (tmp % 10 == u && x >= tmp) {
        si[k] = i;
        qi[k] = j;
        dfs((x - tmp) / 10, k + 1);
        if (ok) return;
      }
    }
}
int main() {
  int T;
  cin >> T;
  while (T--) {
    memset(qi, 0, sizeof(qi));
    memset(si, 0, sizeof(si));
    ok = 0;
    cin >> x;
    dfs(x, 0);
    if (!ok) {
      printf("-1\n");
    } else {
      for (int num = 1; num <= 6; num++) {
        while (mx && si[mx] == 0 && qi[mx] == 0) mx--;
        for (int i = mx; i >= 0; i--) {
          if (si[i]) {
            printf("4");
            si[i]--;
          } else if (qi[i]) {
            printf("7");
            qi[i]--;
          } else
            printf("0");
        }
        if (num < 6)
          printf(" ");
        else
          printf("\n");
      }
    }
  }
}
