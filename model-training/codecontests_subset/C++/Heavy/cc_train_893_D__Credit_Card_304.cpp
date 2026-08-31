#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int maxn = 1e5 + 10;
const int inf = 0x3f3f3f3f;
const double eps = 1e-14;
const double pi = acos(-1.0);
int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
int a[maxn];
int main() {
  int n, d;
  while (~scanf("%d%d", &n, &d)) {
    for (int i = 0; i < n; i++) scanf("%d", &a[i]);
    int minn = 0, maxx = 0;
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (!a[i]) {
        if (minn < 0) minn = 0;
        if (maxx < 0) {
          maxx = d, res++;
        }
      } else {
        minn += a[i];
        maxx += a[i];
        if (minn > d) {
          printf("-1\n");
          return 0;
        }
        if (maxx > d) maxx = d;
      }
    }
    printf("%d\n", res);
  }
  return 0;
}
