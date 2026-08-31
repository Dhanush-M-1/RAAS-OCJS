#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
int ans[4];
int res[4];
bool Find;
bool calc() {
  if (ans[0] + ans[1] != r1) return false;
  if (ans[2] + ans[3] != r2) return false;
  if (ans[0] + ans[2] != c1) return false;
  if (ans[1] + ans[3] != c2) return false;
  if (ans[0] + ans[3] != d1) return false;
  if (ans[1] + ans[2] != d2) return false;
  for (int i = 0; i < 4; i++) {
    res[i] = ans[i];
  }
  return true;
}
void dfs(int bit) {
  if (Find) return;
  if (bit == 4) {
    if (calc()) Find = true;
    return;
  }
  for (int i = 1; i <= 9; i++) {
    ans[bit] = i;
    dfs(bit + 1);
  }
}
int main() {
  while (~scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2)) {
    Find = false;
    dfs(0);
    if (Find) {
      if (res[0] != res[1] && res[0] != res[2] && res[0] != res[3] &&
          res[1] != res[2] && res[1] != res[3] && res[2] != res[3]) {
        printf("%d %d\n", res[0], res[1]);
        printf("%d %d\n", res[2], res[3]);
      } else {
        printf("-1\n");
      }
    } else {
      printf("-1\n");
    }
  }
  return 0;
}
