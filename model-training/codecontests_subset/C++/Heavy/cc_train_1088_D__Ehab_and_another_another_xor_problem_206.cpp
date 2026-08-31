#include <bits/stdc++.h>
const int INF = 0x3f3f3f3f;
const int maxn = 2e4 + 10;
const int mod = 1e9 + 7;
const int MOD = 998244353;
const double eps = 1e-7;
using namespace std;
int a[50], b[50], ans1, ans2, pre, lastt;
int main() {
  printf("? %d %d\n", 0, 0);
  fflush(stdout);
  scanf("%d", &lastt);
  pre = 0;
  for (int i = 29; i >= 0; --i) {
    int op1, op2, tmp = 1 << i;
    printf("? %d %d\n", pre + tmp, 0);
    fflush(stdout);
    scanf("%d", &op1);
    printf("? %d %d\n", pre, tmp);
    fflush(stdout);
    scanf("%d", &op2);
    if (op1 != op2) {
      if (op1 == -1)
        a[i] = 1, b[i] = 1;
      else
        a[i] = 0, b[i] = 0;
    } else {
      if (lastt == 1)
        a[i] = 1, b[i] = 0;
      else
        a[i] = 0, b[i] = 1;
      lastt = op1;
      pre += tmp;
    }
  }
  for (int i = 29; i >= 0; --i) {
    ans1 += a[i] * (1 << i);
    ans2 += b[i] * (1 << i);
  }
  printf("! %d %d\n", ans1, ans2);
  fflush(stdout);
  return 0;
}
