#include <bits/stdc++.h>
using namespace std;
char mp[300][300];
int n;
void solve() {
  int cnt = 0;
  if ((mp[1][2] - '0') && (mp[2][1] - '0')) {
    cnt = 0;
    if (mp[n][n - 1] - '0') {
      cnt++;
    }
    if (mp[n - 1][n] - '0') {
      cnt++;
    }
    printf("%d\n", cnt);
    if (mp[n][n - 1] - '0') {
      printf("%d %d\n", n, n - 1);
    }
    if (mp[n - 1][n] - '0') {
      printf("%d %d\n", n - 1, n);
    }
  } else if (!(mp[1][2] - '0') && !(mp[2][1] - '0')) {
    cnt = 0;
    if (!(mp[n][n - 1] - '0')) {
      cnt++;
    }
    if (!(mp[n - 1][n] - '0')) {
      cnt++;
    }
    printf("%d\n", cnt);
    if (!(mp[n][n - 1] - '0')) {
      printf("%d %d\n", n, n - 1);
    }
    if (!(mp[n - 1][n] - '0')) {
      printf("%d %d\n", n - 1, n);
    }
  } else if ((mp[1][2] - '0') || (mp[2][1] - '0')) {
    if ((mp[n][n - 1] - '0') && (mp[n - 1][n] - '0')) {
      printf("1\n");
      if (mp[1][2] - '0') {
        printf("1 2\n");
      } else {
        printf("2 1\n");
      }
    } else if (!(mp[n][n - 1] - '0') && !(mp[n - 1][n] - '0')) {
      printf("1\n");
      if (mp[1][2] - '0') {
        printf("2 1\n");
      } else {
        printf("1 2\n");
      }
    } else {
      printf("2\n");
      if (mp[1][2] - '0') {
        printf("2 1\n");
      } else {
        printf("1 2\n");
      }
      if (mp[n][n - 1] - '0') {
        printf("%d %d\n", n, n - 1);
      } else {
        printf("%d %d\n", n - 1, n);
      }
    }
  }
}
int main() {
  int Case = 1;
  scanf("%d", &Case);
  getchar();
  while (Case--) {
    scanf("%d", &n);
    char c = getchar();
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= n; ++j) {
        c = getchar();
        mp[i][j] = c;
      }
      getchar();
    }
    solve();
  }
  return 0;
}
