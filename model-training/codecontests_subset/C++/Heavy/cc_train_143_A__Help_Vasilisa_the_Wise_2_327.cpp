#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-6;
const int maxn = 1e5 + 5;
int r1, r2, c1, c2, d1, d2;
int ans[5][5];
int main() {
  while (cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2) {
    int flag = 0;
    for (int i = 1; i <= 9; i++) {
      ans[0][0] = i;
      ans[0][1] = r1 - i;
      ans[1][0] = c1 - i;
      ans[1][1] = c2 - ans[0][1];
      if (ans[0][0] > 9 || ans[0][1] > 9 || ans[1][0] > 9 || ans[1][1] > 9)
        continue;
      if (ans[0][0] <= 0 || ans[0][1] <= 0 || ans[1][0] <= 0 || ans[1][1] <= 0)
        continue;
      if (ans[0][0] == ans[1][1] || ans[0][1] == ans[1][0] ||
          ans[0][0] == ans[1][0] || ans[0][0] == ans[0][1] ||
          ans[0][1] == ans[1][1] || ans[1][0] == ans[1][1])
        continue;
      if (ans[0][0] + ans[1][1] == d1 && ans[0][1] + ans[1][0] == d2 &&
          ans[1][0] + ans[1][1] == r2) {
        printf("%d %d\n%d %d\n", ans[0][0], ans[0][1], ans[1][0], ans[1][1]);
        flag = 1;
        break;
      }
    }
    if (!flag) printf("-1\n");
  }
}
