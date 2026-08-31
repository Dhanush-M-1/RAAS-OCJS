#include <bits/stdc++.h>
using namespace std;
int a[20];
bool f[20][20];
int t[20][20][2];
vector<int> res[10];
int cal(int x) {
  int res = 0;
  for (int i = 1; i <= 6; i++) {
    if (x % 3 == 0)
      res += 0;
    else if (x % 3 == 1)
      res += 4;
    else
      res += 7;
    x /= 3;
  }
  return res;
}
int main() {
  int o;
  scanf("%d", &o);
  while (o--) {
    long long s;
    int r = 0;
    cin >> s;
    while (s) {
      a[++r] = s % 10;
      s /= 10;
    }
    memset(f, 0, sizeof(f));
    f[1][0] = true;
    for (int i = 1; i <= r; i++)
      for (int j = 0; j < 5; j++)
        if (f[i][j]) {
          for (int k4 = 0; k4 <= 6; k4++)
            for (int k7 = 0; k7 + k4 <= 6; k7++) {
              int tmp = k4 * 4 + k7 * 7 + j;
              if (tmp % 10 == a[i]) {
                f[i + 1][tmp / 10] = true;
                t[i + 1][tmp / 10][0] = k4;
                t[i + 1][tmp / 10][1] = k7;
              }
            }
        }
    if (f[r + 1][0] == false)
      printf("-1\n");
    else {
      int x = r + 1, y = 0;
      for (int i = 1; i <= 6; i++) res[i].clear();
      while (x > 1) {
        int k4 = t[x][y][0], k7 = t[x][y][1];
        int sum = k4 * 4 + k7 * 7;
        for (int i = 1; i <= k4; i++) res[i].push_back(4);
        for (int i = k4 + 1; i <= k4 + k7; i++) res[i].push_back(7);
        for (int i = k4 + k7 + 1; i <= 6; i++) res[i].push_back(0);
        x--;
        y = a[x] - sum + 10 * y;
      }
      for (int i = 1; i <= 6; i++) {
        bool t = false;
        for (int j = 0; j < res[i].size(); j++) {
          if (res[i][j] == 0) {
            if (t == true) printf("0");
          } else {
            t = true;
            printf("%d", res[i][j]);
          }
        }
        if (t == false) printf("0");
        printf("%c", i == 6 ? '\n' : ' ');
      }
    }
  }
}
