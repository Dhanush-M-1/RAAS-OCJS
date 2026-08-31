#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int mod = 1000000007;
const double eps = 1e-8;
const double pi = acos(-1.0);
void file() {
  freopen("in.txt", "r", stdin);
  freopen("out.txt", "w", stdout);
}
const int maxn = 105;
int a, b;
int op[2];
int judge(int c, int d) {
  int res;
  printf("? %d %d\n", c, d);
  fflush(stdout);
  scanf("%d", &res);
  return res;
}
namespace BakuretsuMahou {
void Explosion() {
  int flag = ((judge(a, b) < 0) ? 0 : 1);
  for (int i = 30; i >= 1; i--) {
    int x = judge(a ^ (1 << (i - 1)), b);
    int y = judge(a, b ^ (1 << (i - 1)));
    if (x == y) {
      if (flag)
        a ^= (1 << (i - 1));
      else
        b ^= (1 << (i - 1));
      flag = (x == 1);
    } else if (x == -1 && y == 1)
      a ^= (1 << (i - 1)), b ^= (1 << (i - 1));
  }
  printf("! %d %d\n", a, b);
}
}  // namespace BakuretsuMahou
int main() {
  BakuretsuMahou::Explosion();
  return 0;
}
